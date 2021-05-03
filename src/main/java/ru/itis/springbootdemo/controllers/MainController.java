package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.springbootdemo.models.Podcast;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.podcast.PodcastService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PodcastService podcastService;

    @GetMapping("/main")
    public String getMainPage(@AuthenticationPrincipal UserDetailsImpl user, Model model,
                              @RequestParam(value = "size", required = false) Integer size,
                              @RequestParam(value = "page", required = false) Integer page) {
        if (size == null || page == null) {
            model.addAttribute("podcasts",podcastService.getSizeFromPage(1,0));
            model.addAttribute("next_page",1);
            model.addAttribute("previous_page",0);
        } else {
            List<Podcast> podcasts = podcastService.getSizeFromPage(size,page);
            model.addAttribute("podcasts", podcasts);
            model.addAttribute("next_page",(podcasts.size()!=0)?page+1:page);
            model.addAttribute("previous_page",(page > 0)? page-1:0);
        }
        model.addAttribute("user", (user == null) ? null : user.getUser());
        return "main";
    }

}
