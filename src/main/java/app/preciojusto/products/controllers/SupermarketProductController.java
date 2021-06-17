package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.SupermarketProductDTO;
import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.SupermarketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupermarketProductController {

    @Autowired
    private SupermarketProductService supermarketProductService;


    @GetMapping("/api/supermarketproducts")
    public List<SupermarketProduct> getSupermarketproducts() {
        return this.supermarketProductService.findAll();
    }


    @GetMapping("/api/supermarketproduct/{productId}/{supermarketId}")
    public SupermarketProduct getSupermarketproduct(@PathVariable Long productId, @PathVariable Long supermarketId) throws ResourceNotFoundException {
        SupermarketProductCK supermarketProductCK = new SupermarketProductCK(productId, supermarketId);
        return this.supermarketProductService.findById(supermarketProductCK)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKETPRODUCT_NOT_FOUND_ERROR));
    }

    @PostMapping("/api/supermarketproduct")
    public SupermarketProduct postAddSupermarketproduct(@RequestBody SupermarketProductDTO request) throws ResourceNotFoundException {
        if (request.getSuperid() == null || request.getProductid() == null || request.getPrice() == null || request.getImg() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketProductService.add(request);
    }

    @PutMapping("/api/supermarketproduct")
    public SupermarketProduct putUpdateSupermarketproduct(@RequestBody SupermarketProductDTO request) throws ResourceNotFoundException {
        if (request.getSuperid() == null || request.getProductid() == null || request.getPrice() == null || request.getImg() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.supermarketProductService.update(request);
    }

    @DeleteMapping("/api/supermarketproduct/{productId}/{supermarketId}")
    public Boolean deleteSupermarketproduct(@PathVariable Long productId, @PathVariable Long supermarketId) throws ResourceNotFoundException {
        return this.supermarketProductService.delete(productId, supermarketId);
    }
}
