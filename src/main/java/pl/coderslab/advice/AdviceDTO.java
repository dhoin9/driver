package pl.coderslab.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.coderslab.question.QuestionDTO;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class AdviceDTO {
    private long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private long popularity;
    private String video;
    private List<QuestionDTO> questions;


}
