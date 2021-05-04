package app.preciojusto.products.controllers;

import app.preciojusto.products.repositories.OfferPercentageRepository;
import app.preciojusto.products.repositories.OfferUnitRepository;
import app.preciojusto.products.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultDatabaseInfoController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PackService packService;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private SupermarketService supermarketService;

    @Autowired
    private SupermarketProductService supermarketProductService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private OfferPercentageRepository offerPercentageRepository;

    @Autowired
    private OfferUnitRepository offerUnitRepository;

    @ResponseBody
    @GetMapping("/addDefaultInfo")
    public Boolean addDefaultInfo() {
        try {

            this.brandService.save(null, "coca cola");
            this.categoryService.save(null, "bebidas");
            this.categoryService.save(null, "refrescos");
            this.containerService.save(null, "cl", "lata", 33.0);
            this.packService.save(null, 24);
            this.supermarketService.save(null, "carrefour");

            /*
            this.productService.save(null, "Coca Cola zero azúcar pack 24 latas 33 cl.", "coca cola",
                    "refrescos", "carrefour");
*/
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
