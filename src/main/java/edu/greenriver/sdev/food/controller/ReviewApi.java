package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.models.Review;
import edu.greenriver.sdev.food.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewApi {

    private ReviewService service;

    public ReviewApi(ReviewService service){
        this.service = service;
    }

    @GetMapping("reviews/random")
    public ResponseEntity<Review> getRandom(){
        return new ResponseEntity<>(service.getRandomReview(), HttpStatus.OK);
    }

    //TODO
    @GetMapping("reviews/all")
    public ResponseEntity<List<Review>> all(){
        return new ResponseEntity<>(service.all(),HttpStatus.OK);
    }

    //TODO
    @PostMapping("reviews")
    public ResponseEntity<Review> addReview(@RequestBody Review newReview){
        if(!service.isValidReview(newReview)){
            return new ResponseEntity<>(service.newReview(newReview), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.newReview(newReview), HttpStatus.CREATED);
    }

    //TODO
    @PutMapping("reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable int id, @RequestBody Review updatedReview){
        return new ResponseEntity<>(service.updateReview(updatedReview, id), HttpStatus.OK);
    }

    //TODO
    @DeleteMapping("reviews/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable int id){

        return new ResponseEntity<>(service.deleteReview(id), HttpStatus.OK);
    }
}
