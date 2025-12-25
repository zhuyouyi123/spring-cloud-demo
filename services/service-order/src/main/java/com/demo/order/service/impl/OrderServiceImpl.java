package com.demo.order.service.impl;

import com.demo.model.bean.Order;
import com.demo.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class OrderServiceImpl implements OrderService {
    /**
     * 创建订单
     *
     * @param userId    用户id
     * @param productId 商品id
     */
    @Override
    public Order createOrder(Long userId, Long productId) {
        return Order.builder()
                .id(1L)
                .totalAmount(new BigDecimal("10.0"))
                .userId(userId)
                .nickname("demo")
                .address("address")
                .productInfos(
                        Arrays.asList(Order.ProductInfo.builder()
                                .productId(productId)
                                .num(1)
                                .price(new BigDecimal("10.0"))
                                .name("product")
                                .build())
                )
                .build();
    }

    private void getProductById(Long productId) {


    }
}
