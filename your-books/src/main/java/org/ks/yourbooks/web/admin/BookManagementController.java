package org.ks.yourbooks.web.admin;

import org.ks.yourbooks.domain.book.BookService;
import org.ks.yourbooks.domain.book.dto.BookSaveDto;
import org.ks.yourbooks.domain.category.CategoryService;
import org.ks.yourbooks.domain.category.dto.CategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookManagementController {
    private final BookService bookService;
    private final CategoryService categoryService;

    public BookManagementController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/dodaj-ksiazke")
    public String addBookForm(Model model) {
        List<CategoryDto> allCategories = categoryService.findAllCategories();
        model.addAttribute("categories", allCategories);
        BookSaveDto book = new BookSaveDto();
        model.addAttribute("book", book);
        return "admin/book-form";
    }

    @PostMapping("/admin/dodaj-ksiazke")
    public String addBook(BookSaveDto book, RedirectAttributes redirectAttributes) {
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Książka %s została zapisana".formatted(book.getTitle()));
        return "redirect:/admin";
    }
}
