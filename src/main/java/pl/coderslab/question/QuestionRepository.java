package pl.coderslab.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

     Question getById(long id);
     @Query(value = "SELECT q from Advice a inner join a.question q where a.id=?1 ")
     List<Question> getAllByAdvice(long advice);


}


