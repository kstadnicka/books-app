package org.ks.yourbooks.domain.book;

import org.ks.yourbooks.domain.book.dto.BookDto;

public class BookDtoMapper {
    static BookDto map(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getReleaseYear(),
                book.getShortDescription(),
                book.getDescription(),
                book.getCategory().getName(),
                book.getPromoted()
        );
    }
}
