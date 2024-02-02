package edu.greenriver.sdev.food.db;

import edu.greenriver.sdev.food.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Author: Nathan Waters
// Date: 2/2/2024
// version: 1

/**
 * Repository interface for managing Recipe entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 *
 * @Repository annotation indicates that this interface is a Spring Data repository.
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
