package ru.itis.springbootdemo.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.Role;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.springbootdemo.dto.UserDto.*;
//
//@Service
@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Override
//    public List<UserDto> getAllUser() {
//        List<User> user = usersRepository.findAll();
//        return UserDto.from(user);
//    }

//    @Override
//    public List<UserDto> getAllUsers() {
//        return from(usersRepository.findAllByIsDeletedIsNull());
//    }

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
    public UserDto addUser(UserDto userDto) {
        User user = User.builder()
//                .id(userForm.getId())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
//                .hashPassword((passwordEncoder.encode(signUpForm.getPassword())))
                .role(Role.USER)
                .build();
        usersRepository.save(user);
        return from(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto user) {
        User userForUpdate = usersRepository.findById(userId)
                .orElseThrow(IllegalArgumentException::new);
        userForUpdate.setEmail(user.getEmail());
        userForUpdate.setNickname(user.getNickname());
        usersRepository.save(userForUpdate);
        return from(userForUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        User userForDelete = usersRepository.findById(userId)
                .orElseThrow(IllegalArgumentException::new);
        userForDelete.setIsDeleted(true);
        usersRepository.save(userForDelete);
    }
}

