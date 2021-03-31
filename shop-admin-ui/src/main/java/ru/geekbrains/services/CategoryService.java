package ru.geekbrains.services;

import ru.geekbrains.persist.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAllCategories();

    Optional<Category> findCategoryById(Long id);

    void saveCategory(Category category);

    void deleteCategory(Long id);


}
