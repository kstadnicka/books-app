package org.ks.yourbooks.domain.book.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String originalTitle;
    private Integer releaseYear;
    private String category;
    private Boolean promoted;

    public BookDto(Long id, String title, String originalTitle, Integer releaseYear, String category, Boolean promoted) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseYear = releaseYear;
        this.category = category;
        this.promoted = promoted;
    }
}
