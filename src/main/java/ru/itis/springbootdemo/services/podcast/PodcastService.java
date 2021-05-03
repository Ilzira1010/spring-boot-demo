package ru.itis.springbootdemo.services.podcast;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dto.CategoryDto;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;
import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface PodcastService {
    List<PodcastDto> getPodcastBySearchAndCategory(String search, Long category);

    List<PodcastDto> getPodcastBySearch(String search);
    List<PodcastDto> getPodcastByCategory(Long category);
    List<Podcast> getAll();
    List<PodcastDto> search(String search,Long category);
    Podcast getById(Long id);
    void save (MultipartFile image, MultipartFile track, User user, PodcastDto podcastDto);

    void updateTitle(Podcast podcast, Long id);

    void delete(Long id);

    List<Podcast> getAllByUser(User user);

    List<Podcast> getSizeFromPage(int size,int page);
}
