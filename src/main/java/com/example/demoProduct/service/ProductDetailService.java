package com.example.demoProduct.service;

import com.example.demoProduct.entity.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    public List<ProductDetail> getProductDetailsByProductId(String productId);

}
