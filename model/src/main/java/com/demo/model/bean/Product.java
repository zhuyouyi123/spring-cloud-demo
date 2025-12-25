package com.demo.model.bean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private Long id;
    private String projectName;
    private BigDecimal price;
    private int num;
    private String description;

}
