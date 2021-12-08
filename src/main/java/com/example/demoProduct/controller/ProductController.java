package com.example.demoProduct.controller;

import com.example.demoProduct.entity.Product;
import com.example.demoProduct.entity.ProductDetail;
import com.example.demoProduct.service.ProductDetailService;
import com.example.demoProduct.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
@RestController
@Slf4j
public class ProductController {

    ProductService productService;
    ProductDetailService productDetailService;

    @RequestMapping(method = RequestMethod.GET, value = "/product/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductById(@PathVariable String id){
        log.info("action=getProduct id=", id);
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productDetails/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductDetailsById(@PathVariable String id){
        log.info("action=getProductDetailsById id=", id);
        List<ProductDetail> productDetailList = productDetailService.getProductDetailsByProductId(id);
        return ResponseEntity.ok(productDetailList);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("action=createProduct product=", objectMapper.writeValueAsString(product));
        Product dbproduct = productService.createProduct(product);
        return ResponseEntity.ok(dbproduct);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProducts(){
        log.info("action=getProducts ");
        return ResponseEntity.ok(productService.getProducts());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProducts(@RequestBody Product product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("action=updateProduct product=", objectMapper.writeValueAsString(product));
        return ResponseEntity.ok(productService.updateProduct(product));
    }

}
