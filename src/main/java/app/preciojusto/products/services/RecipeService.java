package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.RecipeDTO;
import app.preciojusto.products.entities.Recipe;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Optional<Recipe> findById(Long id);

    List<Recipe> findAll();

    Recipe save(RecipeDTO request) throws ResourceNotFoundException;

    Boolean delete(Long id);
}
