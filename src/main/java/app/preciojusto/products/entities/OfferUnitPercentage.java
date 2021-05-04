package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "offerunitpercentage")
public class OfferUnitPercentage extends Offer {

    private Integer ofupunitaffected;

    private Integer ofuppercentage;

    public OfferUnitPercentage() {
    }

    public OfferUnitPercentage(Integer ofupunitaffected, Integer ofuppercentage) {
        this.ofupunitaffected = ofupunitaffected;
        this.ofuppercentage = ofuppercentage;
    }
}