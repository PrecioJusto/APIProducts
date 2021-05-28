package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.RecipeDTO;
import app.preciojusto.products.entities.Recipe;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe")
    public List<Recipe> getRecipes() {
        return this.recipeService.findAll();
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable Long id) throws ResourceNotFoundException {
        return this.recipeService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.RECIPE_NOT_FOUND_ERROR));
    }

    @PostMapping("/recipe")
    public Recipe postAddRecipe(@RequestBody RecipeDTO request) throws ResourceNotFoundException {
        if (request.getReciid() != null || request.getReciname() == null || request.getRecitext() == null || request.getReciingredients() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.recipeService.save(request);
    }

    @PutMapping("/recipe")
    public Recipe putUpdateRecipe(@RequestBody RecipeDTO request) throws ResourceNotFoundException {
        if (request.getReciid() == null || request.getReciname() == null || request.getRecitext() == null || request.getReciingredients() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.recipeService.save(request);
    }

    @DeleteMapping("/recipe/{id}")
    public Boolean deleteRecipe(@PathVariable Long id) {
        return this.recipeService.delete(id);
    }
}
