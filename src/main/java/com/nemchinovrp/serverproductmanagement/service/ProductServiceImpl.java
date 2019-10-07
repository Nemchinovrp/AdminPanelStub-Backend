package com.nemchinovrp.serverproductmanagement.service;

import com.nemchinovrp.serverproductmanagement.repository.ProductRepository;
import com.nemchinovrp.serverproductmanagement.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Long numberOfProducts() {
        return productRepository.count();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
