package com.jocata.service.impl;

import com.jocata.dao.reviews.FeedbackRepository;
import com.jocata.dao.reviews.RatingRepository;
import com.jocata.dao.reviews.ReviewRepository;
import com.jocata.reviews_ratings.entity.FeedBack;
import com.jocata.reviews_ratings.entity.Ratings;
import com.jocata.reviews_ratings.entity.Reviews;
import com.jocata.reviews_ratings.forms.FeedbackForm;
import com.jocata.reviews_ratings.forms.RatingForm;
import com.jocata.reviews_ratings.forms.ReviewForm;
import com.jocata.service.ReviewRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewRatingServiceImpl implements ReviewRatingService {

    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private RatingRepository ratingRepo;
    @Autowired
    private FeedbackRepository feedbackRepo;

    @Override
    public String submitReview(ReviewForm request) {
        Reviews review = new Reviews();
        review.setUserId(request.getUserId());
        review.setProductId(request.getProductId());
        review.setReviewText(request.getReviewText());
        reviewRepo.save(review);

        return "Thanks for your review";

    }

    @Override
    public String submitRating(RatingForm request) {
        Ratings rating = new Ratings();
        if (request.getRating() < 1 || request.getRating() > 5){

            return "Rating should be between 1 and 5 ";
        }



        rating.setUserId(request.getUserId());
        rating.setProductId(request.getProductId());
        rating.setRating(request.getRating());
        ratingRepo.save(rating);

        return "Thanks for your rating";
    }

    @Override
    public String submitFeedback(FeedbackForm request) {
        FeedBack feedback = new FeedBack();
        feedback.setUserId(request.getUserId());
        feedback.setProductId(request.getProductId());
        feedback.setFeedbackText(request.getFeedbackText());
        feedbackRepo.save(feedback);

        return "Thanks for your Feedback";
    }

    @Override
    public List<ReviewForm> getReviewsByProduct(Long productId) {
        return reviewRepo.findByProductId(productId).stream().map(r -> {
            ReviewForm form = new ReviewForm();
            form.setId(r.getId());
            form.setUserId(r.getUserId());
            form.setProductId(r.getProductId());
            form.setReviewText(r.getReviewText());

            return form;
        }).toList();
    }

    @Override
    public List<RatingForm> getRatingsByProduct(Long productId) {
        return ratingRepo.findByProductId(productId).stream().map(r -> {
            RatingForm form = new RatingForm();
            form.setId(r.getId());
            form.setUserId(r.getUserId());
            form.setProductId(r.getProductId());
            form.setRating(r.getRating());
            return form;
        }).toList();
    }

    @Override
    public List<FeedbackForm> getFeedbackByProduct(Long productId) {
        return feedbackRepo.findByProductId(productId).stream().map(f -> {
            FeedbackForm form = new FeedbackForm();
            form.setId(f.getId());
            form.setUserId(f.getUserId());
            form.setProductId(f.getProductId());
            form.setFeedbackText(f.getFeedbackText());
            return form;
        }).toList();
    }
}
