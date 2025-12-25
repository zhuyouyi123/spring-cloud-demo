package com.demo.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest(classes = ProductMainApplication.class)
public class DiscoveryTest {

    /**
     * 这边仅需了解 后面会自动化配置
     */
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    public void discoverLoads() {
//        0 = "service-order"
//        1 = "service-product"
        List<ServiceInstance> productInstances = discoveryClient.getInstances("service-product");
        productInstances.forEach(instance -> System.out.println(instance.getHost() + ":" + instance.getPort()));

        List<ServiceInstance> orderInstances = discoveryClient.getInstances("service-order");
        orderInstances.forEach(instance -> System.out.println(instance.getHost() + ":" + instance.getPort()));

        try {
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances("service-order");
            instances.forEach(instance -> System.out.println(instance.getHost() + ":" + instance.getPort()));
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

}
