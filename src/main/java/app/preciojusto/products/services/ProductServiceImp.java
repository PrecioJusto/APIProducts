package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.FoodproductDTO;
import app.preciojusto.products.entities.FoodProduct;
import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.Product;
import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.FoodProductRepository;
import app.preciojusto.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    private OfferService offerService;

    @Autowired
    private ContainerService containerService;

    private final int PAGE_SIZE = 1;

    @Transactional
    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Transactional
    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<FoodProduct> findProductByProdid(Long id) {
        return this.foodProductRepository.findProductByProdid(id);
    }

    @Transactional
    @Override
    public Product saveFoodproductDTO(FoodproductDTO request) throws ResourceNotFoundException {
        FoodProduct foodProduct;
        if (request.getId() != null) foodProduct = this.foodProductRepository.findProductByProdid(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.FOODPRODUCT_NOT_FOUND_ERROR));
        else {
            foodProduct = new FoodProduct();
            foodProduct.setProdviews(0L);
        }
        foodProduct.setProdname(request.getName());
        foodProduct.setCategory(this.categoryService.findByCatenameEquals(request.getCategoryName())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR)));

        foodProduct.setBrand(this.brandService.findByBrannameEquals(request.getBrandName())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR)));

        if (request.getPackQuant() != null)
            foodProduct.setPack(this.packService.findByPackquantity(request.getPackQuant())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PACK_NOT_FOUND_ERROR)));
        else
            foodProduct.setPack(null);

        if (request.getContainerId() != null)
            foodProduct.setContainer(this.containerService.findById(request.getContainerId())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CONTAINER_NOT_FOUND_ERROR)));
        else
            foodProduct.setContainer(null);

        try {
            return this.productRepository.save(foodProduct);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.FOODPRODUCT_ALREADY_EXISTS_ERROR);
        }
    }

    @Transactional
    @Override
    public Boolean delete(Long id) {
        try {
            this.productRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public List<Product> getAllFromIds(List<Long> productsId) {
        List<Product> products = new ArrayList<>();
        productsId.forEach((id) -> this.findById(id).ifPresentOrElse(products::add, () -> products.add(null)));
        return products;
    }

    @Transactional
    @Override
    public List<Product> findAllByProdnameContaining(String name, int page) {
        return this.productRepository.findAllByProdnameContaining(name, PageRequest.of(page, this.PAGE_SIZE));
    }

    @Transactional
    @Override
    public List<Product> findAllByCategory_Catename(String name, int page) {
        return this.productRepository.findAllByCategory_Catename(name, PageRequest.of(page, this.PAGE_SIZE));
    }

    @Transactional
    @Override
    public Product findProductByIdAndUpdateViews(Long id) {
        Product product = this.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR));
        product.setProdviews(product.getProdviews() + 1);
        return this.productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> findProductByBrand_BrannameAndProdnameOrderByProdname(String branname, String prodname) {
        return this.productRepository.findProductByBrand_BrannameAndProdnameOrderByProdname(branname, prodname);
    }

    @Override
    public List<Product> findAllByProdcreatedtimeIsNotNullOrderByProdviewsDesc(int page) {
        return this.productRepository.findAllByProdcreatedtimeIsNotNullOrderByProdviewsDesc(PageRequest.of(page, this.PAGE_SIZE));
    }

    @Override
    public List<Product> findAllProductWithOffer() {
        Set<Offer> offersRandoms = new HashSet<>();
        int totalOfferSize = this.offerService.findAll().size();

        while (offersRandoms.size() < 61) {
            System.out.println(offersRandoms.size());
            int random_int = (int) Math.floor(Math.random() * (totalOfferSize - 1 + 1) + 1);
            Optional<Offer> offerToAdd = this.offerService.findOfferById((long) random_int);
            offerToAdd.ifPresent(offersRandoms::add);
            if (offersRandoms.size() == totalOfferSize) break;
        }

        Set<Product> products = new HashSet<>();
        for (Offer offer : offersRandoms) {
            Optional<SupermarketProduct> sp = offer.getSupermarketProducts().stream().findFirst();
            sp.ifPresent(supermarketProduct -> products.add(supermarketProduct.getProdid()));
        }
        return new ArrayList<>(products);
    }

}
