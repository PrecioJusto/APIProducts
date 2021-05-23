package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.FoodProduct;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodProductRepository extends ProductRepository {

    Optional<FoodProduct> findProductByProdid(Long id);
}
