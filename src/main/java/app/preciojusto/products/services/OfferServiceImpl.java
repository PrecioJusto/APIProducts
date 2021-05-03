package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;
import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Optional<Offer> findById(Long id) {
        return this.offerRepository.findById(id);
    }

    @Override
    public List<Offer> findAll() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer save(Long id, Long productId) {
        Offer offer;
        if (id != null) offer = this.findById(id).get();
        else offer = new Offer();
        SupermarketProduct sp = new SupermarketProduct();
        // to implement
        return this.offerRepository.save(offer);
    }

    @Override
    public Offer savePercentage(OfferPercentage offerPercentage) {
        return null;
    }
}
