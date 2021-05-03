package ru.itis.springbootdemo.services.users;

import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface UsersService {
//    Optional<UserDto> getUserByEmail(String email);
//    List<User> getAll();
//    void addUser(User user);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    UserDto addUser(UserDto user);

    UserDto updateUser(Long userId, UserDto user);

    void deleteUser(Long userId);
}

