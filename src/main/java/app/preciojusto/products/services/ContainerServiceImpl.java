package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import org.springframework.stereotype.Service;

@Service
public class ContainerServiceImpl implements ContainerService {
    @Override
    public Container findById(Long id) {
        return null;
    }

    @Override
    public Container save(Long id, String units, String type, Double capacity) {
        return null;
    }
}
