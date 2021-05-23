package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "offerunitplainprice")
public class OfferUnitPlainPrice extends Offer {

    private Integer ofupunits;

    private Integer ofupprice;
}