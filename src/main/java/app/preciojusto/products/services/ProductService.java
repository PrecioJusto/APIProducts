package app.preciojusto.products.services;

import app.preciojusto.products.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    // Need to decide how we gonna implement the product types, this base is not considereing it
    Product save(Long id, String name, String brandName, String categoryName, String supermarketName);
}
