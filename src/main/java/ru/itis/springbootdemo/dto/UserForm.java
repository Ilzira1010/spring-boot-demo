package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class UserForm {
//    private Long id;
    private String nickname;
    private String email;
    private String password;
}
