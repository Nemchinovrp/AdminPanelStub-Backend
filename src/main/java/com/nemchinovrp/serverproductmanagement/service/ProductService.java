package com.nemchinovrp.serverproductmanagement.service;

import com.nemchinovrp.serverproductmanagement.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);

    Long numberOfProducts();

    List<Product> findAllProducts();
}
