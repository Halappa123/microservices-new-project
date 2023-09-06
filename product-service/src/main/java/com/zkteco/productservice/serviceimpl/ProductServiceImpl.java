package com.zkteco.productservice.serviceimpl;

import com.zkteco.productservice.dto.ProductRequest;
import com.zkteco.productservice.dto.ProductResponse;
import com.zkteco.productservice.model.Product;
import com.zkteco.productservice.model.ResultEntity;
import com.zkteco.productservice.repository.ProductRepository;
import com.zkteco.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResultEntity createProducts(ProductRequest productRequest) {
        Product product=new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());

        productRepository.save(product);
        return new ResultEntity("Product is Added successfully",product);
    }

    @Override
    public ResultEntity getAllProducts() {
       List<Product> products= productRepository.findAll();

        products.stream().map(this::mapToProductResponse).toList();
        return new ResultEntity("All products are fetched successfully",products);
    }

    private ProductResponse mapToProductResponse(Product product) {

        ProductResponse productResponse=new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
