package com.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private final Integer code;
    private final String desc;
}
