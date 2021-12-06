package com.example.demoProduct.repository;

import com.example.demoProduct.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query
    List<Product> findByName();
}
