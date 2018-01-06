package com.purebook.purebook_android.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment基类
 * @author chrischen
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    protected BaseActivity mBaseActivity;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBaseActivity = (BaseActivity) getActivity();
    }


    /**
     * 加载成功的界面
     *
     * @return 显示子类相应的布局
     */
    protected abstract View createSuccessView();

    /**
     * 请求网络 根据结果传入相应状态
     */
    protected abstract void load();

    @Override
    public void showToast(String msg) {
        mBaseActivity.showToast(msg);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }
}
