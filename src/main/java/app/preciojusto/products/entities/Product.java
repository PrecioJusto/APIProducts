package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodid;

    private String prodname;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "branid", nullable = false)
    Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cateid", nullable = false)
    Category category;

    @OneToMany(mappedBy = "prodid", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    Set<SupermarketProduct> supermarketProducts;

}
