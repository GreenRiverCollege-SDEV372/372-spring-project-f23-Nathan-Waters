package edu.greenriver.sdev.food.db;

import edu.greenriver.sdev.food.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //CRUD methods we need!!!!
}
