package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.module.Product;
import com.example.fooddeliveryapp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long productID) {
        return productRepository.findById(productID).get();
    }
    public List<Product> filterProductsByName(String criteria) {
        return productRepository.findProductByNameContainingOrDescriptionContaining(criteria, criteria);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


    public Product updateProduct(Product product, Long productID) {
        product.setProductId(productID);
        return productRepository.save(product);
    }

    public Product partiallyUpdateProduct(Product product, Long productID) {
        Product updatedProduct = productRepository.findById(productID).get();
        if(product.getName() != null) {
            updatedProduct.setName(product.getName());
        }

        if(product.getDescription() != null ) {
            updatedProduct.setDescription(product.getDescription());
        }

        if(product.getRestaurant() != null) {
            updatedProduct.setRestaurant(product.getRestaurant());
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long productID) {
        Product product = productRepository.findById(productID).get();
        productRepository.delete(product);
    }
}
