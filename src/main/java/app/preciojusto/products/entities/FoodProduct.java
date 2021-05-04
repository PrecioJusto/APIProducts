package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity(name = "foodproduct")
public class FoodProduct extends Product {

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "contid", nullable = false)
    private Container container;

    @ManyToMany
    @JoinTable(
            name = "productrecipe",
            joinColumns = @JoinColumn(name = "recid"),
            inverseJoinColumns = @JoinColumn(name = "prodid")
    )
    private Set<Recipe> recipes;
}
