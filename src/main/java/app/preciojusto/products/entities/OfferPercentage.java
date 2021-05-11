package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "offerpercentage")
public class OfferPercentage extends Offer {

    private Integer ofpepercentage;

    private Double ofpepreviousprice;

    public OfferPercentage() {
    }

    public OfferPercentage(Integer ofpepercentage, Double ofpepreviousprice) {
        this.ofpepercentage = ofpepercentage;
        this.ofpepreviousprice = ofpepreviousprice;
    }
}