package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Brand;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return this.brandService.findAll();
    }

    @GetMapping("/brand/{id}")
    public Brand getBrand(@PathVariable Long id) throws ResourceNotFoundException {
        return this.brandService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR));
    }

    @PostMapping("/brand")
    public Brand postAddBrand(@RequestBody Brand request) throws ResourceNotFoundException {
        if (request.getBranname() == null || request.getBranid() != null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.brandService.save(request);
    }

    @PutMapping("/brand")
    public Brand putUpdateBrand(@RequestBody Brand request) throws ResourceNotFoundException {
        if (request.getBranname() == null || request.getBranid() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.brandService.save(request);
    }

    @DeleteMapping("/brand/{id}")
    public Boolean deleteBrand(@PathVariable Long id) throws ResourceNotFoundException {
        return this.brandService.delete(id);
    }

}
