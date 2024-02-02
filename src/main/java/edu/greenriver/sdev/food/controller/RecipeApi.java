package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.models.Recipe;
import edu.greenriver.sdev.food.services.RecipeService;
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
public class RecipeApi {
    private RecipeService service;

    /**
     * Constructor to initialize the RecipeService.
     *
     * @param service RecipeService instance.
     */
    public RecipeApi(RecipeService service){
        this.service = service;
    }

    /**
     * Retrieves a random recipe.
     *
     * @return ResponseEntity containing a random recipe or a 404 status if no recipes are available.
     */
    @GetMapping("recipes/random")
    public ResponseEntity<Recipe> getRandom(){
        return new ResponseEntity<>(service.getRandomRecipe(), HttpStatus.OK);
    }

    /**
     * Retrieves all recipes.
     *
     * @return ResponseEntity containing a list of all recipes.
     */
    @GetMapping("recipes/all")
    public ResponseEntity<List<Recipe>> all(){
        return new ResponseEntity<>(service.all(), HttpStatus.OK);
    }

    /**
     * Adds a new recipe.
     *
     * @param newRecipe The new recipe to be added.
     * @return ResponseEntity with the added recipe and a 201 status if the recipe is added successfully,
     * or a 400 status if the new recipe is not valid.
     */
    @PostMapping("recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe newRecipe){
        if(!service.isValidRecipe(newRecipe)){
            //no response body, status code 400
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //response body is saved recipe, status code 201
        return new ResponseEntity<>(service.addRecipe(newRecipe), HttpStatus.CREATED);
    }

    /**
     * Updates an existing recipe.
     *
     * @param id            The ID of the recipe to be updated.
     * @param updatedRecipe The updated recipe.
     * @return ResponseEntity with the updated recipe and a 400 status if the updated recipe is not valid,
     * or a 200 status if the recipe is updated successfully.
     */
    @PutMapping("recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe updatedRecipe){
        if(service.isValidUpdatedRecipe(updatedRecipe)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.updateRecipe(updatedRecipe, id), HttpStatus.OK);
    }

    /**
     * Deletes a recipe by ID.
     *
     * @param id The ID of the recipe to be deleted.
     * @return ResponseEntity with the deleted recipe and a 200 status if the recipe is deleted successfully.
     */
    @DeleteMapping("recipes/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable int id){

        return new ResponseEntity<>(service.deleteRecipe(id), HttpStatus.OK);
    }
}