package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.podcast.PodcastService;

@Controller
public class ProfileController {

    @Autowired
    private PodcastService podcastService;

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
//        String email = userDetails.getUsername();
//        model.addAttribute("email", email);
        model.addAttribute("podcasts", podcastService.getAll());
        return "profile";
    }

//    @GetMapping("/profile")
//    public String getPodcastsPage(Model model) {
//        model.addAttribute("podcasts", podcastService.getAll());
//        return "profile";
//    }

}
