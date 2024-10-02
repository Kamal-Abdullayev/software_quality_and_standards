package com.taltech.demo.service;

import com.taltech.demo.model.Product;
import com.taltech.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return unwrapProduct(product);
    }

    public Long deleteProductById(Long id) {
        productRepository.deleteById(id);
        return id;
    }


    static Product unwrapProduct(Optional<Product> entity) {
        if (entity.isPresent()) return entity.get();
        return null;
    }

}
