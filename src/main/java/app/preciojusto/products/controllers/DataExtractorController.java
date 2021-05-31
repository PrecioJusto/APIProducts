package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.ExtractorFoodproductDTO;
import app.preciojusto.products.services.FoodProductExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class DataExtractorController {

    @Autowired
    private FoodProductExtractorService foodProductExtractorService;

    private final List<ExtractorFoodproductDTO> failedProducts = new LinkedList<>();

    @PostMapping("/extractor/product")
    public List<ExtractorFoodproductDTO> extractProductsFoodProducts(@RequestBody List<ExtractorFoodproductDTO> request)
    {
        int aux = 1;
        for (ExtractorFoodproductDTO productRequest: request) {
            boolean statusProduct = this.foodProductExtractorService.checkGlobalExtract(productRequest);
            System.out.println("Product: " + aux);
            System.out.println("Product checked: " + productRequest.getName());
            if (!statusProduct)failedProducts.add(productRequest);
            aux++;
        }
        return failedProducts;
    }
}
