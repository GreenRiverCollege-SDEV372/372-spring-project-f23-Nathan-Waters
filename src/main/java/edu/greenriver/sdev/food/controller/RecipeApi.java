package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.models.Recipe;
import edu.greenriver.sdev.food.models.Review;
import edu.greenriver.sdev.food.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeApi {
    private RecipeService service;

    public RecipeApi(RecipeService service){
        this.service = service;
    }

    @GetMapping("recipes/random")
    public Recipe getRandom(){
        return service.getRandomRecipe();
    }

    @GetMapping("recipes/all")
    public List<Recipe> all(){
        return service.all();
    }

    @PostMapping("recipes")
    public void addMovie(@RequestBody Recipe newRecipe){
        service.newRecipe(newRecipe);
    }

    @PutMapping("recipes/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe updatedRecipe){
        return service.updateRecipe(updatedRecipe, id);
    }

    @DeleteMapping("recipes/{id}")
    public void deleteMovie(@PathVariable int id){
        service.deleteRecipe(id);
    }
}