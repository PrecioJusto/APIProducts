package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Brand;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brand/all")
    public List<Brand> getBrands() {
        return this.brandService.findAll();
    }

    @GetMapping("/brand/{id}/get")
    public Brand getBrand(@PathVariable Long id) throws ResourceNotFoundException {
        return this.brandService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR));
    }

    @PostMapping("/brand/add")
    public Brand postAddBrand(@RequestBody Brand request) {
        return request;
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
