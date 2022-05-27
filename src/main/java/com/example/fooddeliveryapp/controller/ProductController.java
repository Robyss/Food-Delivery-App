package com.example.fooddeliveryapp.controller;


import com.example.fooddeliveryapp.module.Product;
import com.example.fooddeliveryapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getCouriers() {
        return ResponseEntity.ok(productService.getProducts());
    }
    @GetMapping("/{productID}")
    public ResponseEntity<Product> getCourierById(@PathVariable Long productID) {
        return ResponseEntity.ok(productService.getProduct(productID));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> filterProductsByName(@RequestParam String criteria) {
        return ResponseEntity.ok(productService.filterProductsByName(criteria));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/{productID}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productID) {
        return ResponseEntity.ok(productService.updateProduct(product, productID));
    }


    @PatchMapping("/{productID}")
    public ResponseEntity<Product> partiallyUpdateProduct(@RequestBody Product product, @PathVariable Long productID) {
        return ResponseEntity.ok(productService.partiallyUpdateProduct(product, productID));
    }


    @DeleteMapping("/{productID}")
    public ResponseEntity<String> deleteProduct( @PathVariable Long productID) {
        productService.deleteProduct(productID);
        return ResponseEntity.ok("Product has been deleted successfully!");
    }
}
