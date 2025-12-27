package com.demo.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    @GetMapping("seckill")
    @SentinelResource(value = "createSeckillOrder", blockHandler = "createSeckillOrderFallback")
    public Order createSeckillOrder(@RequestParam(value = "userId",required = false) Long userId,
                                    @RequestParam(value = "productId",defaultValue = "1") Long productId) {

        Order order = orderService.createOrder(userId, productId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    /**
     * 热点参数限流 必须结合SentinelResource埋点
     * 秒杀订单限流处理
     * 若增加了  @SentinelResource(value = "createSeckillOrder", blockHandler = "createSeckillOrderFallback")
     * 可以这么写 public Order createSeckillOrderFallback(Long userId, Long productId, BlockException exception)
     * 若使用了 fallback BlockException 需要修改成Throwable
     */
    public Order createSeckillOrderFallback(Long userId, Long productId, BlockException exception) {
        Order order = orderService.createOrder(userId, productId);
        order.setId(Long.MAX_VALUE);
        order.setNickname("热点参数限流");
        return order;
    }


    @GetMapping("config")
    public String getConfig() {
        String timeout = "timeout:" + orderProperties.getTimeout();
        String autoConfirm = "autoConfirm:" + orderProperties.getAutoConfirm();
        String test = "test:" + orderProperties.getTest();
        return timeout + " " + autoConfirm + " " + test;
    }

}
