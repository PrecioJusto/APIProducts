package app.preciojusto.products.services;

import app.preciojusto.products.entities.Product;

public interface ProductService {

    Product findById(Long id);

    Product save(Long id, String name, String brandName, String categoryName, String supermarketName);
}
