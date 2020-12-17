package pl.coderslab.users2;

import pl.coderslab.advice.Advice;
import pl.coderslab.question.Answer;
import pl.coderslab.question.Question;

import java.util.List;

public interface UserService {

    AppUser findByUserName(String name);

    void saveUser(AppUser appUser);
    void addPoints(CurrentUser currentUser, List<Answer> answers, List<Question> questionsList, Advice advice);
    int checkQuestion(List<Answer> answers);
    int sumPoints(List<Question> questionsList);
}
