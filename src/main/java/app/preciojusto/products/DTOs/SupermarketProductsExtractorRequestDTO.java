package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupermarketProductsExtractorRequestDTO {

    private String name;
    private String img;
    private Integer price;
    private Boolean stock;
    private String supermarket;
    private OfferExtractorRequestDTO offer;
}
