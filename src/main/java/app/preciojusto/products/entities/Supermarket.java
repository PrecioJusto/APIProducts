package app.preciojusto.products.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "supermarket")
public class Supermarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supeid;

    @Column(unique = true)
    private String supename;

    @JsonIgnore
    @OneToMany(mappedBy = "supeid", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<SupermarketProduct> supermarketProducts;

}