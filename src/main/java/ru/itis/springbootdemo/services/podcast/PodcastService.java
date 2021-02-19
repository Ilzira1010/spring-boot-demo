package ru.itis.springbootdemo.services.podcast;


import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;

import java.util.List;
import java.util.Optional;

public interface PodcastService {
    List<Podcast> getAll();
    List<Podcast> getUserPodcasts(UserDto user);
    List<Podcast> find(String search);
    List<Podcast> findByCategory(String search, Category category);
    Optional<Podcast> getById(long id);
    void safe(Podcast podcast);
    void deleteById(long id);
    void update(Podcast podcast, long id);
}
