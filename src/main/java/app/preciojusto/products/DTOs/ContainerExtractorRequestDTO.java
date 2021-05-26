package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContainerExtractorRequestDTO {


    private String containerType;
    private String containerUnit;
    private Double containerQuantity;
}
