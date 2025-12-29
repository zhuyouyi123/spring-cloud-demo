package com.demo.product.controller;

import com.demo.model.bean.Product;
import com.demo.model.bean.dataobject.ProductDO;
import com.demo.model.bean.product.dto.CreateProductDTO;
import com.demo.model.bean.product.vo.ProductVO;
import com.demo.model.common.RespVO;
import com.demo.product.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @GetMapping("{id}")
    public RespVO<ProductVO> getProduct(@PathVariable("id") String id, HttpServletRequest request) {
        String header = request.getHeader("X-Token");
        String requestURI = request.getRequestURI();
        log.info("X-Token:{}, RequestUrl:{}", header, requestURI);
       // TimeUnit.SECONDS.sleep(2);
       // int a =  10/0;
        ProductVO product = productService.getProductById(id);
        if (Objects.isNull(product)){
            return RespVO.failure("商品不存在");
        }
        log.info("product:{}", product);
        return RespVO.success(product);
    }

    @GetMapping("config")
    public String getConfig() {
        return "timeout:" + timeout + " autoConfirm:" + autoConfirm;
    }

    @PostMapping("create")
    public RespVO<ProductDO> create(@RequestBody @Validated CreateProductDTO dto) {
        ProductDO product = productService.createProduct(dto);
        return RespVO.success(product);
    }

}
