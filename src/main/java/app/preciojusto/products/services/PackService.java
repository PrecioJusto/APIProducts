package app.preciojusto.products.services;

import app.preciojusto.products.entities.Pack;

public interface PackService {
    Pack findById(Long id);

    Pack save(Long id, Integer quantity);
}
