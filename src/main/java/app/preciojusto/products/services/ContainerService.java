package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.Optional;

public interface ContainerService {
    Optional<Container> findById(Long id);

    Container save(Container container) throws ResourceNotFoundException;

    Boolean delete(Long id) throws ResourceNotFoundException;
}
