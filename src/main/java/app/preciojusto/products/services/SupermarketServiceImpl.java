package app.preciojusto.products.services;

import app.preciojusto.products.entities.Supermarket;
import app.preciojusto.products.repositories.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    private SupermarketRepository supermarketRepository;

    @Override
    public Optional<Supermarket> findById(Long id) {
        return this.supermarketRepository.findById(id);
    }

    @Override
    public List<Supermarket> findAll() {
        return this.supermarketRepository.findAll();
    }

    @Override
    public Supermarket save(Long id, String name) {
        Supermarket supermarket;
        if (id != null) supermarket = this.findById(id).get();
        else supermarket = new Supermarket();
        supermarket.setSupename(name);
        return this.supermarketRepository.save(supermarket);
    }

    @Override
    public Supermarket findBySupenameEquals(String name) {
        return this.supermarketRepository.findBySupenameEquals(name);
    }


}
