package app.preciojusto.products.services;

import app.preciojusto.products.entities.Supermarket;
import app.preciojusto.products.repositories.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    SupermarketRepository supermarketRepository;

    @Override
    public Supermarket findById(Long id) {
        return this.supermarketRepository.findById(id).get();
    }

    @Override
    public Supermarket save(Long id, String name) {
        Supermarket supermarket;
        if (id != null) {
            supermarket = this.findById(id);
        } else {
            supermarket = new Supermarket();
        }
        supermarket.setSupename(name);
        return supermarket;
    }

    @Override
    public Supermarket findBySupenameEquals(String name) {
        return this.supermarketRepository.findBySupenameEquals(name);
    }


}
