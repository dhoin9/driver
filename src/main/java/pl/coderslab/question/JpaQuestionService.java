package pl.coderslab.question;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.upload.Upload;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary
public class JpaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public JpaQuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Question> allQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(long id) {
        return questionRepository.getById(id);
    }

    @Override
    public List<Question> questionsForAdvice(long advice) {
        return questionRepository.getAllByAdvice(advice);
    }

    @Override
    public List<QuestionDTO> getListQuestionDTO(List<Question> list) {
        return list.stream().
                map(question -> new QuestionDTO(question.getId(), question.getDescription(),
                        question.getImage(), getListAnswerDTO(answerRepository.findAll()))).
                collect(Collectors.toList());

    }

    @Override
    public List<AnswerDTO> getListAnswerDTO(List<Answer> list) {
        return list.stream().
                map(answer -> new AnswerDTO(answer.getId(), answer.getDescription(),
                        path(answer.getUpload()),
                        answer.isCorrect())).
                collect(Collectors.toList());
    }

    @Override
    public QuestionDTO getQuestionDTO(Question question) {
        return new QuestionDTO(question.getId(), question.getDescription(),
                question.getImage(), getListAnswerDTO(answerRepository.findAll()));
    }

    @Override
    public AnswerDTO getAnswerDTO(Answer answer) {
        return new AnswerDTO(answer.getId(), answer.getDescription(),  path(answer.getUpload()),
                answer.isCorrect());
    }

    String path(Upload upload){
        if(upload==null){
            return "no image";
        }else {
            return upload.getFullPath();
        }
    }
}
