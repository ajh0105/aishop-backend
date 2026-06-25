package com.aishop.backend.service;

import com.aishop.backend.domain.Product;
import com.aishop.backend.dto.ProductForm;
import com.aishop.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다. id=" + id));
    }

    @Transactional
    public Product create(ProductForm form) {
        Product product = new Product(
                form.getName(), form.getCategory(), form.getPrice(),
                form.getStock(), form.getAiRecommendScore(), form.getDescription()
        );
        return productRepository.save(product);
    }

    @Transactional
    public Product update(Long id, ProductForm form) {
        Product product = findById(id);
        product.update(form.getName(), form.getCategory(), form.getPrice(),
                form.getStock(), form.getAiRecommendScore(), form.getDescription());
        return product;
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
