package com.earyspace.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;


public record RestBean<T>(int code, T data, String message) {

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, data, "success");
    }

    public String asJsonString() {
        return JSONObject.toJSONString(this);
    }
}
