package com.purebook.purebook_android.network;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 网络请求客户端
 * @author chrischen
 */

public class NetworkRequestClient {
    private static NetworkRequestClient instance;
    private OkHttpClient mOkHttpClient;
    private static final int TIME_OUT = 10;

    private NetworkRequestClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //支持Https
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        mOkHttpClient = builder.build();
    }

    public static NetworkRequestClient getInstance(){
        if (instance == null) {
            synchronized (NetworkRequestClient.class) {
                if (instance == null) {
                    instance = new NetworkRequestClient();
                }
            }
        }
        return instance;
    }

    /**
     * 发送请求
     * @param request
     * @param executor
     */
    public void sendRequest(Request request, NetworkExecutor executor) {
        Call call = mOkHttpClient.newCall(request);
        executor.mListener.onRequestBefore();
        call.enqueue(new CoreJsonResponse(executor));
    }

}
