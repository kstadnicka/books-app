package org.ks.yourbooks.web.admin;

import org.ks.yourbooks.domain.rating.RatingService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/ocena-ksiazki")
    public String addBookRatinf(@RequestParam long bookId,
                                @RequestParam int rating,
                                @RequestHeader String referer,
                                Authentication authentication){
        String currentUserEmail = authentication.getName();
        ratingService.addOrUpdateRating(currentUserEmail, bookId, rating);
        return "redirect:" + referer;
    }
}
