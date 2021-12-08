package com.example.demoProduct.service.impl;

import com.example.demoProduct.entity.Product;
import com.example.demoProduct.entity.ProductDetail;
import com.example.demoProduct.service.ProductDetailService;
import com.example.demoProduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductDetailServiceImpl implements ProductDetailService {

    ProductService productService;

    @Override
    public List<ProductDetail> getProductDetailsByProductId(String productId) {

        Product product = productService.getProductById(productId);
        return product.getProductDetails();
    }

}
