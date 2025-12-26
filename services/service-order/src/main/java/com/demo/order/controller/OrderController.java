package com.demo.order.controller;

import com.demo.model.bean.Order;
import com.demo.order.properties.OrderProperties;
import com.demo.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderProperties orderProperties;

    @GetMapping("create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {

        return orderService.createOrder(userId, productId);
    }

    @GetMapping("config")
    public String getConfig() {
        String timeout = "timeout:" + orderProperties.getTimeout();
        String autoConfirm = "autoConfirm:" + orderProperties.getAutoConfirm();
        String test = "test:" + orderProperties.getTest();
        return timeout + " " + autoConfirm+ " " + test;
    }

}
