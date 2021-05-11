package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByBrannameEquals(String name);
}
