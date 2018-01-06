package com.purebook.purebook_android.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;


public  abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定View
        mPresenter.attachView(this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this.getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 解绑
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}

