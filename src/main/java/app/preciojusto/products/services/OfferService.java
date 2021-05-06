package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    Optional<Offer> findOfferById(Long id);

    List<Offer> findAll();

    OfferPercentage saveOfferPercentage(Long id, Integer percentage, Double previousPrice);
}
