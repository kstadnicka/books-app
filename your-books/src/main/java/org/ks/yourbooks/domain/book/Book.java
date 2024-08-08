package org.ks.yourbooks.domain.book;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.yourbooks.domain.category.Category;
import org.ks.yourbooks.domain.rating.Rating;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer releaseYear;
    private String publisher;
    private String author;
    private String shortDescription;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @OneToMany(mappedBy = "book")
    private Set<Rating> rating = new HashSet<>();
    private Boolean promoted;
    private String poster;

}
