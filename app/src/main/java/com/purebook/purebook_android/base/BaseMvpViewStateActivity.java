package com.purebook.purebook_android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.umeng.analytics.MobclickAgent;
import com.zhy.changeskin.SkinManager;

public abstract class BaseMvpViewStateActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpViewStateActivity<V, P> {
    protected void onPause() {
        super.onPause();
        //TODO:
        // AVAnalytics.onPause(this);
        MobclickAgent.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        //TODO:
        // AVAnalytics.onResume(this);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SkinManager.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().unregister(this);
    }
}
