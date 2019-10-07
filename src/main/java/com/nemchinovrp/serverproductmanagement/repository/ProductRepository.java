package com.nemchinovrp.serverproductmanagement.repository;

import com.nemchinovrp.serverproductmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
