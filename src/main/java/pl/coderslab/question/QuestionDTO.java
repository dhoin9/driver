package pl.coderslab.question;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Getter
@AllArgsConstructor
public class QuestionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String image;
    private List<AnswerDTO> answers;


}
