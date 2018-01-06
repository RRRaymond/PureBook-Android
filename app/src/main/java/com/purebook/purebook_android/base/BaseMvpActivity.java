package com.purebook.purebook_android.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Activity实现mvp的基类
 * @param <P>
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定View
        mPresenter.attachView(this);
        initData();
    }

    /**
     * 加载数据
     */
    protected abstract void initData();


    /**
     * 系统提示信息
     * @param msg
     */
    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 解绑
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


}