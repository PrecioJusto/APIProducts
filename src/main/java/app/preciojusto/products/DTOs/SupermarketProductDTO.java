package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupermarketProductDTO {
    private Long superid;

    private Long productid;

    private Integer price;

    private Long offerid;

    private String img;

    private Boolean stock;
}
