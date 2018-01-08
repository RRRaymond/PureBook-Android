package com.purebook.purebook_android.base;

/**
 * Created by chrischen on 2018/1/2.
 */

public interface BaseView<T> {
    /**
     * 打开加载框
     */
    void  startLoadView();

    /**
     * 关闭加载框
     */
    void stopLoadView();

    /**
     * 网络请求成功后回调
     * @param data
     */
    void onSuccess(T data);

    /**
     * 网络请求失败后回调
     * @param msg
     */
    void onFail(String msg);
}
