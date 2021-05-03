package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;

import java.util.Optional;

public interface ContainerService {
    Optional<Container> findById(Long id);

    Container save(Long id, String units, String type, Double capacity);
}
