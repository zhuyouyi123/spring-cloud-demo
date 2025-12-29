package com.demo.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RtGlobalFilter implements GlobalFilter, Ordered {
    /**
     * Process the Web request and (optionally) delegate to the next {@code GatewayFilter}
     * through the given {@link GatewayFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        log.info("请求开始:{}", request.getURI());
        long startTime = System.currentTimeMillis();

        // 这边是异步的 doFinally 会在请求结束的时候执行
        // 后面增加的方法 不会等filter执行完成
        return chain.filter(exchange)
                .doFinally(result -> log.info("请求结束:{}, -response:{}, 使用时间:{}ms",
                        request.getURI(),response.getStatusCode(), System.currentTimeMillis() - startTime));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
