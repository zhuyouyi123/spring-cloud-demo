package com.demo.order.feign;

import com.demo.model.bean.product.dto.ProductDeductDTO;
import com.demo.model.bean.product.vo.ProductVO;
import com.demo.model.common.RespVO;
import com.demo.order.feign.fallback.ProductFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// 这里会报错 不支持添加 所以在FeignClient定义path
// @RequestMapping("api/product")
// 说明是一个远程调用的客户端 Feign客户端
// @FeignClient(value = "service-product", fallback = ProductFeignClientFallback.class, path = "product")
@FeignClient(value = "service-product", path = "product")
// @FeignClient(value = "service-product", fallback = ProductFeignClientFallback.class,path = "api/product")
public interface ProductFeignClient {

    @GetMapping("{id}")
    RespVO<ProductVO> getProduct(@PathVariable("id") String id, @RequestHeader("token") String token);

    @PostMapping("deduct/{id}")
    RespVO<ProductVO> deduct(@PathVariable("id") String id, @RequestBody @Validated ProductDeductDTO dto);
}
