package ru.itis.springbootdemo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Table(name ="podcasts")
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private Long img;
    private Long track;
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    private String search;

    // --------------------------

}
