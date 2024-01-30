package edu.greenriver.sdev.food.services;

import edu.greenriver.sdev.food.db.ReviewRepository;
import edu.greenriver.sdev.food.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ReviewService {
    private ReviewRepository repository;

    public ReviewService(ReviewRepository repository){
        this.repository = repository;
    }

    //get random recipe *R*
    public Review getRandomReview(){
        Random generator = new Random();
        List<Review> review = repository.findAll();
        int index = generator.nextInt(review.size());
        return review.get(index);
    }

    //get all *R*
    //add Review *C*

    //update Review *U*

    //delete Review *D*
}
