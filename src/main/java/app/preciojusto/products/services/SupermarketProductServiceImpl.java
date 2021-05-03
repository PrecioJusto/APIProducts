package app.preciojusto.products.services;

import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;
import app.preciojusto.products.repositories.SupermarketProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SupermarketProductServiceImpl implements SupermarketProductService {

    @Autowired
    private SupermarketProductRepository supermarketProductRepository;

    @Override
    public Optional<SupermarketProduct> findById(SupermarketProductCK id) {
        return this.supermarketProductRepository.findById(id);
    }

    @Override
    public SupermarketProduct save(SupermarketProductCK id, Integer price, String supermarketName, Long offerId,
                                   String img, Boolean stock, LocalDateTime updated) {
        return null;
    }
}
