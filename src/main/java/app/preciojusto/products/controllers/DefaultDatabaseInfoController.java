package app.preciojusto.products.controllers;

import app.preciojusto.products.services.BrandService;
import app.preciojusto.products.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultDatabaseInfoController {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @ResponseBody
    @GetMapping("/addDefaultInfo")
    public Boolean addDefaultInfo() {
        try {
            this.brandService.save(null, "coca");
            this.categoryService.save(null, "bebidas", null);
            this.categoryService.save(null, "refrescos", null);
            this.categoryService.setAsChildren("refrescos", "bebidas");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
