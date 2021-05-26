package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ExtractorFoodproductDTO {

    private String name;
    private String brand;
    private String category;
    private List<SupermarketProductsExtractorRequestDTO> supermarketProducts;
    private ContainerExtractorRequestDTO container;
    private Integer pack;
    private String product_type;
}
