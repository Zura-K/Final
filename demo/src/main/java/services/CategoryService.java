package services;

import entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Integer Id);

    Category addCategory(Category category);

    Category updateCategory(Integer id, Category category);
}
