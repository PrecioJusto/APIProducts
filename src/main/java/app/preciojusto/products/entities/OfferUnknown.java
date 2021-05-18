package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "offerunknown")
public class OfferUnknown extends Offer {

    private String ofunname;

    public OfferUnknown() {
    }
}
