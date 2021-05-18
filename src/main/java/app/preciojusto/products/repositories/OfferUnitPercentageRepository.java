package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.OfferUnitPercentage;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferUnitPercentageRepository extends OfferRepository {

    Optional<OfferUnitPercentage> findOfferByOffeid(Long id);
}
