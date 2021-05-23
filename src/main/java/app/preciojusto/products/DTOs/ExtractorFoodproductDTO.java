package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ExtractorFoodproductDTO {

    private Long id;

    private String name;

    private String brand;

    private String categoryName;

    private Long containerId;

    private Integer packQuant;
}
