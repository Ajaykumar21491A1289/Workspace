package com.jocata.service;

import com.jocata.reviews_ratings.forms.FeedbackForm;
import com.jocata.reviews_ratings.forms.RatingForm;
import com.jocata.reviews_ratings.forms.ReviewForm;

import java.util.List;

public interface ReviewRatingService {
    String submitReview(ReviewForm request);

    String submitRating(RatingForm request);

    String submitFeedback(FeedbackForm request);

    List<ReviewForm> getReviewsByProduct(Long productId);

    List<RatingForm> getRatingsByProduct(Long productId);

    List<FeedbackForm> getFeedbackByProduct(Long productId);
}
