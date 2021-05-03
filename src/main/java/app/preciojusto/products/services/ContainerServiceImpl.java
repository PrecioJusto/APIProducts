package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.repositories.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    @Override
    public Optional<Container> findById(Long id) {
        return this.containerRepository.findById(id);
    }

    @Override
    public Container save(Long id, String units, String type, Double capacity) {
        Container c;
        if (id != null) c = this.findById(id).get();
        else c = new Container();
        c.setContunit(units);
        c.setConttype(type);
        c.setContcapacity(capacity);
        return this.containerRepository.save(c);
    }
}
