package com.jocata.controller;

import com.jocata.reviews_ratings.entity.FeedBack;
import com.jocata.reviews_ratings.entity.Ratings;
import com.jocata.reviews_ratings.entity.Reviews;
import com.jocata.reviews_ratings.forms.FeedbackForm;
import com.jocata.reviews_ratings.forms.RatingForm;
import com.jocata.reviews_ratings.forms.ReviewForm;
import com.jocata.service.ReviewRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewRaingController {

    @Autowired
    private ReviewRatingService reviewRatingService;

    @PostMapping("/submit-review")
    public ResponseEntity<String> submitReview(@RequestBody ReviewForm request) {
        String res = reviewRatingService.submitReview(request);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/submit-rating")
    public ResponseEntity<String> submitRating(@RequestBody RatingForm request) {
        String res = reviewRatingService.submitRating(request);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/submit-feedback")
    public ResponseEntity<String> submitFeedback(@RequestBody FeedbackForm request) {
        String res = reviewRatingService.submitFeedback(request);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/product/{productId}/reviews")
    public ResponseEntity<List<ReviewForm>> getReviews(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewRatingService.getReviewsByProduct(productId));
    }

    @GetMapping("/product/{productId}/ratings")
    public ResponseEntity<List<RatingForm>> getRatings(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewRatingService.getRatingsByProduct(productId));
    }

    @GetMapping("/product/{productId}/feedback")
    public ResponseEntity<List<FeedbackForm>> getFeedback(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewRatingService.getFeedbackByProduct(productId));
    }

}
