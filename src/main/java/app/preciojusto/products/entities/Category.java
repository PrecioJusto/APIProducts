package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cateid;

    private String catename;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Product> products;


    @OneToMany(cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
    private Set<Category> categories;
}
