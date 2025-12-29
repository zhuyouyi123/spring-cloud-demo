package com.demo.product.controller;

import com.demo.model.bean.Product;
import com.demo.model.bean.product.vo.ProductVO;
import com.demo.model.common.RespVO;
import com.demo.product.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
@Slf4j
// 自动刷新 配置中心修改的值 可以动态刷新
@RefreshScope
public class ProductApiController {

    @Resource
    private ProductService productService;


    @Value("${product.timeout}")
    private String timeout;

    @Value("${product.auto-confirm}")
    private String autoConfirm;

    @GetMapping("/{id}")
    public RespVO<ProductVO> getProduct(@PathVariable("id") String id, HttpServletRequest request) throws InterruptedException {
        String header = request.getHeader("X-Token");
        String requestURI = request.getRequestURI();
        log.info("X-Token:{}, RequestUrl:{}", header, requestURI);
       // TimeUnit.SECONDS.sleep(2);
       // int a =  10/0;
        return RespVO.success(productService.getProductById(id));
    }

    @GetMapping("config")
    public String getConfig() {
        return "timeout:" + timeout + " autoConfirm:" + autoConfirm;
    }

}
