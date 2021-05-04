package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodid;

    private String prodname;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "branid", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cateid", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "prodid", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<SupermarketProduct> supermarketProducts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "packid", referencedColumnName = "packid")
    private Pack pack;

}
