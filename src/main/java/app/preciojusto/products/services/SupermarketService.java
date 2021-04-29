package app.preciojusto.products.services;

import app.preciojusto.products.entities.Supermarket;

public interface SupermarketService {
    Supermarket findById(Long id);

    Supermarket save(Long id, String name);

    Supermarket findBySupenameEquals(String name);
}
