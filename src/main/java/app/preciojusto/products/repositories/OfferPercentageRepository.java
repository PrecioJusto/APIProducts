package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.OfferPercentage;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferPercentageRepository extends OfferRepository {

    Optional<OfferPercentage> findOfferByOffeid(Long id);
}
