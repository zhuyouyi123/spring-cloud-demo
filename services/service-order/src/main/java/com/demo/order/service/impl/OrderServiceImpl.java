package com.demo.order.service.impl;

import com.demo.model.bean.Order;
import com.demo.model.bean.Product;
import com.demo.order.feign.ProductFeignClient;
import com.demo.order.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ProductFeignClient productFeignClient;


    /**
     * 创建订单
     *
     * @param userId    用户id
     * @param productId 商品id
     */
    @Override
    public Order createOrder(Long userId, Long productId) {
        Product product = productFeignClient.getProduct(productId + "", "");
//        Product product = getProductByIdWithLoadBalancer(productId);


        return Order.builder()
                .id(1L)
                .totalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())))
                .userId(userId)
                .nickname("demo")
                .address("address")
                .productInfos(
                        Arrays.asList(product)
                )
                .build();
    }

    private Product getProductById(Long productId) {
        // 获取所有商品服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        if (CollectionUtils.isEmpty(instances)) {
            return Product.builder()
                    .price(new BigDecimal("0"))
                    .num(0)
                    .build();
        }
        ServiceInstance serviceInstance = instances.get(0);

        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + host + ":" + port + "/product/" + productId;

        return restTemplate.getForObject(url, Product.class);
    }

    private Product getProductByIdWithLoadBalancer(Long productId) {
        // 获取所有商品服务实例
//        ServiceInstance instance = loadBalancerClient.choose("service-product");
//        if (Objects.isNull(instance)) {
//            return Product.builder()
//                    .price(new BigDecimal("0"))
//                    .num(0)
//                    .build();
//        }

//        String host = instance.getHost();
//        int port = instance.getPort();
//        String url = "http://" + host + ":" + port + "/product/" + productId;
        String url = "http://service-product/product/" + productId;
        log.info("创建订单请求调用了url: " + url);
        return restTemplate.getForObject(url, Product.class);
    }
}
