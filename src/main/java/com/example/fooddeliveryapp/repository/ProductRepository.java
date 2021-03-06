package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findProductByNameContainingOrDescriptionContaining(String criteria1, String criteria2);
}
