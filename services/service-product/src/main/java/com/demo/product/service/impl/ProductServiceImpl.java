package com.demo.product.service.impl;

import com.demo.model.bean.Product;
import com.demo.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    /**
     * 根据id查询商品
     *
     * @param id 商品id
     */
    @Override
    public Product getProductById(String id) {
        return Product.builder()
                .id(Long.valueOf(id))
                .projectName("product")
                .price(new BigDecimal("10.0"))
                .description("product description")
                .num(10)
                .build();
    }
}
