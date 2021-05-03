package app.preciojusto.products.services;

import app.preciojusto.products.entities.Supermarket;

import java.util.List;
import java.util.Optional;

public interface SupermarketService {
    Optional<Supermarket> findById(Long id);

    List<Supermarket> findAll();

    Supermarket save(Long id, String name);

    Supermarket findBySupenameEquals(String name);
}
