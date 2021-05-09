package app.preciojusto.products.services;

import app.preciojusto.products.entities.Category;
import app.preciojusto.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category setAsChildren(String childName, String parentName) {
        Category childCategory = this.categoryRepository.findByCatenameEquals(childName);
        Category parentCategory = this.categoryRepository.findByCatenameEquals(parentName);
        childCategory.setCateparent(parentCategory);
        return this.categoryRepository.save(parentCategory);
    }

    @Override
    public Category findByCatenameEquals(String name) {
        return this.categoryRepository.findByCatenameEquals(name);
    }

    @Override
    public Category save(Category category) throws Exception {
        /*if (category.getCateid() != null) category = this.findById(ca).get();
        else category = new Category();
        category.setCatename(name);
        return this.categoryRepository.save(category);*/
        return null;
    }
}
