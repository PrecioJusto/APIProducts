package app.preciojusto.products.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class SupermarketProductCK implements Serializable {
    @Column(name = "supeid")
    private Long supeid;

    @Column(name = "prodid")
    private Long prodid;

    public SupermarketProductCK(Long prodid, Long supeid) {
        this.supeid = supeid;
        this.prodid = prodid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SupermarketProductCK that = (SupermarketProductCK) o;
        return Objects.equals(this.supeid, that.supeid) && Objects.equals(this.prodid, that.prodid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.supeid, this.prodid);
    }
}
