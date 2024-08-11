package org.ks.yourbooks.domain.rating;

import org.ks.yourbooks.domain.book.Book;
import org.ks.yourbooks.domain.book.BookRepository;
import org.ks.yourbooks.domain.user.User;
import org.ks.yourbooks.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void addOrUpdateRating(String userEmail, long bookId, int rating){
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndBook_Id(userEmail, bookId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setBook(book);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForBook(String userEmail, long bookId){
        return ratingRepository.findByUser_EmailAndBook_Id(userEmail,bookId)
                .map(Rating::getRating);
    }
}
