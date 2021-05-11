package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Supermarket;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupermarketController {

    @Autowired
    private SupermarketService supermarketService;

    @GetMapping("/supermarket/all")
    public List<Supermarket> getSupermarkets() {
        return this.supermarketService.findAll();
    }

    @GetMapping("/supermarket/{id}/get")
    public Supermarket getSupermarket(@PathVariable Long id) throws ResourceNotFoundException {
        return this.supermarketService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR));
    }

    @PostMapping("/supermarket/add")
    public Supermarket postAddSupermarket(@RequestBody Supermarket request) throws ResourceNotFoundException {
        if (request.getSupename() == null || request.getSupeid() != null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketService.save(request);
    }

    @PutMapping("/supermarket/update")
    public Supermarket putUpdateSupermarket(@RequestBody Supermarket request) throws ResourceNotFoundException {
        if (request.getSupename() == null || request.getSupeid() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketService.save(request);
    }

    @DeleteMapping("/supermarket/{id}/delete")
    public Boolean deleteSupermarket(@PathVariable Long id) throws ResourceNotFoundException {
        return this.supermarketService.delete(id);
    }

}
