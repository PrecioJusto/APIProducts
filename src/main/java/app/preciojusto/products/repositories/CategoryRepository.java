package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByCatenameIsNotNull(Pageable pageable);

    Optional<Category> findByCatenameEquals(String name);
}
