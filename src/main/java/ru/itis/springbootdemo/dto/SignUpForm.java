package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class SignUpForm {
    private String nickname;
    private String email;
    private String password;
    private String phone;
}

