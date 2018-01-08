package com.purebook.purebook_android.base;

/**
 * 数据请求的回调接口
 * @param <T>
 */

public interface BaseRequestCallBack<T> {
    /**
     * 网络请求开始前回调
     */
    void requestBefore();

    /**
     * 网络请求失败后回调
     */
    void requestFail(String msg);

    /**
     * 网络请求成功后回调
     * @param data
     */
    void requestSuccess(T data);

    /**
     * 网络请求结束后回调
     */
    void requestComplete();
}
