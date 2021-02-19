package ru.itis.springbootdemo.services.signIn;

import ru.itis.springbootdemo.dto.SignInForm;

public interface SignInService {
    boolean signIn(SignInForm form);
}
