package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
    Optional<Container> findContainerByContcapacityAndAndConttypeAndContunit(Double capacity, String type, String units);
}
