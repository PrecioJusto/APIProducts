package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;

public interface OfferService {
    Offer findById(Long id);

    Offer save(Long id, Long productId);

    // To save the types of offer create methods that accept and offertype
    // or just send the params and identify it by name, not forcing the type (same on OfferUnit, OfferUnknown...)
    Offer savePercentage(OfferPercentage offerPercentage);
}
