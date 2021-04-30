package app.preciojusto.products.controllers;

import app.preciojusto.products.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
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

    @ResponseBody
    @GetMapping("/addDefaultInfo")
    public Boolean addDefaultInfo() {
        try {
            this.brandService.save(null, "coca cola");
            this.categoryService.save(null, "bebidas", null);
            this.categoryService.save(null, "refrescos", null);
            /* Not working, to be tested
             this.categoryService.setAsChildren("refrescos", "bebidas");
             */
            this.containerService.save(null, "cl", "lata", 33.0);
            this.packService.save(null, 24);
            this.supermarketService.save(null, "carrefour");
            this.productService.save(null, "Coca Cola zero azúcar pack 24 latas 33 cl.", "coca cola",
                    "refrescos", "carrefour");

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
