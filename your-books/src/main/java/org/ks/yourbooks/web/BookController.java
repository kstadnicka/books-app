package org.ks.yourbooks.web;

import org.springframework.security.core.Authentication;
import org.ks.yourbooks.domain.book.BookService;
import org.ks.yourbooks.domain.book.dto.BookDto;
import org.ks.yourbooks.domain.rating.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
public class BookController {
    private final BookService bookService;
    private final RatingService ratingService;

    public BookController(BookService bookService, RatingService ratingService) {
        this.bookService = bookService;
        this.ratingService = ratingService;
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable long id,
                          Model model,
                          Authentication authentication) {
        BookDto book = bookService.findBookById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("book",book);
        if (authentication != null){
            String currentUserEmail = authentication.getName();
            Integer rating = ratingService.getUserRatingForBook(currentUserEmail, id).orElse(0);
            model.addAttribute("userRating", rating);
        }
        return "book";
    }
}
