package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.OfferUnit;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferUnitRepository extends OfferRepository {

    Optional<OfferUnit> findOfferByOffeid(Long id);
}
