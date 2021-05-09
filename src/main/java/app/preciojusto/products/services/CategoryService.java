package app.preciojusto.products.services;

import app.preciojusto.products.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findById(Long id);

    List<Category> findAll();

    Category save(Category category) throws Exception;

    Category setAsChildren(String childName, String parentName);

    Category findByCatenameEquals(String name);
}
