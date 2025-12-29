package com.demo.model.bean.product.dto;

import com.demo.model.common.BaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 创建商品DTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateProductDTO extends BaseDTO {
    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String projectName;
    /**
     * 价格
     */
    @NotNull(message = "价格不能为空")
    private Double price;

    /**
     * 库存
     */
    @NotNull(message = "库存不能为空")
    private Integer num;

    /**
     * 描述
     */
    private String description;

    @Override
    public void validate() {
        if (price <= 0) {
            throw new RuntimeException("价格不能小于0");
        }
        if (num < 0){
            throw new RuntimeException("库存不能小于0");
        }
    }
}
