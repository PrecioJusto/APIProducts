package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.OfferUnitPlainPrice;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferUnitPlainPriceRepository extends OfferRepository {

    Optional<OfferUnitPlainPrice> findOfferByOffeid(Long id);
}
