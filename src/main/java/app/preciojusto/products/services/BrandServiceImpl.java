package app.preciojusto.products.services;

import app.preciojusto.products.entities.Brand;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Optional<Brand> findById(Long id) {
        return this.brandRepository.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public Brand save(Brand request) throws ResourceNotFoundException, ResourceAlreadyExistsException {
        Brand brand;
        if (request.getBranid() != null) {
            brand = this.findById(request.getBranid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR));
            brand.setBranname(request.getBranname());
        } else brand = request;
        try {
            return this.brandRepository.save(brand);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.BRAND_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Optional<Brand> findByBrannameEquals(String name) {
        return this.brandRepository.findByBrannameEquals(name);
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        try {
            this.brandRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
