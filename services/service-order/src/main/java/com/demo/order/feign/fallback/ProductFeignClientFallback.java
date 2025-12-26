package com.demo.order.feign.fallback;

import com.demo.model.bean.Product;
import com.demo.order.feign.ProductFeignClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProduct(String id, String token) {
        return Product.builder()
                .id(-1L)
                .price(BigDecimal.ZERO)
                .num(0)
                .description("商品不存在")
                .projectName("兜底处理")
                .build();
    }
}
