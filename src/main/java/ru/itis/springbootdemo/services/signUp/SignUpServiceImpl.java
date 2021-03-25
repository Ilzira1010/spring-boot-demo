package ru.itis.springbootdemo.services.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.mail.MailsService;
import ru.itis.springbootdemo.services.sms.SmsService;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailsService mailsService;

    @Autowired
    private SmsService smsService;

    @Override
    public boolean signUp(SignUpForm form) {
        User newUser = User.builder()
                .nickname(form.getNickname())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();
         usersRepository.save(newUser);
         smsService.sendSms(form.getPhone(), "Вы зарегистрированы!");

         mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
         return true;
    }
}
