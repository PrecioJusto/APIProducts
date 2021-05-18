package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;
import app.preciojusto.products.entities.OfferUnit;
import app.preciojusto.products.entities.OfferUnitPercentage;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    Optional<Offer> findOfferById(Long id);

    List<Offer> findAll();

    Offer saveOfferUnitPercentage(OfferUnitPercentage request);

    Offer saveOfferPercentage(OfferPercentage request);

    Offer saveOfferUnit(OfferUnit request);

    Boolean delete(Long id);
}
