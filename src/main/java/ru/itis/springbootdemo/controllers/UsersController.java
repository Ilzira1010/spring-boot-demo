package ru.itis.springbootdemo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.services.users.UsersService;

import java.util.List;


//@Controller
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

//    @GetMapping("/users")
//    public String getUsersPage(Model model) {
//        model.addAttribute("usersList", usersService.getAllUsers());
//        return "users_page";
//    }

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getAllUsers() {
//        System.out.println("breakpoint");
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    // GET users/3
    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(usersService.getUserById(userId));
    }

//    @PostMapping("/users")
//    @ResponseBody
//    public ResponseEntity<UserDto> addUser(@RequestBody SignUpForm userForm) {
//        return ResponseEntity.ok(usersService.addUser(userForm));
//    }

    @ApiOperation(value = "Добавление юзера")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = UserDto.class)})
    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(usersService.addUser(user));
    }

    @PutMapping("/users/{user-id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("user-id") Long userId, @RequestBody UserDto user) {
        return ResponseEntity.ok(usersService.updateUser(userId, user));
    }

    @DeleteMapping("/users/{user-id}")
    public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long userId) {
        usersService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}


