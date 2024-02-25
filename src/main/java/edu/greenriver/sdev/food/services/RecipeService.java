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
        boolean hasName = recipe.getName() != null && !recipe.getName().isEmpty();
        boolean hasAuthor = recipe.getAuthor() != null && !recipe.getAuthor().isEmpty();
        boolean hasIng = recipe.getIngredients() != null && !recipe.getIngredients().isEmpty();
        if(hasIng){
            for(String str : recipe.getIngredients()){
                if(str==null || str.trim().isEmpty()){
                    hasIng = false;
                    break;
                }
            }
        }
        boolean hasMeth = recipe.getMethod() != null && !recipe.getMethod().isEmpty();
        if(hasMeth){
            for(String str : recipe.getMethod()){
                if(str==null || str.trim().isEmpty()){
                    hasMeth = false;
                    break;
                }
            }
        }
        return !hasName || !hasAuthor || !hasIng || !hasMeth;
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
