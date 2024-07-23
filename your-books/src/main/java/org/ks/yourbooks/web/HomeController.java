package org.ks.yourbooks.web;


import org.ks.yourbooks.domain.book.BookService;
import org.ks.yourbooks.domain.book.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<BookDto> promotedBooks = bookService.findAllPromotedBooks();
        model.addAttribute("heading", "Promowane książki");
        model.addAttribute("description", "Książki polecane przez nasz zespół");
        model.addAttribute("books", promotedBooks);
        return "book-listing";
    }
}
