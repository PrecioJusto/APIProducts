package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Category;
import app.preciojusto.products.entities.Supermarket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupermarketController {

    @GetMapping("/supermarket/all")
    public List<Supermarket> getSupermarkets(){
        return null;
    }

    @GetMapping("/supermarket/{id}/get")
    public Supermarket getSupermarket(@PathVariable Long id){
        return null;
    }

    @PostMapping("/supermarket/add")
    public Supermarket postAddSupermarket(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/supermarket/{id}/update")
    public Supermarket putUpdateSupermarket(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/supermarket/{id}/delete")
    public Boolean deleteSupermarket(@RequestBody String payload) {
        return false;
    }

}
