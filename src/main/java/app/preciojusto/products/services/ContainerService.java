package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ContainerService {
    Optional<Container> findById(Long id);

    List<Container> findAll();

    Container save(Container container) throws ResourceNotFoundException;

    Boolean delete(Long id) throws ResourceNotFoundException;

    Optional<Container> findContainerByContcapacityAndAndConttypeAndContunit(Double capacity, String type, String units);
}
