package app.preciojusto.products.services;

import app.preciojusto.products.entities.Pack;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PackService {
    Optional<Pack> findById(Long id);

    List<Pack> findAll();

    Optional<Pack> findByPackquantity(Integer quantity) throws ResourceNotFoundException;

    Pack save(Pack request) throws ResourceNotFoundException;

    Boolean delete(Long id) throws ResourceNotFoundException;
}
