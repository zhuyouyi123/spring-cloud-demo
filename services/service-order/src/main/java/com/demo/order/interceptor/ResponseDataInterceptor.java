package com.demo.order.interceptor;

import feign.InvocationContext;
import feign.Response;
import feign.ResponseInterceptor;
import feign.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * Feign 响应拦截器：拦截并处理 Feign 调用的响应数据
 */
@Slf4j // 日志注解（需引入 lombok 依赖，也可替换为 System.out）
@Component // 必须注册为 Spring 组件
public class ResponseDataInterceptor implements ResponseInterceptor {

    /**
     * 核心拦截方法：处理响应数据
     * @param invocationContext 调用上下文（包含请求、响应、方法信息等）
     * @param chain 拦截器链：执行下一个拦截器/获取原始响应
     * @return 处理后的响应数据（需返回 chain.proceed() 的结果，否则会丢失响应）
     * @throws Exception 处理过程中的异常
     */
    @Override
    public Object intercept(InvocationContext invocationContext, Chain chain) throws Exception {
        log.info("进入 Feign 响应拦截器");
        // 1. 执行拦截器链，获取原始响应（必须先执行，否则无法拿到响应数据）
        Object originalResponse = chain.next(invocationContext);

        // 2. 解析响应数据（仅处理 Response 类型，Feign 原生响应为 Response 类型）
        if (originalResponse instanceof Response response) {
            // 2.1 记录响应基本信息（日志示例）
            log.info("===== Feign 响应拦截器 =====");
            log.info("响应状态码：{}", response.status());
            log.info("响应头：{}", response.headers());

            // 2.2 读取响应体（注意：响应体流只能读取一次，读取后需重新包装）
            if (response.body() != null) {
                // 读取响应体字节数组
                byte[] bodyBytes = Util.toByteArray(response.body().asInputStream());
                // 转换为字符串（根据实际编码调整，这里用 UTF-8）
                String bodyStr = new String(bodyBytes, StandardCharsets.UTF_8);
                log.info("响应体内容：{}", bodyStr);

                // 2.3 重新包装响应体（避免后续代码读取不到响应体）
                // 重新设置响应体
                // 返回包装后的响应
                return response.toBuilder()
                        .body(bodyBytes)
                        .build();
            }
        }

        // 3. 返回处理后的响应（必须返回，否则业务代码会拿到 null）
        return originalResponse;
    }

    /**
     * 拦截器链拼接（默认实现即可，无需修改）
     */
    @Override
    public ResponseInterceptor andThen(ResponseInterceptor nextInterceptor) {
        return ResponseInterceptor.super.andThen(nextInterceptor);
    }

    /**
     * 构建拦截器链（默认实现即可，无需修改）
     */
    @Override
    public Chain apply(Chain chain) {
        return ResponseInterceptor.super.apply(chain);
    }
}