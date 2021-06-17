package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.SupermarketImageDTO;
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

    @GetMapping("/api/supermarkets")
    public List<Supermarket> getSupermarkets() {
        return this.supermarketService.findAll();
    }

    @GetMapping("/api/supermarket/{id}")
    public Supermarket getSupermarket(@PathVariable Long id) throws ResourceNotFoundException {
        return this.supermarketService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR));
    }

    @PostMapping("/api/supermarket")
    public Supermarket postAddSupermarket(@RequestBody Supermarket request) throws ResourceNotFoundException {
        if (request.getSupename() == null || request.getSupeid() != null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketService.save(request);
    }

    @PutMapping("/api/supermarket/img")
    public Supermarket postAddSupermarketImage(@RequestBody SupermarketImageDTO request) throws ResourceNotFoundException {
        if (request.getSupeid() == null || request.getSupeImgUrl() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketService.saveImg(request);
    }

    @PutMapping("/api/supermarket")
    public Supermarket putUpdateSupermarket(@RequestBody Supermarket request) throws ResourceNotFoundException {
        if (request.getSupename() == null || request.getSupeid() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketService.save(request);
    }

    @DeleteMapping("/api/supermarket/{id}")
    public Boolean deleteSupermarket(@PathVariable Long id) throws ResourceNotFoundException {
        return this.supermarketService.delete(id);
    }

}
