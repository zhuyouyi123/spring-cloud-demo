package com.demo.order.service;


import com.demo.model.bean.Order;

public interface OrderService {

    /**
     * 创建订单
     *
     * @param userId     用户id
     * @param productId  商品id
     */
    Order createOrder(Long userId, Long productId);
}
