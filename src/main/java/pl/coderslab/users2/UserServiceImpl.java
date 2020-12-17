package pl.coderslab.users2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.advice.Advice;
import pl.coderslab.question.Answer;
import pl.coderslab.question.AnswerRepository;
import pl.coderslab.question.Question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AnswerRepository answerRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, AnswerRepository answerRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.answerRepository = answerRepository;
    }
    @Override
    public AppUser findByUserName(String username) {
        return userRepository.findByNick(username);
    }


    @Override
    public void saveUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        appUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(appUser);
    }

    @Override
    public void addPoints(CurrentUser currentUser, List<Answer> answers, List<Question> questionsList, Advice advice) {
        if(checkQuestion(answers)/sumPoints(questionsList)>0.7){
       AppUser user = currentUser.getAppUser();
       user.getPassedAdvice().add(advice);
       System.out.println(user.getPassedAdvice());
       saveUser(user);
    }
    }

    @Override
    public int checkQuestion(List<Answer> answers) {
        int sum = 0;
        for(Answer answer:answers){
            if(answer.isCorrect()==true){
                sum+=1;
            }
        }
        return sum;
    }

    @Override
    public int sumPoints(List<Question> questionsList) {
        int sum=0;
        for (Question question:questionsList)
        for(Answer ans:answerRepository.getAllByQuestionId(question.getId())){
            if(ans.isCorrect()==true)
                sum+=1;
    }
        return sum;
}

}
