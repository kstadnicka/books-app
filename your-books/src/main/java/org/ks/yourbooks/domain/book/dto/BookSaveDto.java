package org.ks.yourbooks.domain.book.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookSaveDto {
    private String title;
    private String author;
    private String publisher;
    private Integer releaseYear;
    private String shortDescription;
    private String description;
    private String category;
    private Boolean promoted;
    private MultipartFile poster;
}
