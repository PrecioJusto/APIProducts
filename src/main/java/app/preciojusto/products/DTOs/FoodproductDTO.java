package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FoodproductDTO {

    private Integer id;

    private String name;

    private String brandName;

    private String categoryName;

    private String superName;

    private Integer containerId;

    private Integer packId;
    
}
