package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.dto.PodcastDtoForRequest;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.services.podcast.PodcastService;

import java.util.List;

@Controller
public class PodcastController {
//    @Autowired
//    private PodcastController podcastController;

    @Autowired
    private PodcastService podcastService;

    @GetMapping("/podcasts")
    public String getUsersPage(Model model) {
        return "podcasts";
    }

    @GetMapping("/podcasts/{search}/{category}")
    @ResponseBody
    public ResponseEntity<List<PodcastDto>> getPodcasts(@PathVariable("search") String search, @PathVariable("category")Category category) {
        if (search !=null && category != null) {
            return ResponseEntity.ok(podcastService.getPodcastBySearchAndCategory(search, category));
        }
        return null;
    }

    @PostMapping("/podcasts")
    public ResponseEntity<List<PodcastDto>> postPodcast(@RequestBody PodcastDtoForRequest podcastDto) {
        return getPodcasts(podcastDto.getSearch(), podcastDto.getCategory());
    }

//    @GetMapping("/search")
//    public String getSearch() {
//        return "search";
//    }
//
//    @PostMapping("/search")
//    public String search(SignUpForm form) {
//        podcastController.search(form);
//        return "redirect:/search";
//    }
}
