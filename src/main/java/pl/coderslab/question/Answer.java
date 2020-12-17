package pl.coderslab.question;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String image;
    private boolean correct;
    @ManyToOne
    private Question question;
}
