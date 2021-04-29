package app.preciojusto.products.services;

import app.preciojusto.products.entities.Product;
import app.preciojusto.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Product save(Long id, String name, String brandName, String categoryName, String supermarketName) {
        Product p;
        if (id != null) {
            p = this.findById(id);
        } else {
            p = new Product();
        }
        p.setProdname(name);
        p.setCategory(this.categoryService.findByCatenameEquals(categoryName));
        p.setBrand(this.brandService.findByBrannameEquals(brandName));
        return p;
    }
}
