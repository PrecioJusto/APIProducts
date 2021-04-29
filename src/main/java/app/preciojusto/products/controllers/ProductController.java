package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Category;
import app.preciojusto.products.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class  ProductController {

    @GetMapping("/product/all")
    public List<Product> getProducts(){
        return null;
    }

    @GetMapping("/product/{id}/get")
    public Product getProduct(@PathVariable Long id){
      return null;
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
