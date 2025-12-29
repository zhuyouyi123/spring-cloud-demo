package com.demo.model.common;

import lombok.Data;

@Data
public class R {
    private int code;
    private String message;
    private Object data;

    public static R ok(Object data) {
        R r = new R();
        r.setCode(200);
        r.setMessage("成功");
        r.setData(data);
        return r;
    }

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setMessage("成功");
        r.setData(null);
        return r;
    }

    public static R error(int code, String message) {
        R r = new R();
        r.setCode(code);
        r.setMessage(message);
        r.setData(null);
        return r;
    }

    public static R error(String message) {
        return error(-1, message);
    }
}
