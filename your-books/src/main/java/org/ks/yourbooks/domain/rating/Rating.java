package org.ks.yourbooks.domain.rating;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.yourbooks.domain.book.Book;
import org.ks.yourbooks.domain.user.User;

@Entity
@Table(name = "books_rating")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Integer rating;

    public Rating() {
    }

    public Rating(User user, Book book, Integer rating) {
        this.user = user;
        this.book = book;
        this.rating = rating;
    }
}
