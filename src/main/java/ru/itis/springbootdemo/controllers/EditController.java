package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.models.Podcast;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
import ru.itis.springbootdemo.services.podcast.PodcastService;

@Controller
public class EditController {
    @Autowired
    PodcastService podcastService;

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("podcast", podcastService.getById(id));
        model.addAttribute("user", (user == null) ? null : user.getUser());
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String changeTitle(@RequestParam("title")String title, @PathVariable("id") Long id,
                              @AuthenticationPrincipal UserDetailsImpl user, Model model) {
        title = title == null ? "My Podcast" : title;
        System.out.println(title);
        Podcast podcast = Podcast.builder().title(title).build();
        podcastService.updateTitle(podcast, id);
        return "redirect:/profile";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetailsImpl user, Model model) {
        podcastService.delete(id);
        return "redirect:/profile";
    }
}
