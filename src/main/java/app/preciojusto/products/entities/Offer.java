package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offeid;

    @OneToMany(mappedBy = "offer", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    Set<SupermarketProduct> supermarketProducts;
}
