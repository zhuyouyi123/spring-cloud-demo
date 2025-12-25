package com.demo.model.bean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Order {

    private Long id;

    /**
     * 总价
     */
    private BigDecimal totalAmount;

    private Long userId;

    private String nickname;

    private String address;

    private List<ProductInfo> productInfos;

    @Data
    @Builder
    public static class ProductInfo {
        private Long productId;
        private Integer num;
        private BigDecimal price;
        private String name;
    }

}
