package com.purebook.purebook_android.network;

/**
 * 网络请求回调接口
 * @author chrischen
 */

public interface NetworkRequestListener {
    /**
     * 网络请求前回调,进行加载框的展示
     */
    void onRequestBefore();

    /**
     * 网络请求成功后回调，进行数据的处理和展示
     * @param object
     */
    void onRequestSuccess(Object object);

    /**
     * 网络请求失败后回调，提示请求失败信息
     * @param msg
     */
    void onRequestFail(String msg);

    /**
     * 网络请求完成后回调，关闭加载框
     */
    void onRequestComplete();
}
