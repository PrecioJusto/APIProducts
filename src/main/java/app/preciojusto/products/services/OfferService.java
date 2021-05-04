package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    Optional<Offer> findOfferById(Long id);

    List<Offer> findAll();

    Offer save(Long id, Long productId);
}
