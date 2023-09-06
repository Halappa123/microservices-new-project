package com.zkteco.orderservice.controller;

import com.zkteco.orderservice.dto.OrderRequest;
import com.zkteco.orderservice.model.ResultEntity;
import com.zkteco.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place_order")
    public ResponseEntity<ResultEntity> placeOrder(@RequestBody OrderRequest orderRequest ){
        return new ResponseEntity<ResultEntity>(orderService.placeOrder(orderRequest), HttpStatus.valueOf(200));
    }
}
