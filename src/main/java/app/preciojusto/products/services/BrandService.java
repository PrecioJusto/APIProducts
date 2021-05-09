package app.preciojusto.products.services;

import app.preciojusto.products.entities.Brand;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> findById(Long id);

    Brand save(Brand brand) throws ResourceNotFoundException;

    Brand findByBrannameEquals(String name);

    Boolean delete(Long id) throws ResourceNotFoundException;
}
