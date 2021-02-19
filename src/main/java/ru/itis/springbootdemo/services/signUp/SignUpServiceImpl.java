package ru.itis.springbootdemo.services.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(SignUpForm form) {
        User user = User.builder()
                .nickname(form.getNickname())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();
         usersRepository.save(user);
         return true;
    }
}
