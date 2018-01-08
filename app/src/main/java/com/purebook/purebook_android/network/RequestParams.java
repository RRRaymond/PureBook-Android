package com.purebook.purebook_android.network;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 网络请求参数类
 * @author chrischen
 */
public class RequestParams {
    public ConcurrentHashMap<String, String> stringParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> objectParams = new ConcurrentHashMap<>();

    public RequestParams(){}

    public void put(String key, String value){
        if (key != null && value != null) {
            stringParams.put(key, value);
        }
    }

    public void put(String key, Object value) {
        if (key != null) {
            objectParams.put(key, value);
        }
    }
}
