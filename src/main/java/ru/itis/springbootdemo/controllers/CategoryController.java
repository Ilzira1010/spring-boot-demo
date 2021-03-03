//package ru.itis.springbootdemo.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.itis.springbootdemo.dto.CategoryDto;
//import ru.itis.springbootdemo.dto.PodcastDtoForRequest;
//import ru.itis.springbootdemo.models.Category;
//import ru.itis.springbootdemo.services.category.CategoryService;
//
//import java.util.List;
//
//@Controller
//public class CategoryController {
////    @Autowired
////    private PodcastController podcastController;
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @GetMapping("/categories")
//    public String getCategoriesPage(Model model) {
//        return "podcasts";
//    }
//
////    @GetMapping("/podcasts")
////    public String getPodcastsPage(Model model) {
////        model.addAllAttributes("podcastsList", podcastService.getPodcastBySearchAndCategory());
////    }
//
//    @GetMapping("/podcasts/{search}/{category}")
//    @ResponseBody
//    public ResponseEntity<CategoryDto> getPodcasts(@PathVariable("id") Long id, @PathVariable("category")Category category) {
//        if (id !=null && category != null) {
//            return ResponseEntity.ok(categoryService.getById(id));
//        }
//        return null;
//    }
//
////    @PostMapping("/podcasts")
////    public ResponseEntity<List<CategoryDto>> postPodcast(@RequestBody PodcastDtoForRequest podcastDto) {
////        return getPodcasts(podcastDto.getSearch(), podcastDto.getCategory());
////    }
//
////    @GetMapping("/search")
////    public String getSearch() {
////        return "search";
////    }
////
////    @PostMapping("/search")
////    public String search(SignUpForm form) {
////        podcastController.search(form);
////        return "redirect:/search";
////    }
//}
