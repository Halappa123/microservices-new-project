package com.zkteco.orderservice.serviceimpl;

import com.zkteco.orderservice.dto.OrderLineItemsDto;
import com.zkteco.orderservice.dto.OrderRequest;
import com.zkteco.orderservice.model.Order;
import com.zkteco.orderservice.model.OrderLineItems;
import com.zkteco.orderservice.model.ResultEntity;
import com.zkteco.orderservice.repository.OrderRepository;
import com.zkteco.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResultEntity placeOrder(OrderRequest orderRequest) {
         Order order=new Order();
         order.setOrderNumber(UUID.randomUUID().toString());

         List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList()
                 .stream()
                 .map(this::mapToDto)
                 .toList();
         order.setOrderLineItemsList(orderLineItems);
         orderRepository.save(order);

         return new ResultEntity("order placed successfully",order);
                 
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
