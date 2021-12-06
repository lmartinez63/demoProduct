package com.example.demoProduct.service;

import com.example.demoProduct.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(String id);
    List<Product> getProducts();
    Product createProduct(Product product);
    Product updateProduct(Product product);
}
