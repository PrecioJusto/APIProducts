package app.preciojusto.products.services;

import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Override
    public Recipe findById(Long id) {
        return null;
    }

    @Override
    public Recipe save(Long id, String name, String text, Integer people, Integer calValue, String time,
                       String dificulty, String ingredients, List<FoodProduct> products) {
        return null;
    }
}
