package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Pack;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackController {

    @Autowired
    private PackService packService;

    @GetMapping("/pack/all")
    public List<Pack> getPacks() {
        return this.packService.findAll();
    }

    @GetMapping("/pack/{id}/get")
    public Pack getPack(@PathVariable Long id) throws ResourceNotFoundException {
        return this.packService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PACK_NOT_FOUND_ERROR));
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
