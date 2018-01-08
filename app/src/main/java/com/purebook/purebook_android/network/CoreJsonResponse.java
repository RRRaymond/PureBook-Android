package com.purebook.purebook_android.network;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by chrischen on 2018/1/9.
 */

public class CoreJsonResponse implements Callback {
    private static final String RESULT_CODE = "status";
    private static final String RESULT_MSG = "message";
    private static final String RESULT_CODE_VALUE = "1";

    private Class<?> mClass;
    private Handler mHandler;
    private Gson gson = new Gson();
    private NetworkRequestListener mListener;

    public CoreJsonResponse(NetworkExecutor networkExecutor) {
        this.mClass = networkExecutor.mClass;
        this.mListener = networkExecutor.mListener;
        this.mHandler = new Handler(Looper.getMainLooper());//切换回主线程
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onRequestFail("网络异常");
                mListener.onRequestComplete();
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    /**
     * 处理服务器返回的响应
     * @param result
     */
    private void handleResponse(String result) {
        if (result == null && result.equals("")) {
            mListener.onRequestFail("网络异常");
            mListener.onRequestComplete();
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (jsonObject.has(RESULT_CODE)) {
                if (jsonObject.optString(RESULT_CODE).equals(RESULT_CODE_VALUE)) {
                    if (mClass == null) {
                        //直接返回json字段
                        mListener.onRequestSuccess(jsonObject);
                    } else {
                        //将json转换为实体对象
                        Object object = gson.fromJson(jsonObject.toString(), mClass);
                        if (object == null) {
                            mListener.onRequestFail("json解析失败");
                        } else {
                            //返回实体对象
                            mListener.onRequestSuccess(object);
                        }
                    }
                } else {
                    mListener.onRequestFail(jsonObject.optString(RESULT_MSG));
                }
            } else {

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mListener.onRequestComplete();
    }
}