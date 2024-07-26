package org.ks.yourbooks.domain.book.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Integer releaseYear;
    private String category;
    private Boolean promoted;

    public BookDto(Long id, String title, String author, String publisher, Integer releaseYear, String category, Boolean promoted) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.category = category;
        this.promoted = promoted;
    }
}
