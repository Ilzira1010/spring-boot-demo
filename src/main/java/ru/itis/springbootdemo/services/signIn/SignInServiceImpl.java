package ru.itis.springbootdemo.services.signIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignInForm;

import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;


@Component
public class SignInServiceImpl implements SignInService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    public SignInServiceImpl(UsersRepository usersRepository){
//        this.usersRepository = usersRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }

//    @Override
//    public boolean signIn(SignInForm form) {
////        Optional<User> user = usersRepository.findUserByEmail(form.getEmail());
//
//        if(user.isPresent()){
//            if (passwordEncoder.matches(form.getPassword(), user.get().getHashPassword())) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean signIn(SignInForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();
        usersRepository.save(user);
        return true;
    }
}
