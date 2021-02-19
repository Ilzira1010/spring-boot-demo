package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.SignUpForm;
import ru.itis.springbootdemo.services.signUp.SignUpService;


@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpForm form) {
        signUpService.signUp(form);
        return "redirect:/signUp";
    }
}


