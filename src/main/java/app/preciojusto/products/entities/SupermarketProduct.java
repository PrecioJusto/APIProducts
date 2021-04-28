package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "supermarketproduct")
public class SupermarketProduct {
    @EmbeddedId
    SuperMarketProductCK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("supeid")
    Supermarket supeid;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("prodid")
    Product prodid;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "offeid", nullable = false)
    Offer offer;

    Integer supprice;

    LocalDateTime suprlastupdated;

    String suprimg;

    Boolean suprstock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupermarketProduct that = (SupermarketProduct) o;
        return Objects.equals(id, that.id) && Objects.equals(supeid, that.supeid) && Objects.equals(prodid, that.prodid) && Objects.equals(supprice, that.supprice) && Objects.equals(suprlastupdated, that.suprlastupdated) && Objects.equals(suprimg, that.suprimg) && Objects.equals(suprstock, that.suprstock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supeid, prodid, supprice, suprlastupdated, suprimg, suprstock);
    }
}
