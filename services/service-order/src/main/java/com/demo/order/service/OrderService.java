package com.demo.order.service;


import com.demo.model.bean.dataobject.OrderDO;
import com.demo.model.bean.order.dto.CreateOrderDTO;

public interface OrderService {

    /**
     * 创建订单
     *
     * @param dto {@link CreateOrderDTO}
     */
    OrderDO createOrder(CreateOrderDTO dto);
}
