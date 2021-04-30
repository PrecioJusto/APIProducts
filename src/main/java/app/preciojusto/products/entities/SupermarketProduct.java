package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private SupermarketProductCK id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("supeid")
    private Supermarket supeid;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("prodid")
    private Product prodid;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "offeid", nullable = false)
    private Offer offer;

    private Integer supprice;

    private LocalDateTime suprlastupdated;

    private String suprimg;

    private Boolean suprstock;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        SupermarketProduct that = (SupermarketProduct) o;
        return Objects.equals(this.id, that.id) && Objects.equals(this.supeid, that.supeid) && Objects.equals(this.prodid, that.prodid) && Objects.equals(this.supprice, that.supprice) && Objects.equals(this.suprlastupdated, that.suprlastupdated) && Objects.equals(this.suprimg, that.suprimg) && Objects.equals(this.suprstock, that.suprstock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.supeid, this.prodid, this.supprice, this.suprlastupdated, this.suprimg, this.suprstock);
    }
}
