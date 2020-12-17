package pl.coderslab.advice;

import org.springframework.stereotype.Component;
import pl.coderslab.question.QuestionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaAdviceService implements AdviceService {
    private final AdviceRepository adviceRepository;
    private final QuestionService questionService;

    public JpaAdviceService(AdviceRepository adviceRepository, QuestionService questionService) {
        this.adviceRepository = adviceRepository;
        this.questionService = questionService;
    }


    @Override
    public List<Advice> allAdvice() {
        return adviceRepository.findAll();
    }

    @Override
    public Advice getAdvice(long id) {
        Advice advice=adviceRepository.getAdviceById(id);
        System.out.println(advice);
        advice.setPopularity(advice.getPopularity()+1);
        adviceRepository.save(advice);
        return advice;
    }

    @Override
    public Advice topPopularAdvice() {
        List<Advice> adviceList= adviceRepository.getAdviceOrderByPopularity();
        return adviceList.get(0);
    }

    @Override
    public void saveAdvice(Advice advice) {
        advice.setDateTime(LocalDateTime.now());
        adviceRepository.save(advice);
    }

    @Override
    public Advice newestAdvice() {
        List<Advice> adviceList= adviceRepository.getAdviceOrderByDateTime();
        return adviceList.get(0);
    }

    @Override
    public AdviceDTO getDTO(Advice advice) {
       return new AdviceDTO(advice.getId(), advice.getTitle(), advice.getDescription(), advice.getDateTime(),
               advice.getPopularity(), advice.getVideo(), questionService.getListQuestionDTO(advice.getQuestion()));}

    @Override
    public List<AdviceDTO> getListDTO(List<Advice> list) {
        return list.stream().
                map(advice -> new AdviceDTO(advice.getId(), advice.getTitle(), advice.getDescription(), advice.getDateTime(),
                        advice.getPopularity(), advice.getVideo(), questionService.getListQuestionDTO(advice.getQuestion()))).
                collect(Collectors.toList());
    }

}
