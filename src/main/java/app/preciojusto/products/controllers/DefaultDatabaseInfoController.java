package app.preciojusto.products.controllers;

import app.preciojusto.products.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DefaultDatabaseInfoController {

    @Autowired
    BrandService brandService;

    @ResponseBody
    @GetMapping("/addDefaultInfo")
    public Boolean addDefaultInfo(){
        try {
            brandService.save(null, "coca");
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
