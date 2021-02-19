package ru.itis.springbootdemo.services.signUp;

import ru.itis.springbootdemo.dto.SignUpForm;

public interface SignUpService {
    boolean signUp(SignUpForm form);
}
