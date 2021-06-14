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

    @GetMapping("/products")
    public List<Product> getProducts() {
        return this.productService.findAll();
    }

    @GetMapping("/products/page/{page}")
    public List<Product> getProductsPage(@PathVariable int page) {
        return this.productService.findAllByProdcreatedtimeIsNotNullOrderByProdviewsDesc(page);
    }

    @GetMapping("/products/top")
    public List<Product> getTopProducts() {
        return this.productService.findTopProducts();
    }

    @GetMapping("/products/offer")
    public List<Product> getProductsPageOffer() {
        return this.productService.findAllProductWithOffer();
    }

    @PostMapping("/products/idslist")
    public List<Product> getAllProductFromList(@RequestBody List<Long> products) throws ResourceNotFoundException {
        return this.productService.getAllFromIds(products);
    }

    @GetMapping("/products/name/{name}/{page}")
    public List<Product> getAllProductFromName(@PathVariable String name, @PathVariable int page) throws ResourceNotFoundException {
        return this.productService.findAllByProdnameContainingPage(name, page);
    }

    @GetMapping("/products/name/{name}")
    public List<Product> getAllProductFromName(@PathVariable String name) throws ResourceNotFoundException {
        return this.productService.findAllByProdnameContaining(name);
    }

    @GetMapping("/products/catename/{catename}/{page}")
    public List<Product> getAllProductFromCatenamePaged(@PathVariable String catename, @PathVariable int page) throws ResourceNotFoundException {
        return this.productService.findAllByCategory_CatenamePaged(catename, page);
    }

    @GetMapping("/products/catename/{catename}")
    public List<Product> getAllProductFromCatename(@PathVariable String catename) throws ResourceNotFoundException {
        return this.productService.findAllByCategory_Catename(catename);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) throws ResourceNotFoundException {
        return this.productService.findProductByIdAndUpdateViews(id);
    }

    @PostMapping("/foodproduct")
    public Product postAddFoodroduct(@RequestBody FoodproductDTO request) throws ResourceNotFoundException {
        if (request.getId() != null || request.getBrandName() == null || request.getName() == null || request.getCategoryName() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.productService.saveFoodproductDTO(request);
    }

    @PutMapping("/foodproduct")
    public Product putUpdateProduct(@RequestBody FoodproductDTO request) throws ResourceNotFoundException {
        if (request.getId() == null || request.getBrandName() == null || request.getName() == null || request.getCategoryName() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.productService.saveFoodproductDTO(request);
    }

    @DeleteMapping("/product/{id}")
    public Boolean deleteProduct(@PathVariable Long id) {
        return this.productService.delete(id);
    }

}
