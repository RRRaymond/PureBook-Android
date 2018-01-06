package com.purebook.purebook_android.base;

/**
 * Created by chrischen on 2018/1/2.
 */

public interface BaseView {
    /**
     * @Description 进行耗时操作显示进度条
     * @param isShow
     */
    void showProgress(boolean isShow);

    /**
     * @Description 显示网络请求错误的接口
     * @param errorCode
     * @param errorDesc
     * @param errorUrl
     */
    void showOkHttpError(int errorCode,String errorDesc,String errorUrl);

    /**
     * @Description 服务器端请求错误的接口
     * @param errorCode
     * @param errorDesc
     */
    void showServerError(int errorCode,String errorDesc);

    /**
     * @Description 请求成功后对应ui做出改变的接口
     * @param isSuccess
     */
    void showSuccess(boolean isSuccess);


    void showToast(String msg);
}
