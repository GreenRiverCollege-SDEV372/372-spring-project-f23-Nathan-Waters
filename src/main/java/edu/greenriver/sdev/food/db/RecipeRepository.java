package edu.greenriver.sdev.food.db;

import edu.greenriver.sdev.food.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    //CRUD methods we need!!!!
}
