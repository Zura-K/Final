package main.controller;

import main.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import main.repositories.CategoryRepository;
import main.services.CategoryServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    private final CategoryServiceImplementation categoryServices;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryServices.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryServices.getCategoryById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryServices.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        return categoryServices.updateCategory(id,category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
    }
}