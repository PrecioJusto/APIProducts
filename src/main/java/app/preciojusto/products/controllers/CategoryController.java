package app.preciojusto.products.controllers;

import app.preciojusto.products.DTOs.CategoryImageDTO;
import app.preciojusto.products.entities.Category;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return this.categoryService.findAll();
    }

    @ResponseBody
    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable Long id) throws ResourceNotFoundException {
        return this.categoryService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CATEGORY_NOT_FOUND_ERROR));
    }

    @PostMapping("/category")
    public Category postAddCategory(@RequestBody Category request) throws Exception {
        if (request.getCatename() == null || request.getCateid() != null || request.getCateimg() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.categoryService.save(request);
    }

    @PutMapping("/category/img")
    public Category postAddCategory(@RequestBody CategoryImageDTO request) throws Exception {
        if (request.getCateid() == null || request.getCateImgUrl() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.categoryService.saveImg(request);
    }

    @PutMapping("/category")
    public Category putUpdateCategory(@RequestBody Category request) throws Exception {
        if (request.getCatename() == null || request.getCateid() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.categoryService.save(request);
    }

    @DeleteMapping("/category/{id}")
    public Boolean deleteCategory(@PathVariable Long id) throws ResourceNotFoundException {
        return this.categoryService.delete(id);
    }

}
