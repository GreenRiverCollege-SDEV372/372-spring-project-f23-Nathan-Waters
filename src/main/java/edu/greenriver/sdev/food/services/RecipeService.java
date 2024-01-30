package edu.greenriver.sdev.food.services;

import edu.greenriver.sdev.food.db.RecipeRepository;
import edu.greenriver.sdev.food.models.Recipe;
import jakarta.persistence.ElementCollection;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class RecipeService {

    private RecipeRepository repository;

    public RecipeService(RecipeRepository repository){
        this.repository = repository;
    }
    //get random recipe *R*
    public Recipe getRandomRecipe(){
        Random generator = new Random();
        List<Recipe> recipe = repository.findAll();
        int index = generator.nextInt(recipe.size());
        return recipe.get(index);
    }

    //get all *R*
    public List<Recipe> all(){
        List<Recipe> recipes = repository.findAll();
        return Collections.unmodifiableList(recipes);//what is this exactly?
    }

    //add recipe *C*
    public void newRecipe(Recipe recipe){
        repository.save(recipe);
    }

    //update recipe *U*
    public Recipe updateRecipe(Recipe updatedRecipe, int id){
        Recipe curRecipe = repository.findById(id).orElseThrow();

        curRecipe.setName(updatedRecipe.getName());
        curRecipe.setUrl(updatedRecipe.getUrl());
        curRecipe.setAuthor(updatedRecipe.getAuthor());
        curRecipe.setIngredients(updatedRecipe.getIngredients());
        curRecipe.setMethod(updatedRecipe.getMethod());

        return repository.save(curRecipe);
    }

    //delete recipe *D*
    public void deleteRecipe(int id){
        repository.deleteById(id);
    }
}
