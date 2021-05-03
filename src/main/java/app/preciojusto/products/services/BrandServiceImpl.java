package app.preciojusto.products.services;

import app.preciojusto.products.entities.Brand;
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
    public Brand save(Long id, String name) {
        Brand brand;
        if (id != null) brand = this.findById(id).get();
        else brand = new Brand();

        brand.setBranname(name);
        return this.brandRepository.save(brand);
    }

    @Override
    public Brand findByBrannameEquals(String name) {
        return this.brandRepository.findByBrannameEquals(name);
    }
}
