package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.category.CategoryService;
import ru.itis.springbootdemo.services.podcast.PodcastService;

@Controller
public class PodcastCreaterController {


    @Autowired
    PodcastService podcastService;


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public String getPodcastsPage(Model model,@AuthenticationPrincipal UserDetailsImpl user) {
        model.addAttribute("categories", categoryService.getAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@AuthenticationPrincipal UserDetailsImpl user, PodcastDto dto,
                         @RequestParam("image") MultipartFile image, @RequestParam("track") MultipartFile track){
       podcastService.save(image,track, user.getUser(),dto);
        return "redirect:/create";
    }


}
