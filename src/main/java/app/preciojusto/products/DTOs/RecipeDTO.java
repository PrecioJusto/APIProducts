package app.preciojusto.products.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@NoArgsConstructor
public class RecipeDTO {
    private Long reciid;

    private String reciname;

    private String recitext;

    private Integer recipeople;

    private Integer recicalvalue;

    private String recitime;

    private String recidifficulty;

    private String reciingredients;

    private List<Long> products;
}
