package pl.coderslab.advice;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.question.Question;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private long popularity=0;
    private String video;
    @OneToMany
    private List<Question> question;
    @Column(name = "upload_dir")
    private String uploadDir;



    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", popularity=" + popularity +
                ", video='" + video + '\'' +
                '}';
    }
}
