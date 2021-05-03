package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;
import ru.itis.springbootdemo.models.User;

import java.util.List;

@Repository
public interface PodcastRepository extends JpaRepository<Podcast, Long> {
    List<Podcast> findAllByTitleStartsWithAndCategory(String search, Category category);
    List<Podcast> findAllByTitleStartsWith(String search);
    List<Podcast> findAllByCategory(Category category);
    List<Podcast> findAllByUser(User user);

    @Query(value =  "select * from podcasts order by id limit :limit offset :offset ;",
            nativeQuery = true)
    List<Podcast> findSizeOnPage(@Param("limit")int limit,@Param("offset")int offset);






}
