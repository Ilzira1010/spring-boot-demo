package ru.itis.springbootdemo.services.podcast;

import ru.itis.springbootdemo.dto.CategoryDto;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;

import java.util.List;

public interface PodcastService {
    List<PodcastDto> getPodcastBySearchAndCategory(String search, String category);

    List<PodcastDto> getPodcastBySearch(String search);
    List<PodcastDto> getPodcastByCategory(String category);


    //im
    List<PodcastDto> getAll();
}
