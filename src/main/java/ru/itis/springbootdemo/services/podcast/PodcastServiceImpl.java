package ru.itis.springbootdemo.services.podcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dto.CategoryDto;
import ru.itis.springbootdemo.dto.PodcastDto;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.CategoryRepository;
import ru.itis.springbootdemo.repositories.PodcastRepository;
import ru.itis.springbootdemo.services.fileStorage.FileStorageService;

import java.util.Date;
import java.util.List;

@Component
public class PodcastServiceImpl implements PodcastService {

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public List<PodcastDto> getPodcastBySearchAndCategory(String search, Long category) {
        List<Podcast> podcast = podcastRepository.findAllByTitleStartsWithAndCategory(search, categoryRepository.findById(category).get());
        return PodcastDto.from(podcast);
    }

    @Override
    public List<PodcastDto> getPodcastBySearch(String search) {
        List<Podcast> podcast = podcastRepository.findAllByTitleStartsWith(search);
        return PodcastDto.from(podcast);
    }

    @Override
    public List<PodcastDto> getPodcastByCategory(Long category) {
        List<Podcast> podcast = podcastRepository.findAllByCategory(categoryRepository.findById(category).orElse(null));
        return PodcastDto.from(podcast);
    }

    //im
    @Override
    public List<Podcast> getAll() {
        return podcastRepository.findAll();
    }

    @Override
    public List<PodcastDto> search(String search,Long category) {
        if (!search.isEmpty() && (category != 0)) {
            return getPodcastBySearchAndCategory(search, category);
        } else if (!search.isEmpty()) {
            return getPodcastBySearch(search);
        } else if ((category!= 0)) {
            return getPodcastByCategory(category);
        }
        return null;
    }

    @Override
    public Podcast getById(Long id) {
        return podcastRepository.findById(id).orElse(null);
    }

    @Override
    public void save(MultipartFile image, MultipartFile track, User user, PodcastDto podcastDto) {
        Long idImage = fileStorageService.saveFile(image);
        Long idTrack = fileStorageService.saveFile(track);
        podcastRepository.save(Podcast.builder()
                .category((podcastDto.getCategory()==null)?Category
                        .builder()
                        .id(0L)
                        .name("")
                        .build():
                        podcastDto.getCategory())
                .created_at(new Date())
                .img(idImage)
                .title(podcastDto.getTitle())
                .track(idTrack)
                .user(user)
                .build());
    }

    @Override
    public void updateTitle(Podcast podcast, Long id) {
        Podcast podcast1 = getById(id);
        podcast1.setTitle(podcast.getTitle());
        podcastRepository.save(podcast1);




    }

    @Override
    public void delete(Long id) {
        podcastRepository.delete(getById(id));
    }

    @Override
    public List<Podcast> getAllByUser(User user) {
        return podcastRepository.findAllByUser(user);
    }

    @Override
    public List<Podcast> getSizeFromPage(int size, int page) {
        return podcastRepository.findSizeOnPage(size,page*size);
    }
}

