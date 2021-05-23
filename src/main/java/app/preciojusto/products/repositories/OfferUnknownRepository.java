package app.preciojusto.products.repositories;

import app.preciojusto.products.entities.OfferUnknown;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferUnknownRepository extends OfferRepository {
    Optional<OfferUnknown> findOfferByOffeid(Long id);
}
