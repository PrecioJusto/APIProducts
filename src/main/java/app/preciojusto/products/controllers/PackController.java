package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Pack;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PackController {
    @GetMapping("/pack/all")
    public List<Pack> getPacks(){
        return null;
    }

    @GetMapping("/pack/{id}/get")
    public Pack getPack(@PathVariable Long id){
        return null;
    }

    @PostMapping("/pack/add")
    public Pack postAddPack(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/pack/{id}/update")
    public Pack putUpdatePack(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/pack/{id}/delete")
    public Boolean deletePack(@RequestBody String payload) {
        return false;
    }
}
