package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Category;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PodcastDtoForRequest {
    private String search;
    private Category category;
//    private String title;
}
