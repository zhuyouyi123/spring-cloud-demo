package com.demo.gateway.predicate;

import jakarta.validation.constraints.NotEmpty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
@Slf4j
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {

    /**
     * Header key.
     */
    public static final String PARAM_KEY = "param";

    /**
     * Regexp key.
     */
    public static final String VALUE_KEY = "value";

    public VipRoutePredicateFactory() {
        super(VipRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_KEY, VALUE_KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(VipRoutePredicateFactory.Config config) {

        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                // 可以获取到请求参数和请求值
                ServerHttpRequest request = exchange.getRequest();
                String first = request.getQueryParams().getFirst(config.param);
                log.info("自定义 断言工厂 param:{}, value:{}", first, config.value);
                return StringUtils.hasText(first);
            }

            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public String toString() {
                return String.format("Header: %s regexp=%s", config.param, config.value);
            }
        };
    }

    @Validated
    public static class Config {

        @NotEmpty
        private String param;

        private String value;

        public String getParam() {
            return param;
        }

        public VipRoutePredicateFactory.Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getValue() {
            return value;
        }

        public VipRoutePredicateFactory.Config setValue(String value) {
            this.value = value;
            return this;
        }

    }
}
