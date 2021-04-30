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
            this.brandService.save(null, "coca");
            this.categoryService.save(null, "bebidas", null);
            this.categoryService.save(null, "refrescos", null);
            // this.categoryService.setAsChildren("refrescos", "bebidas");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
