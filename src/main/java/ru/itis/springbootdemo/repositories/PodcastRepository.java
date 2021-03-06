package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;

import java.util.List;

@Repository
public interface PodcastRepository extends JpaRepository<Podcast, Long> {
    List<Podcast> findAllByTitleStartsWithAndCategory(String search, Category category);
    List<Podcast> findAllByTitleStartsWith(String search);
    List<Podcast> findAllByCategory(Category category);
}
