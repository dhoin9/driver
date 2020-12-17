package pl.coderslab.advice;

import java.util.List;

public interface AdviceService {

    List<Advice> allAdvice();
    Advice getAdvice(long id);
    Advice topPopularAdvice();
    void saveAdvice(Advice advice);
    Advice newestAdvice();
    AdviceDTO getDTO(Advice advice);
    List<AdviceDTO> getListDTO(List<Advice> list);
}
