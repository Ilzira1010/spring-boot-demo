package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.services.category.CategoryService;
import ru.itis.springbootdemo.services.podcast.PodcastService;

@Controller
public class PodcastCreaterController {
    @Autowired
    private PodcastService podcastService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public String getPodcastsPage(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "create";
    }

//    @PostMapping("/create")
//    public String create(){
//        return null;
//    }

}
