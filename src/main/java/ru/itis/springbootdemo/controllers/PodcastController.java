package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.dto.PodcastDtoForRequest;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.services.category.CategoryService;
import ru.itis.springbootdemo.services.podcast.PodcastService;

import java.util.List;

@Controller
public class PodcastController {
    @Autowired
    private PodcastService podcastService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/podcasts")
    public String getPodcastsPage(Model model) {
        model.addAllAttributes("categories", categoryService.getAll());
        return "podcasts";
    }

    @GetMapping("/podcasts/{search}/{category}")
    @ResponseBody
    public ResponseEntity<List<PodcastDto>> getPodcasts(@PathVariable("search") String search, @PathVariable("category") String category) {
        if (search != null && category != null) {
            return ResponseEntity.ok(podcastService.getPodcastBySearchAndCategory(search, category));
        } else if (search != null) {
            return ResponseEntity.ok(podcastService.getPodcastBySearch(search));
        } else if (category !=null) {
            return ResponseEntity.ok(podcastService.getPodcastByCategory(category));
        }
        return null;
    }

    @PostMapping("/podcasts")
    @ResponseBody
    public ResponseEntity<List<PodcastDto>> postPodcast(@RequestBody PodcastDtoForRequest podcastDto) {
        return getPodcasts(podcastDto.getSearch(), podcastDto.getCategory().getName());
    }

}
