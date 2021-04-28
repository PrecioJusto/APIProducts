package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reciid;

    private String reciname;

    private String recitext;

    private Integer recipeople;

    private Integer recicalvalue;

    private String recitime;

    private String recidifficulty;

    private String reciingredients;

    @ManyToMany(mappedBy = "recipes")
    private Set<FoodProduct> foodProducts;
}
