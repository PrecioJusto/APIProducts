package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.SupermarketProductDTO;
import app.preciojusto.products.entities.SupermarketProduct;
import app.preciojusto.products.entities.SupermarketProductCK;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.SupermarketProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SupermarketProductServiceImpl implements SupermarketProductService {

    @Autowired
    private SupermarketProductRepository supermarketProductRepository;

    @Autowired
    private SupermarketService supermarketService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OfferService offerService;

    @Override
    public Optional<SupermarketProduct> findById(SupermarketProductCK id) {
        return this.supermarketProductRepository.findById(id);
    }

    @Override
    public List<SupermarketProduct> findAll() {
        return this.supermarketProductRepository.findAll();
    }

    @Transactional
    @Override
    public SupermarketProduct add(SupermarketProductDTO request) throws ResourceNotFoundException {
        if (this.findById(new SupermarketProductCK(request.getProductid(), request.getSuperid())).isPresent())
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.SUPERMARKETPRODUCT_ALREADY_EXISTS_ERROR);
        SupermarketProduct supermarketProduct = new SupermarketProduct();
        supermarketProduct.setId(new SupermarketProductCK(request.getProductid(), request.getSuperid()));
        supermarketProduct.setSuprstock(request.getStock());
        supermarketProduct.setSuprprice(request.getPrice());
        supermarketProduct.setSuprimg(request.getImg());
        this.productService.findById(request.getProductid()).ifPresentOrElse(
                supermarketProduct::setProdid,
                () -> {
                    throw new ResourceNotFoundException(ApplicationExceptionCode.PRODUCT_NOT_FOUND_ERROR);
                });
        this.supermarketService.findById(request.getSuperid()).ifPresentOrElse(
                supermarketProduct::setSupeid,
                () -> {
                    throw new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR);
                });
        if (request.getOfferid() != null)
            this.offerService.findOfferById(request.getOfferid()).ifPresent(supermarketProduct::setOffer);
        LocalDateTime now = LocalDateTime.now();
        supermarketProduct.setSuprlastupdated(now);
        try {
            return this.supermarketProductRepository.save(supermarketProduct);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.SUPERMARKETPRODUCT_ALREADY_EXISTS_ERROR);
        }
    }

    @Transactional
    @Override
    public SupermarketProduct update(SupermarketProductDTO request) throws ResourceNotFoundException {
        SupermarketProduct supermarketProduct = this.findById(new SupermarketProductCK(request.getProductid(), request.getSuperid()))
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKETPRODUCT_NOT_FOUND_ERROR));
        if (request.getOfferid() != null)
            this.offerService.findOfferById(request.getOfferid()).ifPresent(supermarketProduct::setOffer);
        else
            supermarketProduct.setOffer(null);
        supermarketProduct.setSuprstock(request.getStock());
        supermarketProduct.setSuprprice(request.getPrice());
        LocalDateTime now = LocalDateTime.now();
        supermarketProduct.setSuprlastupdated(now);
        try {
            return this.supermarketProductRepository.save(supermarketProduct);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.SUPERMARKETPRODUCT_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public SupermarketProduct save(SupermarketProduct supermarketProduct) {
        return this.supermarketProductRepository.save(supermarketProduct);
    }

    @Override
    public Boolean delete(Long productId, Long supermarketId) {
        try {
            this.supermarketProductRepository.delete(this.findById(new SupermarketProductCK(productId, supermarketId))
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKETPRODUCT_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
