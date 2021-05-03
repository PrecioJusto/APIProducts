package app.preciojusto.products.services;

import app.preciojusto.products.entities.Pack;

import java.util.List;
import java.util.Optional;

public interface PackService {
    Optional<Pack> findById(Long id);

    List<Pack> findAll();

    Pack save(Long id, Integer quantity);
}
