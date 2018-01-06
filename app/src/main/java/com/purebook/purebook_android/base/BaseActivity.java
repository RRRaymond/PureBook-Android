package com.purebook.purebook_android.base;

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


public abstract class BaseActivity extends RxAppCompatActivity implements BaseView {

    private static final String TAG = "BaseActivity";

    protected BaseActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无ActionBar，单在继承AppCompatActivity时无效，继承Activity时才有效
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//保持竖屏

        this.mActivity=this;
        initLayout();//初始化布局
        ButterKnife.bind(this);
        initView();//初始化View
    }


    /**
     * 初始化布局
     */
    protected abstract void initLayout() ;

    /**
     * 初始化View
     */
    protected abstract void initView() ;




    /**
     * 设置进入
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    protected void openActivty(Class<?> mclass){
        Intent intent=new Intent(this,mclass);
        startActivity(intent);
    }

    /**
     * 设置退出
     */
    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }
}
