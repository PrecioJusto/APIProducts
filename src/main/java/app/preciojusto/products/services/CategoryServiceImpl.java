package app.preciojusto.products.services;

import app.preciojusto.products.entities.Category;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
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
    public Category save(Category request) throws ResourceNotFoundException {
        Category category;
        if (request.getCateid() != null) {
            category = this.findById(request.getCateid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
            category.setCatename(request.getCatename());
        } else category = request;
        try {
            return this.categoryRepository.save(category);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.CATEGORY_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        try {
            this.categoryRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
