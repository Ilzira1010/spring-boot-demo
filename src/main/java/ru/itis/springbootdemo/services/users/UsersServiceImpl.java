package ru.itis.springbootdemo.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.models.Role;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.services.users.UsersService;

import java.util.List;
import java.util.Optional;

import static ru.itis.springbootdemo.dto.UserDto.*;
@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> user = usersRepository.findById(userId);
        return UserDto.from(user.orElse(User.builder().build()));
    }

    @Override
    public UserDto addUser(SignUpForm signUpForm) {
        User user = User.builder()
//                .id(userForm.getId())
                .nickname(signUpForm.getNickname())
                .email(signUpForm.getEmail())
//                .hashPassword((passwordEncoder.encode(signUpForm.getPassword())))
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        return from(user);
    }
}

