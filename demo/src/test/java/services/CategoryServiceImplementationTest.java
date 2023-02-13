package services;

import main.entities.Category;
import main.exceptions.NotFoundException;
import main.services.CategoryServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import main.repositories.CategoryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplementationTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImplementation categoryService;

    @Test
    void getAllCategories_ShouldReturnAllCategories() {
        List<Category> expectedCategories = Arrays.asList(
                new Category(1, 2, "Fruits"),
                new Category(2, 3, "Vegetables")
        );

        when(categoryRepository.findAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getAllCategories();

        assertThat(actualCategories).isEqualTo(expectedCategories);
    }

    @Test
    void getCategoryById_ShouldReturnCategory() {
        Category expectedCategory = new Category(1, 2, "Fruits");

        when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(expectedCategory));

        Category actualCategory = categoryService.getCategoryById(1);

        assertThat(actualCategory).isEqualTo(expectedCategory);
    }

    @Test
    void getCategoryById_ShouldThrowNotFoundException() {
        when(categoryRepository.findById(anyInt())).thenReturn(Optional.empty());

        Throwable thrown = catchThrowable(() -> categoryService.getCategoryById(1));

        assertThat(thrown)
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Product not found");
    }

    @Test
    void addCategory_ShouldReturnCategory() {
        Category expectedCategory = new Category(1, 2, "Fruits");

        when(categoryRepository.save(expectedCategory)).thenReturn(expectedCategory);

        Category actualCategory = categoryService.addCategory(expectedCategory);

        assertThat(actualCategory).isEqualTo(expectedCategory);
    }
}