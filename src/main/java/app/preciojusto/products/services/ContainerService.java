package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;

public interface ContainerService {
    Container findById(Long id);

    Container save(Long id, String units, String type, Double capacity);
}
