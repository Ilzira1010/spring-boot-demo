package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.itis.springbootdemo.models.Category;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class CategoryDto {
    private Long id;
    private String name;

    public static CategoryDto from(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    public static List<CategoryDto> from(List<Category> category) {
        return category.stream().map(CategoryDto::from).collect(Collectors.toList());
    }
}
