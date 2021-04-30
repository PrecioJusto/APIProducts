package app.preciojusto.products.services;

import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;

import java.time.LocalDateTime;

public interface SupermarketProductService {
    SupermarketProduct findById(SupermarketProductCK id);

    SupermarketProduct save(SupermarketProductCK id, Integer price, String supermarketName, Long offerId, String img,
                            Boolean stock, LocalDateTime updated);
}
