package pl.coderslab.admin;

import pl.coderslab.advice.Advice;
import pl.coderslab.question.Answer;
import pl.coderslab.question.Question;

public interface AdminService {


    void addAdvice(Advice advice);
    void addQuestion(Question question);
    void addAnswer(Answer answer);

}
