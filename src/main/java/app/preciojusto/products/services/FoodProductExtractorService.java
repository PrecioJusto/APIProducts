package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.ExtractorFoodproductDTO;
import app.preciojusto.products.DTOs.OfferExtractorRequestDTO;
import app.preciojusto.products.DTOs.SupermarketProductDTO;
import app.preciojusto.products.DTOs.SupermarketProductsExtractorRequestDTO;
import app.preciojusto.products.entities.*;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;

public interface FoodProductExtractorService {

    Boolean checkGlobalExtract(ExtractorFoodproductDTO product);


    Brand checkBrandExtract(ExtractorFoodproductDTO extractor) throws ResourceNotFoundException;
    Category checkCategoryExtract(ExtractorFoodproductDTO extractor) throws Exception;
    Pack checkPackExtract(ExtractorFoodproductDTO extractor) throws ResourceNotFoundException;
    Supermarket checkSupermarketExtract(SupermarketProductsExtractorRequestDTO extractor);
    Container checkContainerExtract(ExtractorFoodproductDTO extractor);
    Offer checkOfferExtract(OfferExtractorRequestDTO extractor);

    List<SupermarketProductDTO> checkSupermarketProductExtract(FoodProduct foodProduct, List<SupermarketProductsExtractorRequestDTO> extractor);
}
