package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Recipe;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe/all")
    public List<Recipe> getRecipes() {
        return this.recipeService.findAll();
    }

    @GetMapping("/recipe/{id}/get")
    public Recipe getRecipe(@PathVariable Long id) throws ResourceNotFoundException {
        return this.recipeService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.RECIPE_NOT_FOUND_ERROR));
    }

    @PostMapping("/recipe/add")
    public Recipe postAddRecipe(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/recipe/{id}/update")
    public Recipe putUpdateRecipe(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/recipe/{id}/delete")
    public Boolean deleteRecipe(@RequestBody String payload) {
        return false;
    }
}
