package org.ks.yourbooks.domain.book;

import org.ks.yourbooks.domain.book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<BookDto> findBookById(Long id) {
        return bookRepository.findById(id).map(BookDtoMapper::map);
    }

    public List<BookDto> findBookByCategoryName(String category){
        return bookRepository.findAllByCategory_NameIgnoreCase(category).stream().
                map(BookDtoMapper::map)
                .toList();
    }
}
