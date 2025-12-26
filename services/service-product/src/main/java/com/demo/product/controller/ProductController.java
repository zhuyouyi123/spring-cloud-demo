package com.demo.product.controller;

import com.demo.model.bean.Product;
import com.demo.product.service.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@Slf4j
// 自动刷新 配置中心修改的值 可以动态刷新
@RefreshScope
public class ProductController {

    @Resource
    private ProductService productService;


    @Value("${product.timeout}")
    private String timeout;

    @Value("${product.auto-confirm}")
    private String autoConfirm;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

    @GetMapping("config")
    public String getConfig() {
        return "timeout:" + timeout + " autoConfirm:" + autoConfirm;
    }

}
