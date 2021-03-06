package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.SupermarketImageDTO;
import app.preciojusto.products.entities.Supermarket;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SupermarketService {
    Optional<Supermarket> findById(Long id);

    List<Supermarket> findAll();

    Supermarket save(Supermarket supermarket) throws ResourceNotFoundException;

    Optional<Supermarket> findBySupenameEquals(String name);

    Boolean delete(Long id) throws ResourceNotFoundException;

    Supermarket saveImg(SupermarketImageDTO request);
}
