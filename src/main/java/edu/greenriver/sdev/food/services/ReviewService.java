package edu.greenriver.sdev.food.services;

import edu.greenriver.sdev.food.db.ReviewRepository;
import edu.greenriver.sdev.food.models.Review;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

// Author: Nathan Waters
// Date: 2/2/2024
// version: 1

/**
 * Service class for managing review-related operations.
 */
@Service
public class ReviewService {
    private ReviewRepository repository;

    /**
     * Constructor for ReviewService.
     *
     * @param repository The repository for accessing review data.
     */
    public ReviewService(ReviewRepository repository){
        this.repository = repository;
    }

    /**
     * Gets a random review from the repository.
     *
     * @return A randomly selected review.
     */
    public Review getRandomReview(){
        Random generator = new Random();
        List<Review> review = repository.findAll();
        int index = generator.nextInt(review.size());
        return review.get(index);
    }

    /**
     * Retrieves all reviews from the repository.
     *
     * @return An unmodifiable list of all reviews.
     */
    public List<Review> all(){
        List<Review> reviews = repository.findAll();
        return Collections.unmodifiableList(reviews);//what is this exactly?
    }

    /**
     * Adds a new review to the repository.
     *
     * @param review The review to be added.
     * @return The added review.
     */
    public Review newReview(Review review){
        repository.save(review);
        return review;
    }

    /**
     * Updates an existing review in the repository.
     *
     * @param updatedReview The updated review data.
     * @param id            The ID of the review to be updated.
     * @return The updated review.
     */
    public Review updateReview(Review updatedReview, int id){
        Review curReview = repository.findById(id).orElseThrow();

        curReview.setRecipeName(updatedReview.getRecipeName());
        curReview.setStars(updatedReview.getStars());
        curReview.setReview(updatedReview.getReview());

        return repository.save(curReview);
    }

    /**
     * Deletes a review from the repository.
     *
     * @param id The ID of the review to be deleted.
     * @return The deleted review.
     */
    public Review deleteReview(int id){
        repository.deleteById(id);
        return null;
    }

    /**
     * Checks if a review is valid (has stars within the range of 0 to 5).
     *
     * @param review The review to be validated.
     * @return True if the review is valid, false otherwise.
     */
    public boolean isValidReview(Review review){
        return review.getStars() < 0 || review.getStars() > 5;
    }

    /**
     * Checks the validity of deleting an entity based on its ID.
     *
     * @param id The ID of the entity to check for existence.
     * @return {@code true} if the entity does not exist and can be deleted, {@code false} otherwise.
     */
    public boolean isValidDelete(int id){
        return !repository.existsById(id);
    }
}
