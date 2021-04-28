package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "offerunitpercentage")
public class OfferUnitPercentage extends Offer{

    private Integer ofupunitaffected;

    private Integer ofuppercentage;
}