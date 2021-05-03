package app.preciojusto.products.services;

import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Optional<Recipe> findById(Long id);

    List<Recipe> findAll();

    Recipe save(Long id, String name, String text, Integer people, Integer calValue, String time, String dificulty,
                String ingredients, List<FoodProduct> products);
}
