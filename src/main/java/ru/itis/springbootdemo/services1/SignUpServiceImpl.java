//package ru.itis.springbootdemo.services1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.itis.springbootdemo.dto.SignUpForm;
////import ru.itis.springbootdemo.dto.UserForm;
//import ru.itis.springbootdemo.models.User;
//import ru.itis.springbootdemo.repositories.UsersRepository;
//
//@Component
//public class SignUpServiceImpl implements SignUpService {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void signUp(SignUpForm form) {
//        User newUser = User.builder()
////                .id(form.getId())
//                .nickname(form.getNickname())
//                .email(form.getEmail())
//                .hashPassword(passwordEncoder.encode(form.getPassword()))
//                .build();
//
//        usersRepository.save(newUser);
//    }
//}
