package app.preciojusto.products.services;

import app.preciojusto.products.entities.Supermarket;

import java.util.Optional;

public interface SupermarketService {
    Optional<Supermarket> findById(Long id);

    Supermarket save(Long id, String name);

    Supermarket findBySupenameEquals(String name);
}
