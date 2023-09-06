package com.zkteco.productservice.controller;

import com.zkteco.productservice.dto.ProductRequest;
import com.zkteco.productservice.model.ResultEntity;
import com.zkteco.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create_product")
    public ResponseEntity<ResultEntity> createProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<ResultEntity>(productService.createProducts(productRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_all_products")
    public ResponseEntity<ResultEntity> getAllProducts(){
        return new ResponseEntity<ResultEntity>(productService.getAllProducts(),HttpStatus.ACCEPTED);
    }
}
