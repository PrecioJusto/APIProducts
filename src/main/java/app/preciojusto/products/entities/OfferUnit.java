package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "offerunit")
public class OfferUnit extends Offer {

    private Integer ofunfirst;

    private Integer ofunsecond;

}