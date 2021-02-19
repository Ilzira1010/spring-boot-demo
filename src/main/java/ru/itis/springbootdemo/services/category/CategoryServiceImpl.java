//package ru.itis.springbootdemo.services.category;
//
//import org.hibernate.annotations.Cache;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.itis.springbootdemo.models.Category;
//import ru.itis.springbootdemo.repositories.CategoryRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CategoryServiceImpl implements CategoryService {
//
//    @Autowired
//    private final CategoryRepository categoryRepository;
//
//    public CategoryServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public List<Category> getAll() {
//        return categoryRepository.getAll();
//    }
//
//    @Override
//    public Optional<Category> getById(long id) {
//        return Optional.ofNullable(categoryRepository.getById(id));
//    }
//}
