package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.SuperMarketProductCK;
import app.preciojusto.products.entities.SupermarketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermarketProductRepository extends JpaRepository<SupermarketProduct, SuperMarketProductCK> {
}
