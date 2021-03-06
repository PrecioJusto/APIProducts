package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
    Optional<Pack> findByPackquantity(Integer quantity);
}
