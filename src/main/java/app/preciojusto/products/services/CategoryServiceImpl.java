package app.preciojusto.products.services;

import app.preciojusto.products.entities.Category;
import app.preciojusto.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    /**
     * Adds a new children to the parent category.
     *
     * @param childName  name of the children category.
     * @param parentName name of the parent category.
     * @return the parent category TEMPORARY
     */
    @Override
    public Category setAsChildren(String childName, String parentName) {
        Category childCategory = this.categoryRepository.findByCatenameEquals(childName);
        Category parentCategory = this.categoryRepository.findByCatenameEquals(parentName);
        // Not working too be checked
        parentCategory.getCategories().add(childCategory);
        return this.categoryRepository.save(parentCategory);
    }

    @Override
    public Category findByCatenameEquals(String name) {
        return this.categoryRepository.findByCatenameEquals(name);
    }

    @Override
    public Category save(Long id, String name, Long childrenId) {
        Category category;
        if (id != null) {
            category = this.findById(id);
        } else {
            category = new Category();
        }
        category.setCatename(name);
        if (childrenId != null) {
            category.getCategories().add(this.findById(childrenId));
        }
        return this.categoryRepository.save(category);
    }
}
