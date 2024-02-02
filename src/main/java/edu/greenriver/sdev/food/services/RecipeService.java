package edu.greenriver.sdev.food.services;

import edu.greenriver.sdev.food.db.RecipeRepository;
import edu.greenriver.sdev.food.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

// Author: Nathan Waters
// Date: 2/2/2024
// version: 1

/**
 * Service class for managing recipe-related operations.
 */
@Service
public class RecipeService {

    private RecipeRepository repository;

    /**
     * Constructor for RecipeService.
     *
     * @param repository The repository for accessing recipe data.
     */
    public RecipeService(RecipeRepository repository){
        this.repository = repository;
    }

    /**
     * Gets a random recipe from the repository.
     *
     * @return A randomly selected recipe.
     */
    public Recipe getRandomRecipe(){
        Random generator = new Random();
        List<Recipe> recipe = repository.findAll();
        int index = generator.nextInt(recipe.size());
        return recipe.get(index);
    }

    /**
     * Retrieves all recipes from the repository.
     *
     * @return An unmodifiable list of all recipes.
     */
    public List<Recipe> all(){
        List<Recipe> recipes = repository.findAll();
        return Collections.unmodifiableList(recipes);//what is this exactly?
    }

    /**
     * Adds a new recipe to the repository.
     *
     * @param recipe The recipe to be added.
     * @return The added recipe.
     */
    public Recipe addRecipe(Recipe recipe){
        repository.save(recipe);
        return recipe;
    }

    /**
     * Updates an existing recipe in the repository.
     *
     * @param updatedRecipe The updated recipe data.
     * @param id            The ID of the recipe to be updated.
     * @return The updated recipe.
     */
    public Recipe updateRecipe(Recipe updatedRecipe, int id){
        Recipe curRecipe = repository.findById(id).orElseThrow();

        curRecipe.setName(updatedRecipe.getName());
        curRecipe.setUrl(updatedRecipe.getUrl());
        curRecipe.setAuthor(updatedRecipe.getAuthor());
        curRecipe.setIngredients(updatedRecipe.getIngredients());
        curRecipe.setMethod(updatedRecipe.getMethod());

        return repository.save(curRecipe);
    }

    /**
     * Deletes a recipe from the repository.
     *
     * @param id The ID of the recipe to be deleted.
     * @return The deleted recipe.
     */
    public Recipe deleteRecipe(int id){
        repository.deleteById(id);
        return null;
    }

    /**
     * Checks if a recipe is valid (has a non-null and non-empty name).
     *
     * @param recipe The recipe to be validated.
     * @return True if the recipe is valid, false otherwise.
     */
    public boolean isValidRecipe(Recipe recipe){
        return recipe.getName() != null && !recipe.getName().isEmpty();
    }

    /**
     * Checks if an updated recipe is valid (has a non-null and non-empty author).
     *
     * @param recipe The updated recipe to be validated.
     * @return True if the updated recipe is valid, false otherwise.
     */
    public boolean isValidUpdatedRecipe(Recipe recipe){
        return recipe.getAuthor() != null && !recipe.getAuthor().isEmpty();
    }
}
