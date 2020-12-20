package pl.coderslab.question;

import lombok.Data;
import pl.coderslab.upload.Upload;

import javax.persistence.*;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private boolean correct;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Upload upload;


}
