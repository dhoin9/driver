package pl.coderslab.upload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uploadDir;
    private String name;
    private String fullPath;


    public Upload(String uploadDir, String name) {
        this.uploadDir = uploadDir;
        this.name = name;
    }
}
