package app.preciojusto.products.services;

import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;
import app.preciojusto.products.repositories.SupermarketProductRepository;
import app.preciojusto.products.repositories.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SupermarketProductServiceImpl implements SupermarketProductService {

    @Autowired
    private SupermarketProductRepository supermarketProductRepository;

    @Autowired
    private SupermarketRepository supermarketRepository;

    @Override
    public Optional<SupermarketProduct> findById(SupermarketProductCK id) {
        return this.supermarketProductRepository.findById(id);
    }

    @Override
    public SupermarketProduct save(Long superId, Long productId, Integer price, Long offerId,
                                   String img, Boolean stock, LocalDateTime updated) {
        SupermarketProduct supermarketProduct = new SupermarketProduct();
        supermarketProduct.setId(new SupermarketProductCK(superId, productId));
        supermarketProduct.setSupprice(price);
        supermarketProduct.setSuprstock(stock);
        supermarketProduct.setSuprimg(img);
        supermarketProduct.setSuprlastupdated(updated);
        supermarketProduct.setSupeid(this.supermarketRepository.findById(superId).get());
        return this.supermarketProductRepository.save(supermarketProduct);
    }
}
