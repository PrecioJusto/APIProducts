package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity(name = "foodprodcut")
public class FoodProduct extends Product {

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "contid", nullable = false)
    Container container;

    @ManyToMany
    @JoinTable(
            name="productrecipe",
            joinColumns = @JoinColumn(name="recid"),
            inverseJoinColumns = @JoinColumn(name = "prodid")
    )
    Set<Recipe> recipes;
}
