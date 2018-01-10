package com.purebook.purebook_android.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.presenter.MainPresenter;
import com.purebook.purebook_android.view.MainView;

import com.purebook.purebook_android.R;

import butterknife.ButterKnife;

/**
 * MainActivity
 * @author chrischen
 */
public class MainActivity extends AppCompatActivity implements BaseView<BaseBean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void startLoadView() {
        //loadView.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoadView() {
        //loadView.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(BaseBean data){

    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onResume() {
        super.onResume();
    }




}
