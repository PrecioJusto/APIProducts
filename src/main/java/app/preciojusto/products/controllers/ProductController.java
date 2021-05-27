package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.FoodproductDTO;
import app.preciojusto.products.entities.Product;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
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

    @PostMapping("/product/getallfromlist")
    public List<Product> getAllProductFromList(@RequestBody List<Long> products) throws ResourceNotFoundException {
        return this.productService.getAllFromIds(products);
    }

    @GetMapping("/product/{name}/getallfromname")
    public List<Product> getAllProductFromName(@PathVariable String name) throws ResourceNotFoundException {
        return this.productService.findAllByProdnameContaining(name);
    }

    @GetMapping("/product/{catename}/getallfromcatename")
    public List<Product> getAllProductFromCatename(@PathVariable String catename) throws ResourceNotFoundException {
        return this.productService.findAllByCategory_Catename(catename);
    }

    @GetMapping("/product/{id}/get")
    public Product getProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return this.productService.findProductByIdAndUpdateViews(id);
    }

    @PostMapping("/foodproduct/add")
    public Product postAddFoodroduct(@RequestBody FoodproductDTO request) throws ResourceNotFoundException {
        if (request.getId() != null || request.getBrandName() == null || request.getName() == null || request.getCategoryName() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.productService.saveFoodproductDTO(request);
    }

    @PutMapping("/foodproduct/update")
    public Product putUpdateProduct(@RequestBody FoodproductDTO request) throws ResourceNotFoundException {
        if (request.getId() == null || request.getBrandName() == null || request.getName() == null || request.getCategoryName() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.productService.saveFoodproductDTO(request);
    }

    @DeleteMapping("/product/{id}/delete")
    public Boolean deleteProduct(@PathVariable Long id) {
        return this.productService.delete(id);
    }

}
