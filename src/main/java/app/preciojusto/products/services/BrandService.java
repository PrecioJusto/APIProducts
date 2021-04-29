package app.preciojusto.products.services;

import app.preciojusto.products.entities.Brand;

public interface BrandService {
    Brand findById(Long id);

    Brand save(Long id, String name);

    Brand findByBrannameEquals(String name);
}
