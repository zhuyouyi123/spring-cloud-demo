package com.demo.order;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoadBalancerTest {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void testLoadBalancer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-product");
        System.out.println(serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }

}
