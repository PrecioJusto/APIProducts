package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.*;
import app.preciojusto.products.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
    OfferService offerService;

    @Autowired
    private SupermarketProductService supermarketProductService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/addDefaultInfo")
    public Boolean addDefaultInfo() {
        try {

            this.brandService.save(null, "coca cola");

            this.categoryService.save(null, "bebidas");
            this.categoryService.save(null, "refrescos");

            this.containerService.save(null, "cl", "lata", 33.0);
            this.packService.save(null, 24);

            Supermarket s = this.supermarketService.save(null, "carrefour");
            Supermarket a = this.supermarketService.save(null, "alcampo");
            Supermarket e = this.supermarketService.save(null, "el corte ingles");

            this.categoryService.setAsChildren("refrescos", "bebidas");

            Offer offer = this.offerService.saveOfferPercentage(null, 20, 3.0);

            Container c = this.containerService.findById(1L).get();
            Pack p = this.packService.findById(1L).get();
            Product product = this.productService.saveFoodProduct(null, "Coca Cola zero azúcar pack 24 latas 33 cl.", "coca cola",
                    "refrescos", "carrefour", c, p);


            LocalDateTime now = LocalDateTime.now();
            this.supermarketProductService.save(s.getSupeid(), product.getProdid(), 15, offer.getOffeid(), "test", true, now);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
