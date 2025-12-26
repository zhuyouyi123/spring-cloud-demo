package com.demo.order.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 配置批量绑定在nacos下 可以不需要通过@RefreshScope注解 就能实现自动刷新
@ConfigurationProperties(prefix = "order")
@Data
public class OrderProperties {

    private String timeout;

    private String autoConfirm;

    private String test;
}
