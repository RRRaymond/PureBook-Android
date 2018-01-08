package com.purebook.purebook_android.base;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.util.HashMap;




public class BasePresenter<T> implements BaseRequestCallBack<T>{
    BaseView mView;

    public BasePresenter(BaseView mView, Context context) {
        this.mView = mView;
    }

    /**
     * 以下的回调方法对应View层的相应操作
     */

    @Override
    public void requestBefore() {
        mView.startLoadView();
    }

    @Override
    public void requestFail(String msg) {
        mView.onFail(msg);
    }

    @Override
    public void requestSuccess(T data) {
        mView.onSuccess(data);
    }

    @Override
    public void requestComplete() {
        mView.stopLoadView();
    }


}