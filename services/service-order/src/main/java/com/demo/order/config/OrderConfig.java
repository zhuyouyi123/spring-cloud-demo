package com.demo.order.config;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public Logger.Level feignlogLevel() {
        // 指定 OpenFeign 发请求时，日志级别为 FULL
        return Logger.Level.FULL;
    }

    @Bean
    Retryer retryer() {
        // 默认重试策略
        return new Retryer.Default();
    }
}
