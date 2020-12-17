package pl.coderslab.advice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.question.Question;

import java.util.List;

@RestController
@RequestMapping("/advice")
public class AdviceController {
    private final AdviceService adviceService;

    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @GetMapping("")
    public List<AdviceDTO> getAll(){
        return adviceService.getListDTO(adviceService.allAdvice());
    }

    @GetMapping("/{id}")
    public AdviceDTO getOne(@PathVariable long id){
        return adviceService.getDTO(adviceService.getAdvice(id));
    }
    @GetMapping("/newest")
    public AdviceDTO getNewest(){
        return adviceService.getDTO(adviceService.newestAdvice());
    }
    @GetMapping("/top")
    public AdviceDTO getTop(){
        return adviceService.getDTO(adviceService.topPopularAdvice());
    }
    @GetMapping("/{id}/questions")
    public List<Question> getQuestions(@PathVariable long id){
        return adviceService.getAdvice(id).getQuestion();
    }

}
