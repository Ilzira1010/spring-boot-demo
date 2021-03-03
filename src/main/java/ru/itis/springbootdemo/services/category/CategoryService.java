package ru.itis.springbootdemo.services.category;

import ru.itis.springbootdemo.dto.CategoryDto;
import ru.itis.springbootdemo.models.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
//    CategoryDto getById(long id);
}
