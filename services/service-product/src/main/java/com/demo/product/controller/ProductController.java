package com.demo.product.controller;

import com.demo.model.bean.Product;
import com.demo.product.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

}
