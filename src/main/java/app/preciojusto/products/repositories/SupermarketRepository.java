package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupermarketRepository extends JpaRepository<Supermarket, Long> {
    Supermarket findBySupenameEquals(String name);
}
