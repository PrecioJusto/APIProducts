package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.ExtractorFoodproductDTO;
import app.preciojusto.products.entities.*;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.Optional;

public interface FoodProductExtractorService {

    Boolean checkGlobalExtract(ExtractorFoodproductDTO product);


    Brand checkBrandExtract(ExtractorFoodproductDTO extractor) throws ResourceNotFoundException;
    Category checkCategoryExtract(ExtractorFoodproductDTO extractor) throws Exception;
    Pack checkPackExtract(ExtractorFoodproductDTO extractor) throws ResourceNotFoundException;
    Supermarket checkSupermarketExtract(ExtractorFoodproductDTO extractor);
    Container checkContainerExtract(ExtractorFoodproductDTO extractor);
    Offer checkOfferExtract(ExtractorFoodproductDTO extractor);
}
