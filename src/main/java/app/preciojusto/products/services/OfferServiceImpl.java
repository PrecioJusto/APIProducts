package app.preciojusto.products.services;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;
import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.repositories.OfferPercentageRepository;
import app.preciojusto.products.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    public OfferPercentageRepository offerPercentageRepository;

    @Override
    public Optional<Offer> findOfferById(Long id) {
        return this.offerRepository.findById(id);
    }


    @Override
    public List<Offer> findAll() {
        return this.offerRepository.findAll();
    }

    @Override
    public OfferPercentage saveOfferPercentage(Long id, Integer percentage, Double previousPrice) {
        OfferPercentage offer;
        if (id != null) offer = (OfferPercentage) this.findOfferById(id).get();
        else offer = new OfferPercentage();
        SupermarketProduct sp = new SupermarketProduct();
        offer.setOfpepercentage(percentage);
        offer.setOfpepreviousprice(previousPrice);
        // to implement
        
        return this.offerRepository.save(offer);
    }
}
