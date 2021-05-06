package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Pack;
import app.preciojusto.products.entities.Product;
import app.preciojusto.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SupermarketService supermarketService;

    @Autowired
    private SupermarketProductService supermarketProductService;

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    // To be tested
    @Override
    public Product saveFoodProduct(Long id, String name, String brandName, String categoryName, String supermarketName, Container container, Pack pack) {
        FoodProduct p;
        if (id != null) p = (FoodProduct) this.findById(id).get();
        else p = new FoodProduct();
        p.setProdname(name);

        p.setCategory(this.categoryService.findByCatenameEquals(categoryName));
        p.setBrand(this.brandService.findByBrannameEquals(brandName));
        p.setContainer(container);
        p.setPack(pack);

        return this.productRepository.save(p);
    }
}
