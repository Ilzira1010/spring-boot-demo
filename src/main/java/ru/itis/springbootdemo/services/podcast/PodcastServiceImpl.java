package ru.itis.springbootdemo.services.podcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.CategoryDto;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;
import ru.itis.springbootdemo.repositories.CategoryRepository;
import ru.itis.springbootdemo.repositories.PodcastRepository;

import java.util.List;

@Component
public class PodcastServiceImpl implements PodcastService {

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<PodcastDto> getPodcastBySearchAndCategory(String search, String category) {
        List<Podcast> podcast = podcastRepository.findAllByTitleStartsWithAndCategory(search, categoryRepository.findByName(category).get());
        return PodcastDto.from(podcast);
    }

    @Override
    public List<PodcastDto> getPodcastBySearch(String search) {
        List<Podcast> podcast = podcastRepository.findAllByTitleStartsWith(search);
        return PodcastDto.from(podcast);
    }

    @Override
    public List<PodcastDto> getPodcastByCategory(String category) {
        List<Podcast> podcast = podcastRepository.findAllByCategory(categoryRepository.findById(Long.parseLong(category)).get());
        return PodcastDto.from(podcast);
    }

    //im
    @Override
    public List<PodcastDto> getAll() {
        return PodcastDto.from(podcastRepository.findAll());
    }
}

