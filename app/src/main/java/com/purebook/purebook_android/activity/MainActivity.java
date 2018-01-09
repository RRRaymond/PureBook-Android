package com.purebook.purebook_android.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.presenter.MainPresenter;
import com.purebook.purebook_android.view.MainView;

import com.purebook.purebook_android.R;

import butterknife.ButterKnife;

/**
 * MainActivity
 * @author chrischen
 */
public class MainActivity extends AppCompatActivity implements MainView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }




}
