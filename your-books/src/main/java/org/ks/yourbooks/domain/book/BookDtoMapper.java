package org.ks.yourbooks.domain.book;

import org.ks.yourbooks.domain.book.dto.BookDto;
import org.ks.yourbooks.domain.rating.Rating;

public class BookDtoMapper {
    static BookDto map(Book book){
        double avgRating = book.getRating().stream()
                .map(Rating::getRating)
                .mapToDouble(val -> val)
                .average().orElse(0);
        int ratingCount = book.getRating().size();
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getReleaseYear(),
                book.getShortDescription(),
                book.getDescription(),
                book.getCategory().getName(),
                book.getPromoted(),
                book.getPoster(),
                avgRating,
                ratingCount
        );
    }
}
