package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class SuperMarketProductCK implements Serializable {
    @Column(name="supermarketId")
    Long supeid;

    @Column(name="productId")
    Long prodid;

    public SuperMarketProductCK(Long supeid, Long prodid){
        this.supeid = supeid;
        this.prodid = prodid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperMarketProductCK that = (SuperMarketProductCK) o;
        return Objects.equals(supeid, that.supeid) && Objects.equals(prodid, that.prodid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supeid, prodid);
    }
}
