package com.zkteco.orderservice.service;

import com.zkteco.orderservice.dto.OrderRequest;
import com.zkteco.orderservice.model.ResultEntity;

public interface OrderService {
    ResultEntity placeOrder(OrderRequest orderRequest);
}
