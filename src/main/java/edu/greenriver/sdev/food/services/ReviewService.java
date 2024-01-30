package edu.greenriver.sdev.food.services;

import edu.greenriver.sdev.food.db.ReviewRepository;
import edu.greenriver.sdev.food.models.Recipe;
import edu.greenriver.sdev.food.models.Review;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ReviewService {
    private ReviewRepository repository;

    public ReviewService(ReviewRepository repository){
        this.repository = repository;
    }

    public Review getRandomReview(){
        Random generator = new Random();
        List<Review> review = repository.findAll();
        int index = generator.nextInt(review.size());
        return review.get(index);
    }

    public List<Review> all(){
        List<Review> reviews = repository.findAll();
        return Collections.unmodifiableList(reviews);//what is this exactly?
    }

    public void newReview(Review review){
        repository.save(review);
    }

    public Review updateReview(Review updatedReview, int id){
        Review curReview = repository.findById(id).orElseThrow();

        curReview.setRecipeName(updatedReview.getRecipeName());
        curReview.setStars(updatedReview.getStars());
        curReview.setReview(updatedReview.getReview());

        return repository.save(curReview);
    }

    public void deleteReview(int id){
        repository.deleteById(id);
    }
}
