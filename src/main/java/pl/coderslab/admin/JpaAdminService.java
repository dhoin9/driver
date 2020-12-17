package pl.coderslab.admin;

import org.springframework.stereotype.Component;
import pl.coderslab.advice.Advice;
import pl.coderslab.advice.AdviceRepository;
import pl.coderslab.question.Answer;
import pl.coderslab.question.AnswerRepository;
import pl.coderslab.question.Question;
import pl.coderslab.question.QuestionRepository;

@Component
public class JpaAdminService implements AdminService {
    private final AdviceRepository adviceRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public JpaAdminService(AdviceRepository adviceRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.adviceRepository = adviceRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }


    @Override
    public void addAdvice(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);

    }

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }
}
