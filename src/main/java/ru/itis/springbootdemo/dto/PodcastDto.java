package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.models.Podcast;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class PodcastDto {
    private Long id;
    private Category category;
    private String title;
    
    public static PodcastDto from(Podcast podcast) {
        return PodcastDto.builder()
                .id(podcast.getId())
                .category(podcast.getCategory())
                .title(podcast.getTitle())
                .build();
    }
    public static List<PodcastDto> from(List<Podcast> podcast) {
        return podcast.stream().map(PodcastDto::from).collect(Collectors.toList());
    }
}
