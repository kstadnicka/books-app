package org.ks.yourbooks.domain.book;

import org.ks.yourbooks.domain.book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAllPromotedBooks() {
        return bookRepository.findAllByPromotedIsTrue().stream()
                .map(BookDtoMapper::map)
                .toList();
    }
}
