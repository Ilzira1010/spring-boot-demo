package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Podcast {
    private Long id;
    private User user;
    private String title;
    private String img;
    private String track;
    private Date created_at;
    private Category category;
}
