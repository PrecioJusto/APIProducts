package app.preciojusto.products.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(unique = true)
    private String catename;

    private String cateimg;

    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "cateparent", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Category> catechildrens;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cateparent", nullable = true)
    private Category cateparent;
}
