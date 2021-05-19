package app.preciojusto.products.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity(name = "foodproduct")
public class FoodProduct extends Product {

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "contid")
    private Container container;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "productrecipe",
            joinColumns = @JoinColumn(name = "prodid"),
            inverseJoinColumns = @JoinColumn(name = "reciid")
    )
    private Set<Recipe> recipes;
}
