package org.evanke.springbootmall.service;

import org.evanke.springbootmall.dto.CreateOrderRerquest;
import org.evanke.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRerquest createOrderRerquest);
}
