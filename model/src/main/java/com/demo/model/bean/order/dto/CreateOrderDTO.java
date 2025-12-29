package com.demo.model.bean.order.dto;

import lombok.Data;

/**
 * 创建订单参数
 */
@Data
public class CreateOrderDTO {

    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 收货地址
     */
    private String address;


}
