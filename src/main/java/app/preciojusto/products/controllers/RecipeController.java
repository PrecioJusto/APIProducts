package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeController {
    @GetMapping("/recipe/all")
    public List<Recipe> getRecipes() {
        return null;
    }

    @GetMapping("/recipe/{id}/get")
    public Recipe getRecipe(@PathVariable Long id) {
        return null;
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
