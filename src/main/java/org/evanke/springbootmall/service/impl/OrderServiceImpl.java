package org.evanke.springbootmall.service.impl;

import org.evanke.springbootmall.dao.OrderDao;
import org.evanke.springbootmall.dao.ProductDao;
import org.evanke.springbootmall.dto.BuyItem;
import org.evanke.springbootmall.dto.CreateOrderRerquest;
import org.evanke.springbootmall.model.Order;
import org.evanke.springbootmall.model.OrderItem;
import org.evanke.springbootmall.model.Product;
import org.evanke.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemByOrderId(orderId);

        order.setOrderItemList(orderItemList);
        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRerquest createOrderRerquest) {

        if (createOrderRerquest == null || createOrderRerquest.getBuyItemList() == null
                || createOrderRerquest.getBuyItemList().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "購買清單不可為空");
        }

        int totalAmount = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem:createOrderRerquest.getBuyItemList()){
            if (buyItem == null || buyItem.getProductId() == null
                    || buyItem.getQuantity() == null || buyItem.getQuantity() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "商品 ID 與正整數購買數量為必填");
            }
            Product product = productDao.getProductById(buyItem.getProductId());
            if (product == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "商品不存在");
            }

            // 計算總價錢
            int amount;
            try {
                amount = Math.multiplyExact(product.getPrice(), buyItem.getQuantity());
                totalAmount = Math.addExact(totalAmount, amount);
            } catch (ArithmeticException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "訂單金額超過上限");
            }

            // 在同一筆交易內檢查並扣庫存，避免同時下單造成超賣。
            if (!productDao.decreaseStock(buyItem.getProductId(), buyItem.getQuantity())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "商品庫存不足");
            }

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);


        }


        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);
        return orderId;
    }
}
