package com.demo.model.bean.order.vo;

import com.demo.model.bean.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {

    private Long id;

    /**
     * 总价
     */
    private BigDecimal totalAmount;

    private Long userId;

    private String nickname;

    private String address;

    private List<Product> productInfos;
}
