package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.models.Review;
import edu.greenriver.sdev.food.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewApi {

    private ReviewService service;

    public ReviewApi(ReviewService service){
        this.service = service;
    }

    @GetMapping("reviews/random")
    public Review getRandom(){
        return service.getRandomReview();
    }

    @GetMapping("reviews/all")
    public List<Review> all(){
        return service.all();
    }

    @PostMapping("reviews")
    public void addReview(@RequestBody Review newReview){
        service.newReview(newReview);
    }

    @PutMapping("reviews/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review updatedReview){
        return service.updateReview(updatedReview, id);
    }

    @DeleteMapping("reviews/{id}")
    public void deleteMovie(@PathVariable int id){
        service.deleteReview(id);
    }
}
