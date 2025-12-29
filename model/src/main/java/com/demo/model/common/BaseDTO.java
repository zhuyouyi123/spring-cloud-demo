package com.demo.model.common;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础DTO
 *
 * @date 2022年02月24日
 */
public class BaseDTO {

    /**
     * 预处理
     */
    public void preHandle() {

    }

    /**
     * 验证参数是否合法
     */
    public void validate() {

    }

    /**
     * Trim
     *
     * @param str {@link String}
     * @return {@link String}
     */
    protected String trim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * Trim to null string.
     *
     * @param str {@link String}
     * @return {@link String}
     */
    protected String trimToNull(String str) {
        return StringUtils.trimToNull(str);
    }

    /**
     * Trim to empty string.
     *
     * @param str {@link String}
     * @return {@link String}
     */
    protected String trimToEmpty(String str) {
        return StringUtils.trimToEmpty(str);
    }

    /**
     * 去重
     *
     * @param <T>  类
     * @param list list
     * @return {@link List}
     */
    protected <T> List<T> distinct(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}
