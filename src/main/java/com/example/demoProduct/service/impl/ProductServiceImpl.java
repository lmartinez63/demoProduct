package com.example.demoProduct.service.impl;

import com.example.demoProduct.entity.Product;
import com.example.demoProduct.exception.EntityNotFoundException;
import com.example.demoProduct.repository.ProductRepository;
import com.example.demoProduct.service.ProductEnrichment;
import com.example.demoProduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames={"products"})
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductEnrichment productEnrichment;

    @Override
    public Product createProduct(Product product) {

        Product dbProduct = productRepository.save(product);
        productEnrichment.enrichProduct(dbProduct);
        return dbProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        //Here we cal the getProductById to identify if product exits in data, if not it will return 404 Produc not found
        Product dbproduct = getProductById(product.getId());
        Product updatedProduct = productRepository.save(product);
        productEnrichment.enrichProduct(updatedProduct);
        return updatedProduct;
    }

    @Cacheable
    @Override
    public Product getProductById(String id) {

        Optional<Product> dbProduct = productRepository.findById(id);
        if (!dbProduct.isPresent()) {
            throw new EntityNotFoundException("Product not found");
        }
        Product product = dbProduct.get();
        productEnrichment.enrichProduct(product);
        return product;
    }

    @Override
    public List<Product> getProducts() {

        List<Product> dbProducts = productRepository.findAll();
        if (dbProducts.isEmpty()) {
            throw new EntityNotFoundException("Products not found");
        }
        dbProducts.stream().forEach(product -> productEnrichment.enrichProduct(product));
        return dbProducts;
    }
}
