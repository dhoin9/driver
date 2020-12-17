package pl.coderslab.question;

import java.util.List;

public interface QuestionService {

    List<Question> allQuestion();
    Question getQuestion(long id);
    List<Question> questionsForAdvice(long advice);
    List<QuestionDTO> getListQuestionDTO(List<Question> list);
    List<AnswerDTO> getListAnswerDTO(List<Answer> list);
    QuestionDTO getQuestionDTO(Question question);
    AnswerDTO getAnswerDTO(Answer answer);

}
