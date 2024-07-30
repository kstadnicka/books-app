package org.ks.yourbooks.web;

import org.ks.yourbooks.domain.book.BookService;
import org.ks.yourbooks.domain.book.dto.BookDto;
import org.ks.yourbooks.domain.category.CategoryService;
import org.ks.yourbooks.domain.category.dto.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final BookService bookService;

    public CategoryController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping("/kategoria/{name}")
    public String getCategory(@PathVariable String name, Model model){
        CategoryDto category = categoryService.findCategoryByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<BookDto> books = bookService.findBookByCategoryName(name);
        model.addAttribute("heading", category.getName());
        model.addAttribute("description", category.getDescription());
        model.addAttribute("books", books);
        return "book-listing";
    }

    @GetMapping("/kategorie-ksiazek")
    public String getCategoryList(Model model){
        List<CategoryDto> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "category-listing";
    }
}
