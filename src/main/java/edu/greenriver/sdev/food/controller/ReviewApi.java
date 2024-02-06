package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.models.Review;
import edu.greenriver.sdev.food.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Author: Nathan Waters
// Date: 2/2/2024
// version: 1

/**
 * Controller class for handling recipe API requests.
 */
@RestController
public class ReviewApi {

    private ReviewService service;

    /**
     * Constructor to initialize the ReviewService.
     *
     * @param service ReviewService instance.
     */
    public ReviewApi(ReviewService service){
        this.service = service;
    }

    /**
     * Retrieves a random review.
     *
     * @return ResponseEntity containing a random review or a 404 status if no reviews are available.
     */
    @GetMapping("reviews/random")
    public ResponseEntity<Review> getRandom(){
        return new ResponseEntity<>(service.getRandomReview(), HttpStatus.OK);
    }

    /**
     * Retrieves all reviews.
     *
     * @return ResponseEntity containing a list of all reviews.
     */
    @GetMapping("reviews/all")
    public ResponseEntity<List<Review>> all(){
        return new ResponseEntity<>(service.all(),HttpStatus.OK);
    }

    /**
     * Adds a new review.
     *
     * @param newReview The new review to be added.
     * @return ResponseEntity with the added review and a 201 status if the review is added successfully,
     * or a 400 status if the new review is not valid.
     */
    @PostMapping("reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review newReview){
        if(service.isValidReview(newReview)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.newReview(newReview), HttpStatus.CREATED);
    }

    /**
     * Updates an existing review.
     *
     * @param id            The ID of the review to be updated.
     * @param updatedReview The updated review.
     * @return ResponseEntity with the updated review and a 400 status if the updated review is not valid,
     * or a 200 status if the review is updated successfully.
     */
    @PutMapping("reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable int id, @RequestBody Review updatedReview){
        if(service.isValidReview(updatedReview)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.updateReview(updatedReview, id), HttpStatus.OK);
    }

    /**
     * Deletes a review by ID.
     *
     * @param id The ID of the review to be deleted.
     * @return ResponseEntity with the deleted review and a 200 status if the review is deleted successfully.
     */
    @DeleteMapping("reviews/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable int id){
        if(service.isValidDelete(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.deleteReview(id), HttpStatus.OK);
    }
}
