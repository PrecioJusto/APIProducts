package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.SupermarketProductDTO;
import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface SupermarketProductService {
    Optional<SupermarketProduct> findById(SupermarketProductCK id);

    List<SupermarketProduct> findAll();

    SupermarketProduct add(SupermarketProductDTO request) throws ResourceNotFoundException;

    SupermarketProduct update(SupermarketProductDTO request) throws ResourceNotFoundException;

    Boolean delete(Long productId, Long supermarketId);

    SupermarketProduct saveSupermarketProduct(SupermarketProduct request);

}
