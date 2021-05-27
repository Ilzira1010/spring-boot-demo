package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;


@Controller
public class ErrorCreatedController {


    @GetMapping("/error500")
    public String getServerError() {
        throw new IllegalStateException();
    }


    @GetMapping("/error404")
    public String getNotFound() {
        return "redirect:wrong_address" + UUID.randomUUID();
    }

    @GetMapping("/error403")
        public String get403Page() {
            return "error/403";
        }

}