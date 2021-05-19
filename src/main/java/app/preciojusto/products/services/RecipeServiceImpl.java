package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.RecipeDTO;
import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Recipe;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.ProductRepository;
import app.preciojusto.products.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Recipe> findById(final Long id) {
        return this.recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe save(final RecipeDTO request) throws ResourceNotFoundException {
        final Recipe recipe;
        if (request.getReciid() != null) {
            recipe = this.findById(request.getReciid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.RECIPE_NOT_FOUND_ERROR));
        } else {
            recipe = new Recipe();
        }
        recipe.setRecicalvalue(request.getRecicalvalue());
        recipe.setRecipeople(request.getRecipeople());
        recipe.setRecidifficulty(request.getRecidifficulty());
        recipe.setRecitext(request.getRecitext());
        recipe.setReciname(request.getReciname());
        recipe.setRecitime(request.getRecitime());
        if (!request.getProducts().isEmpty()) {
            for (final Long id : request.getProducts()) {
                final Optional<FoodProduct> foodProduct = this.productService.findProductByProdid(id);
                foodProduct.ifPresent(product -> product.getRecipes().add(recipe));
            }
        }
        try {
            return this.recipeRepository.save(recipe);
        } catch (final Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.RECIPE_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Boolean delete(final Long id) {
        try {
            this.recipeRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.RECIPE_NOT_FOUND_ERROR)));
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

}
