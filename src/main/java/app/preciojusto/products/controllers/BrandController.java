package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Brand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BrandController {

    @GetMapping("/brand/all")
    public List<Brand> getBrands(){
        return null;
    }

    @GetMapping("/brand/{id}/get")
    public Brand getBrand(@PathVariable Long id){
        return null;
    }

    @PostMapping("/brand/add")
    public Brand postAddBrand(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/brand/{id}/update")
    public Brand putUpdateBrand(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/brand/{id}/delete")
    public Boolean deleteBrand(@RequestBody String payload) {
        return false;
    }

}
