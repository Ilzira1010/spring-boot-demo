package ru.itis.springbootdemo.dto;


import lombok.Data;

@Data
public class SignInForm {
    private String email;
    private String password;
}
