package com.demo.model.bean.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("product")
public class ProductDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String projectName;
    private BigDecimal price;
    private int num;
    private String description;
}
