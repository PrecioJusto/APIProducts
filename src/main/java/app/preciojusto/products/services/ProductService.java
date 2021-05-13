package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.entities.Pack;
import app.preciojusto.products.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findAllFoodproduct();

    Product saveFoodProduct(Long id, String name, String brandName, String categoryName, String supermarketName, Container container, Pack pack);
}
