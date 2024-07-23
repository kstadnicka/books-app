package org.ks.yourbooks.domain.book;

import org.ks.yourbooks.domain.book.dto.BookDto;

public class BookDtoMapper {
    static BookDto map(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getOriginalTitle(),
                book.getReleaseYear(),
                book.getCategory().getName(),
                book.getPromoted()
        );
    }
}
