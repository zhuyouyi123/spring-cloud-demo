package com.demo.order.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.model.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 需要返回json数据
// @ResponseBody
// 需要全局异常处理器
// @ControllerAdvice
// 可以被合成注解代替
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlockException.class)
    public R handleBlockException(BlockException e) {
        return R.error(-1, "限流了");
    }

}
