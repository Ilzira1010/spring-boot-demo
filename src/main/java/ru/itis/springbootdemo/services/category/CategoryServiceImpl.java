package ru.itis.springbootdemo.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.CategoryDto;
import ru.itis.springbootdemo.models.Category;
import ru.itis.springbootdemo.repositories.CategoryRepository;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

//    public CategoryServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

//    @Override
//    public List<Category> getAll() {
//        return categoryRepository.getAll();
//    }
    @Override
    public List<CategoryDto> getAll() {
        return CategoryDto.from(categoryRepository.findAll());
    }

}
