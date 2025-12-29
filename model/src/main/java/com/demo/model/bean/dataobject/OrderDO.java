package com.demo.model.bean.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("orders")
public class OrderDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 总价
     */
    private BigDecimal totalAmount;

    private Long userId;

    private String nickname;

    private String address;

    private String productIds;
}
