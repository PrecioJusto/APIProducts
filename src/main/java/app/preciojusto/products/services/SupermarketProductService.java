package app.preciojusto.products.services;

import app.preciojusto.products.entities.SuperMarketProductCK;
import app.preciojusto.products.entities.SupermarketProduct;

import java.time.LocalDateTime;

public interface SupermarketProductService {
    SupermarketProduct findById(SuperMarketProductCK id);

    SupermarketProduct save(SuperMarketProductCK id, Integer price, String supermarketName, Long offerId, String img,
                            Boolean stock, LocalDateTime updated);
}
