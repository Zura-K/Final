package controller;

import entities.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public List<Category> getAllCategories() {
        // Implementation to retrieve all categories from database
        return null;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        // Implementation to retrieve category by id from database
        return null;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        // Implementation to add a new category to database
        return null;
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        // Implementation to update an existing category in database
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        // Implementation to delete a category from database
    }
}