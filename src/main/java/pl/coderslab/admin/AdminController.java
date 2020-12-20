package pl.coderslab.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.advice.Advice;
import pl.coderslab.question.Answer;
import pl.coderslab.question.Question;
import pl.coderslab.question.QuestionRepository;
import pl.coderslab.upload.FileService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private final AdminService adminService;
  private final QuestionRepository questionRepository;
  private final FileService fileService;

    public AdminController(AdminService adminService, QuestionRepository questionRepository, FileService fileService) {
        this.adminService = adminService;
      this.questionRepository = questionRepository;
      this.fileService = fileService;
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
  @ResponseBody
  public String addAnswer(Answer answer){
    adminService.addAnswer(answer);

    return "poszły konie po betonie";
//    return "redirect:/question/"+answer.getQuestion().getId();
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
  @GetMapping("/file/new")
  public String index() {
    return "admin/upload";

  }
  @PostMapping("/file/new")
  @ResponseBody
  public String addFile(@RequestParam("file") MultipartFile file, @RequestParam("dir") String dir ) {
    fileService.uploadFile(file, dir);
    return dir;
  }

//  @PostMapping("/uploadFile")
//  @ResponseBody
//  public String addFile2(@RequestParam("file") MultipartFile file) {
//    System.out.println("failed");
//  fileService.uploadFile(file);
//    return "Poszło";
//  }
}
