package com.purebook.purebook_android.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.purebook.purebook_android.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Activity基类
 * @author chrischen
 */


public abstract class BaseActivity<V extends BaseView<P>,P extends BasePresenter<V>> extends Activity {

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无ActionBar，单在继承AppCompatActivity时无效，继承Activity时才有效
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//保持竖屏
        ButterKnife.bind(this);

        this.mPresenter = getPresenter();

    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();


    }

    public abstract P getPresenter();


}
