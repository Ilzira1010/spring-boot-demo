//package ru.itis.springbootdemo.services.category;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.itis.springbootdemo.models.Category;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class CategoryServiceImpl implements CategoryService {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
////    public CategoryServiceImpl(CategoryRepository categoryRepository) {
////        this.categoryRepository = categoryRepository;
////    }
//
////    @Override
////    public List<Category> getAll() {
////        return categoryRepository.getAll();
////    }
//    @Override
//    public List<Category> getAll() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public Optional<Category> getById(long id) {
//        return categoryRepository.findById(id);
//    }
//
////    @Override
////    public UserDto getUserById(Long userId) {
////        Optional<User> user = usersRepository.findById(userId);
////        return UserDto.from(user.orElse(User.builder().build()));
////    }
//}
