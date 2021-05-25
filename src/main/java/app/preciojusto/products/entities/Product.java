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

    @Column(unique = true)
    private String prodname;
    
    private Long prodviews;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "branid", nullable = false)
    private Brand brand;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "cateid", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "prodid", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<SupermarketProduct> supermarketProducts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "packid", referencedColumnName = "packid")
    private Pack pack;

}
