package app.preciojusto.products.services;

import app.preciojusto.products.entities.Category;

public interface CategoryService {

    Category findById(Long id);

    Category save(Long id, String name, Long childrenId);

    Category setAsChildren(String childName, String parentName);

    Category findByCatenameEquals(String name);
}
