package com.zkteco.productservice.service;

import com.zkteco.productservice.dto.ProductRequest;
import com.zkteco.productservice.model.ResultEntity;

public interface ProductService {
    ResultEntity createProducts(ProductRequest productRequest);

    ResultEntity getAllProducts();
}
