package com.example.productservice.service;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@Service("productServiceDB")
public class ProductServiceDBImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        getCategtoryToBeInProduct(product, product);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(long productId, Product product) {

    }

    @Override
    public Product updatePartialProduct(long productId, Product product) {
        Optional<Product> productToUpdateOptional = productRepository.findById(productId);

        if(productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }

        Product productToUpdate = productToUpdateOptional.get();

        if(product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }

        if(product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }

        if(product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }

        if(product.getCategory() != null) {
            getCategtoryToBeInProduct(product, productToUpdate);
        }

        return productRepository.save(productToUpdate);
    }

    private void getCategtoryToBeInProduct(Product product, Product productToUpdate) {
        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findByNameEquals(categoryName);
        Category toBePutInProduct = null;

        if(category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            toBePutInProduct = categoryRepository.save(toSaveCategory);
        } else {
            toBePutInProduct = category.get();
        }

        productToUpdate.setCategory(toBePutInProduct);
    }
}
