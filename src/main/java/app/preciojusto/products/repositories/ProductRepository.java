package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByProdnameContaining(String name);

    List<Product> findAllByProdnameContaining(String name);

    List<Product> findAllByCategory_Catename(String name);
}
