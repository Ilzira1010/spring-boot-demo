package ru.itis.springbootdemo.services.users;

import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
//    Optional<UserDto> getUserByEmail(String email);
//    List<User> getAll();
//    void addUser(User user);

        List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    UserDto addUser(SignUpForm signUpForm);
}

