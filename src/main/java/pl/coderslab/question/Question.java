package pl.coderslab.question;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.upload.Upload;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String image;
    @ManyToOne
    private Upload upload;

}
