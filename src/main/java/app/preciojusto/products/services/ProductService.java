package app.preciojusto.products.services;

import app.preciojusto.products.entities.Product;

public interface ProductService {

    Product findById(Long id);

    // Need to decide how we gonna implement the product types, this base is not considereing it
    Product save(Long id, String name, String brandName, String categoryName, String supermarketName);
}
