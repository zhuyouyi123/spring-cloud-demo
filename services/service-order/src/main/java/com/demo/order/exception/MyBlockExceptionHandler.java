package com.demo.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.demo.model.common.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * 自定义限流异常处理
 */
@Component
@Slf4j
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, String resourceName, BlockException e) throws Exception {
        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            R r = R.error(-1, resourceName + "被Sentinel限制了" + e.getMessage());
            writer.write(JSON.toJSONString(r));
            writer.flush();
        } catch (Exception ex) {
            log.error("MyBlockExceptionHandler error:{}", ex.getMessage());
        }
    }
}
