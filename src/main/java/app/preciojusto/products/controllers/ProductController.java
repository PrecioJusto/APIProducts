package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.FoodproductDTO;
import app.preciojusto.products.entities.Product;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public List<Product> getProducts() {
        return this.productService.findAll();
    }

    @GetMapping("/foodproduct/all")
    public List<Product> getFoodProducts() {
        return this.productService.findAll();
    }


    @GetMapping("/product/{id}/get")
    public Product getProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return this.productService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR));
    }

    @PostMapping("/product/add")
    public Product postAddProduct(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/product/{id}/update")
    public Product putUpdateProduct(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/product/{id}/delete")
    public Boolean deleteProduct(@RequestBody String payload) {
        return false;
    }

}
