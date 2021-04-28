package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "offerpercentage")
public class OfferPercentage extends Offer{

    private Integer ofpepercentage;

    private Double ofpepreviousprice;
}