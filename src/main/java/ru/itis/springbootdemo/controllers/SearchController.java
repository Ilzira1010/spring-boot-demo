package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.SignUpForm;

@Controller
public class SearchController {
    @Autowired
    private SearchController searchController;

    @GetMapping("/search")
    public String getSearch() {
        return "search";
    }

    @PostMapping("/search")
    public String search(SignUpForm form) {
        searchController.signUp(form);
        return "redirect:/search";
    }
}
