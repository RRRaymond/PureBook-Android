package com.purebook.purebook_android.base;

import android.os.Handler;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.util.HashMap;




public interface BasePresenter<V extends BaseView>{
    /**
     * 绑定view
     * @param view
     */
    void attachView(V view);

    /**
     * 解绑view
     */
    void detachView();


}