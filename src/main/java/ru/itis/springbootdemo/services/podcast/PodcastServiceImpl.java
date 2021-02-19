//package ru.itis.springbootdemo.services.podcast;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.itis.springbootdemo.dto.UserDto;
//import ru.itis.springbootdemo.models.Category;
//import ru.itis.springbootdemo.models.Podcast;
//import ru.itis.springbootdemo.models.User;
//import ru.itis.springbootdemo.repositories.PodcastRepository;
//
//import java.util.List;
//import java.util.Optional;
//@Component
//public class PodcastServiceImpl implements PodcastService {
//
//    @Autowired
//    private final PodcastRepository podcastRepository;
//
//    public PodcastServiceImpl(PodcastRepository podcastRepository) {
//        this.podcastRepository = podcastRepository;
//    }
//
//    @Override
//    public List<Podcast> getAll() {
//        return podcastRepository.findAll();
//    }
//
//    @Override
//    public List<Podcast> getUserPodcasts(UserDto user) {
//        return podcastRepository.getUserPodcasts(User.builder().id(user.getId()).build());
//
//    }
//
//    @Override
//    public List<Podcast> find(String search) {
//        return podcastRepository.find(search);
//    }
//
//    @Override
//    public List<Podcast> findByCategory(String search, Category category) {
//        return podcastRepository.findByCategory(search, category);
//    }
//
//    @Override
//    public Optional<Podcast> getById(long id) {
//        return Optional.ofNullable(podcastRepository.findById(id));
//    }
//
//    @Override
//    public void safe(Podcast podcast) {
//        podcastRepository.save(podcast);
//    }
//
//    @Override
//    public void deleteById(long id) {
//        podcastRepository.deleteById(id);
//    }
//
//    @Override
//    public void update(Podcast podcast, long id) {
//        podcastRepository.updateById(podcast, id);
//    }
//}
