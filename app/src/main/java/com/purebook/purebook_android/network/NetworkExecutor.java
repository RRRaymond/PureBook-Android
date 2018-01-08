package com.purebook.purebook_android.network;

/**
 * 网络请求处理
 * @author chrischen
 */

public class NetworkExecutor {
    public NetworkRequestListener mListener = null;

    //将json转换为实体对象
    public Class<?> mClass = null;


    public NetworkExecutor(NetworkRequestListener mListener) {
        this.mListener = mListener;
    }

    public NetworkExecutor(NetworkRequestListener mListener, Class<?> mClass) {
        this.mListener = mListener;
        this.mClass = mClass;
    }


}
