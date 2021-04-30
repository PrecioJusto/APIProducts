package app.preciojusto.products.services;

import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe findById(Long id);

    Recipe save(Long id, String name, String text, Integer people, Integer calValue, String time, String dificulty,
                String ingredients, List<FoodProduct> products);
}
