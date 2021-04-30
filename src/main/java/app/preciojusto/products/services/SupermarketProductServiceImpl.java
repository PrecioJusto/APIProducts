package app.preciojusto.products.services;

import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SupermarketProductServiceImpl implements SupermarketProductService {
    @Override
    public SupermarketProduct findById(SupermarketProductCK id) {
        return null;
    }

    @Override
    public SupermarketProduct save(SupermarketProductCK id, Integer price, String supermarketName, Long offerId,
                                   String img, Boolean stock, LocalDateTime updated) {
        return null;
    }
}
