package pl.coderslab.advice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AdviceRepository extends JpaRepository<Advice, Long> {

          Advice getAdviceById(long id);
//     Advice getFirstByOrderByPopularity();
//     Advice getFirstByOrderByDataTime();
     @Query(value = "select a from Advice a order by a.dateTime desc")
     List<Advice> getAdviceOrderByDateTime();
     @Query(value = "select a from Advice a order by a.popularity desc")
     List<Advice> getAdviceOrderByPopularity();
}


