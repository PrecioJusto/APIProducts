package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    @Override
    public Offer findById(Long id) {
        return null;
    }

    @Override
    public Offer save(Long id, Long productId) {
        return null;
    }

    @Override
    public Offer savePercentage(OfferPercentage offerPercentage) {
        return null;
    }
}
