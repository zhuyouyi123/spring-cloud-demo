package com.demo.order.feign;

import com.demo.model.bean.Product;
import com.demo.order.feign.fallback.ProductFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

// 说明是一个远程调用的客户端 Feign客户端
@FeignClient(value = "service-product", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable("id") String id, @RequestHeader("token") String token);
}
