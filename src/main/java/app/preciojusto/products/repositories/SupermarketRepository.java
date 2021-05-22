package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupermarketRepository extends JpaRepository<Supermarket, Long> {
    Optional<Supermarket> findBySupenameEquals(String name);
}
