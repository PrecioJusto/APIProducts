package app.preciojusto.products.services;

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

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product save(Long id, String name, String brandName, String categoryName, String supermarketName) {
        Product p;
        if (id != null) p = this.findById(id).get();
        else p = new Product();
        p.setProdname(name);
        p.setCategory(this.categoryService.findByCatenameEquals(categoryName));
        p.setBrand(this.brandService.findByBrannameEquals(brandName));
        return this.productRepository.save(p);
    }
}
