package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.CategoryImageDTO;
import app.preciojusto.products.entities.Category;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        Category childCategory = this.categoryRepository.findByCatenameEquals(childName)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
        Category parentCategory = this.categoryRepository.findByCatenameEquals(parentName)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
        childCategory.setCateparent(parentCategory);
        return this.categoryRepository.save(parentCategory);
    }

    @Override
    public Optional<Category> findByCatenameEquals(String name) {
        return this.categoryRepository.findByCatenameEquals(name);
    }

    @Override
    public Category save(Category request) throws ResourceNotFoundException {
        Category category;
        if (request.getCateid() != null) {
            category = this.findById(request.getCateid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
            category.setCatename(request.getCatename());
            category.setCateimg(request.getCateimg());
        } else category = request;
        try {
            return this.categoryRepository.save(category);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.CATEGORY_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Category saveImg(CategoryImageDTO request) {
        Category c = this.findById(request.getCateid())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
        c.setCateimg(request.getCateImgUrl());
        return this.save(c);
    }

    @Override
    public List<Category> findAllPageable(int page) {
        return this.categoryRepository.findAllByCatenameIsNotNull(PageRequest.of(page, 20));
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
