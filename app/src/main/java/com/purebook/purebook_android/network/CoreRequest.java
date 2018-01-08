package com.purebook.purebook_android.network;

import java.util.Map;
import java.util.logging.Logger;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * 网络请求核心类
 * @author chrischen
 */

public class CoreRequest {
    /**
     * get请求
     * @param url
     * @param params
     * @return
     */
    public static Request doGetRequest(String url, RequestParams params) {
        StringBuilder sb = new StringBuilder(url).append("?");
        if (params != null) {
            for (Map.Entry<String, String> entry : params.stringParams.entrySet()) {
                sb.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }
        Request request = new Request.Builder().get().url(sb.substring(0, sb.length() - 1)).build();
        return request;
    }

    /**
     * post请求
     * @param url
     * @param params
     * @return
     */
    public static Request doPostRequest(String url, RequestParams params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.stringParams.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody body = builder.build();
        Request request = new Request.Builder().post(body).url(url).build();
        return request;
    }


}
