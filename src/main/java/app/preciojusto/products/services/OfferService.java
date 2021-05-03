package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;

import java.util.List;
import java.util.Optional;

public interface OfferService {
    Optional<Offer> findById(Long id);

    List<Offer> findAll();

    Offer save(Long id, Long productId);

    Offer savePercentage(OfferPercentage offerPercentage);
}
