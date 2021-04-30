package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @GetMapping("/category/all")
    public List<Category> getCategories() {
        return null;
    }

    @GetMapping("/category/{id}/get")
    public Category getCategory(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/category/add")
    public Category postAddCategory(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/category/{id}/update")
    public Category putUpdateCategory(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/category/{id}/delete")
    public Boolean deleteCategory(@RequestBody String payload) {
        return false;
    }

}
