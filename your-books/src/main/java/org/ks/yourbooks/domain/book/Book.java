package org.ks.yourbooks.domain.book;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.yourbooks.domain.category.Category;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String originalTitle;
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private Boolean promoted;

}
