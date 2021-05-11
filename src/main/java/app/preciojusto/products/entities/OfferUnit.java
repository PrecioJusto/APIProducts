package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "offerunit")
public class OfferUnit extends Offer {

    private Integer ofunfirst;

    private Integer ofunsecond;

    public OfferUnit() {
    }

    public OfferUnit(Integer ofunfirst, Integer ofunsecond) {
        this.ofunfirst = ofunfirst;
        this.ofunsecond = ofunsecond;
    }
}