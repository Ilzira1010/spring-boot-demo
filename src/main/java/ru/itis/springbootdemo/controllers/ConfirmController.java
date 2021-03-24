package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.services.mail.MailsService;

@Controller
public class ConfirmController {

    @Autowired
    private MailsService mailsService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        //TODO : реализовать сервис для подтверждения (найти по коду человека)
        //TODO : вернуть страницу об успешной прохождении

        mailsService.findUserByCode(code);
        return "confirmed_page";
    }

}
