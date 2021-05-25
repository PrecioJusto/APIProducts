package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.FoodproductDTO;
import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Product;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.FoodProductRepository;
import app.preciojusto.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FoodProductRepository foodProductRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private PackService packService;

    @Autowired
    private SupermarketService supermarketService;

    @Autowired
    private SupermarketProductService supermarketProductService;

    @Autowired
    private ContainerService containerService;

    @Override
    public Optional<Product> findById(final Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<FoodProduct> findProductByProdid(final Long id) {
        return this.foodProductRepository.findProductByProdid(id);
    }

    @Override
    public Product saveFoodproductDTO(final FoodproductDTO request) throws ResourceNotFoundException {
        final FoodProduct foodProduct;
        if (request.getId() != null) {
            foodProduct = this.foodProductRepository.findProductByProdid(request.getId())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.FOODPRODUCT_NOT_FOUND_ERROR));
        } else {
            foodProduct = new FoodProduct();
            foodProduct.setProdviews(0L);
        }
        foodProduct.setProdname(request.getName());
        foodProduct.setCategory(this.categoryService.findByCatenameEquals(request.getCategoryName())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR)));

        foodProduct.setBrand(this.brandService.findByBrannameEquals(request.getBrandName())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR)));

        if (request.getPackQuant() != null) {
            foodProduct.setPack(this.packService.findByPackquantity(request.getPackQuant())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PACK_NOT_FOUND_ERROR)));
        } else {
            foodProduct.setPack(null);
        }

        if (request.getContainerId() != null) {
            foodProduct.setContainer(this.containerService.findById(request.getContainerId())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CONTAINER_NOT_FOUND_ERROR)));
        } else {
            foodProduct.setContainer(null);
        }

        try {
            return this.productRepository.save(foodProduct);
        } catch (final Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.FOODPRODUCT_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Boolean delete(final Long id) {
        try {
            this.productRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR)));
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    @Override
    public List<Product> getAllFromIds(final List<Long> productsId) {
        final List<Product> products = new ArrayList<>();
        productsId.forEach((id) -> this.findById(id).ifPresentOrElse(products::add, () -> products.add(null)));
        return products;
    }

    @Override
    public List<Product> findAllByProdnameContaining(final String name) {
        return this.productRepository.findAllByProdnameContaining(name);
    }

    @Override
    public List<Product> findAllByCategory_Catename(final String name) {
        return this.productRepository.findAllByCategory_Catename(name);
    }

    @Override
    public Product findProductByIdAndUpdateViews(final Long id) {
        final Product product = this.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR));
        product.setProdviews(product.getProdviews() + 1);
        return this.productRepository.save(product);
    }


}
