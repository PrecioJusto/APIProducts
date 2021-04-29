package app.preciojusto.products.services;

import app.preciojusto.products.entities.Brand;
import app.preciojusto.products.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    BrandRepository brandRepository;

    public Brand findById(Long id){
        // Exception handler must be implemented
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand save(Long id, String name) {
        Brand brand;
        if (id != null) brand = this.findById(id);
        else brand = new Brand();
        brand.setBranname(name);
        return brandRepository.save(brand);
    }
}
