package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.*;
import ru.itis.springbootdemo.security.details.UserDetailsImpl;
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
    public String getPodcastsPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("user", (user == null) ? null : user.getUser());
        model.addAttribute("podcasts", podcastService.getAll());
        return "podcasts";
    }

    @GetMapping("/podcasts/{search}/{category}")
    @ResponseBody
    public ResponseEntity<List<PodcastDto>> getPodcasts(@PathVariable("search") String search, @PathVariable("category") String category) {
        if (!search.isEmpty() && !(category.equals("0"))) {
            return ResponseEntity.ok(podcastService.getPodcastBySearchAndCategory(search, Long.parseLong(category)));
        } else if (!search.isEmpty()) {
            return ResponseEntity.ok(podcastService.getPodcastBySearch(search));
        } else if (!category.equals("0")) {
            return ResponseEntity.ok(podcastService.getPodcastByCategory(Long.parseLong(category)));
        }
        return null;
    }

    @PostMapping("/podcasts")
    @ResponseBody
    public ResponseEntity<List<PodcastDto>> postPodcast(@RequestBody PodcastDtoForRequest podcastDto) {
        return getPodcasts(podcastDto.getTitle(), podcastDto.getCategory());
    }

//    @GetMapping("/podcasts/search")
//    public ResponseEntity<PodcastsPage> search(@RequestParam("size") Integer size,
//                                               @RequestParam("page") Integer page,
//                                               @RequestParam(value = "q", required = false) String query,
//                                               @RequestParam(value = "sort", required = false) String sort,
//                                               @RequestParam(value = "direction", required = false) String direction) {
//        return ResponseEntity.ok(podcastService.search(size,page,query,sort, direction));
//    }
//
//    @GetMapping("/podcasts/{podcast-id}")
//    @ResponseBody
//    public ResponseEntity<PodcastDto> getPodcastById(@PathVariable("podcast-id") Long podcastId) {
//        return ResponseEntity.ok(podcastService.getPodcastById(podcastId));
//    }

}
