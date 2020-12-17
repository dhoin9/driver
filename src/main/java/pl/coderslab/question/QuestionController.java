package pl.coderslab.question;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final AnswerRepository answerRepository;

    public QuestionController(QuestionService questionService, AnswerRepository answerRepository) {
        this.questionService = questionService;
        this.answerRepository = answerRepository;
    }

    @GetMapping("")
    public List<QuestionDTO> allQuestion(){
        return questionService.getListQuestionDTO(questionService.allQuestion());
    }
    @GetMapping("/{id}")
    public QuestionDTO getQuestion(@PathVariable long id){
        return questionService.getQuestionDTO(questionService.getQuestion(id));
    }
    @GetMapping("/{id}/answers")
    public List<AnswerDTO> getAnswers(@PathVariable long id){
        return questionService.getListAnswerDTO(answerRepository.getAllByQuestionId(id));
    }

}
