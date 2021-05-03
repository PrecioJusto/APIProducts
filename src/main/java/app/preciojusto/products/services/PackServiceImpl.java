package app.preciojusto.products.services;

import app.preciojusto.products.entities.Pack;
import app.preciojusto.products.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackServiceImpl implements PackService {

    @Autowired
    private PackRepository packRepository;

    @Override
    public Optional<Pack> findById(Long id) {
        return this.packRepository.findById(id);
    }

    @Override
    public List<Pack> findAll() {
        return this.packRepository.findAll();
    }

    @Override
    public Pack save(Long id, Integer quantity) {
        Pack pack;
        if (id != null) pack = this.findById(id).get();
        else pack = new Pack();
        pack.setPackquantity(quantity);
        return this.packRepository.save(pack);
    }
}
