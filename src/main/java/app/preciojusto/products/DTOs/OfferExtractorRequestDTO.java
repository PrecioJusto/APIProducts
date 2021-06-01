package app.preciojusto.products.DTOs;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferExtractorRequestDTO {
    private String offer_type;
    private Integer ofpepreviousprice;
    private Double ofpepercentage;
    private Integer ofunfirst;
    private Integer ofunsecond;
    private Integer ofupunitaffected;
    private Double ofuppercentage;
    private Integer ofupunits;
    private Integer ofupprice;
    private  String ofunname;
}
