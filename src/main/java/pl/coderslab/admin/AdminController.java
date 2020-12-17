package pl.coderslab.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.advice.Advice;
import pl.coderslab.question.Answer;
import pl.coderslab.question.Question;
import pl.coderslab.question.QuestionRepository;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private final AdminService adminService;
  private final QuestionRepository questionRepository;

    public AdminController(AdminService adminService, QuestionRepository questionRepository) {
        this.adminService = adminService;
      this.questionRepository = questionRepository;
    }
  @ModelAttribute("questions")
  public List<Question> allQuestion() {
    return questionRepository.findAll();
  }
    @GetMapping("/question/new")
    public String addQuestion(Model model) {
      model.addAttribute("question", new Question());
      return "admin/newQuestion";
    }
    @PostMapping("/question/new")
    public String addQuestion(Question question){
      adminService.addQuestion(question);
      return "redirect:/question/"+question.getId();
    }

  @GetMapping("/answer/new")
  public String addAnswer(Model model) {
    model.addAttribute("answer", new Answer());
    return "admin/newAnswer";
  }
  @PostMapping("/answer/new")
  public String addAnswer(Answer answer){
    adminService.addAnswer(answer);
    return "redirect:/question/"+answer.getQuestion().getId();
  }

    @GetMapping("/advice/new")
    public String addAdvice(Model model) {
      model.addAttribute("advice", new Advice());
      return "admin/newAdvice";
    }
  @PostMapping("/advice/new")
  public String addAdvice(Advice advice) {
   adminService.addAdvice(advice);
    return "redirect:/question/"+advice.getId();
  }
}
