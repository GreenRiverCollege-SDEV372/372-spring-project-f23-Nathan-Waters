package edu.greenriver.sdev.food.controller;

import edu.greenriver.sdev.food.models.Recipe;
import edu.greenriver.sdev.food.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeApi {
    private RecipeService service;

    public RecipeApi(RecipeService service){
        this.service = service;
    }

    @GetMapping("recipes/random")
    public ResponseEntity<Recipe> getRandom(){
        return new ResponseEntity<>(service.getRandomRecipe(), HttpStatus.OK);
    }

    @GetMapping("recipes/all")
    public ResponseEntity<List<Recipe>> all(){
        return new ResponseEntity<>(service.all(), HttpStatus.OK);
    }

    @PostMapping("recipes")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe newRecipe){
        if(!service.isValidRecipe(newRecipe)){
            //no response body, status code 400
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //response body is saved recipe, status code 201
        return new ResponseEntity<>(service.addRecipe(newRecipe), HttpStatus.CREATED);
    }

    @PutMapping("recipes/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe updatedRecipe){
        if(service.isValidUpdatedRecipe(updatedRecipe)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.updateRecipe(updatedRecipe, id), HttpStatus.OK);
    }

    //TODO
    @DeleteMapping("recipes/{id}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable int id){

        return new ResponseEntity<>(service.deleteRecipe(id), HttpStatus.OK);
    }
}