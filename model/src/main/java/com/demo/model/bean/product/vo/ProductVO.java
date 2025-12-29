package com.demo.model.bean.product.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private Long id;
    private String projectName;
    private BigDecimal price;
    private int num;
    private String description;
}
