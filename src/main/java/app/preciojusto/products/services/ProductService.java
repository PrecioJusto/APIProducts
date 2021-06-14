package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.FoodproductDTO;
import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Product;
import app.preciojusto.products.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Optional<FoodProduct> findProductByProdid(Long id);

    Product saveFoodproductDTO(FoodproductDTO request) throws ResourceNotFoundException;

    Boolean delete(Long id);

    List<Product> getAllFromIds(List<Long> productsId);

    List<Product> findTopProducts();

    List<Product> findAllByProdnameContainingPage(String name, int page);
    
    List<Product> findAllByProdnameContaining(String name);

    List<Product> findAllByCategory_CatenamePaged(String name, int page);

    List<Product> findAllByCategory_Catename(String name);

    Product findProductByIdAndUpdateViews(Long id);

    Optional<Product> findProductByBrand_BrannameAndProdnameOrderByProdname(String branname, String prodname);

    List<Product> findAllByProdcreatedtimeIsNotNullOrderByProdviewsDesc(int page);

    List<Product> findAllProductWithOffer();
}
