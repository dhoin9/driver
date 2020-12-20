package pl.coderslab.users2;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.advice.Advice;
import pl.coderslab.question.Answer;
import pl.coderslab.question.Question;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public String newUser(){
return "hello";
    }

//    @GetMapping("/create-user")
//    @ResponseBody
//    public String createUser() {
//        AppUser appUser = new AppUser();
//        appUser.setNick("admin");
//        appUser.setPassword("admin");
//        userService.saveUser(appUser);
//        return "admin";
//    }

    @PostMapping("/check")
    @ResponseBody
    public String sendAnswers(@AuthenticationPrincipal CurrentUser user, List<Answer> answers, List<Question> questionsList, Advice advice ){
        userService.addPoints(user, answers, questionsList, advice );
    return "git";
    }
}
