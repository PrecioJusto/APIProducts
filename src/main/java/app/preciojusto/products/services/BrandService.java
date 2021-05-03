package app.preciojusto.products.services;

import app.preciojusto.products.entities.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> findById(Long id);

    Brand save(Long id, String name);

    Brand findByBrannameEquals(String name);
}
