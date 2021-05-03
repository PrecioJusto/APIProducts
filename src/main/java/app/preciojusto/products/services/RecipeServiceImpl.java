package app.preciojusto.products.services;

import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Recipe;
import app.preciojusto.products.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Optional<Recipe> findById(Long id) {
        return this.recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe save(Long id, String name, String text, Integer people, Integer calValue, String time,
                       String dificulty, String ingredients, List<FoodProduct> products) {
        return null;
    }
}
