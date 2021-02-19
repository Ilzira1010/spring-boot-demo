package ru.itis.springbootdemo.services.category;

import ru.itis.springbootdemo.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Optional<Category> getById(long id);
}
