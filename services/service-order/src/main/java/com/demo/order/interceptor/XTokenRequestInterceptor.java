package com.demo.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 使用方式
 * yml中服务中添加 request-interceptor: XTokenRequestInterceptor(全类名)
 * Component 自动装配
 */
@Component
@Slf4j
public class XTokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        log.info("请求拦截器执行");
        template.header("X-Token", "123456");

    }
}
