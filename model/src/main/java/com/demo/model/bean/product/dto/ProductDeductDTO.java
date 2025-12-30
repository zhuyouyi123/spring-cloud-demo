package com.demo.model.bean.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDeductDTO {

    /**
     * 购买数量 扣减库存
     */
    @NotNull(message = "购买数量不能为空")
    private Integer num;
}
