package com.purebook.purebook_android.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.presenter.MainPresenter;
import com.purebook.purebook_android.view.CustomSearchView;
import com.purebook.purebook_android.view.MainView;

import com.purebook.purebook_android.R;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MainActivity
 * @author chrischen
 */
public class MainActivity extends AppCompatActivity implements BaseView<BaseBean> {

    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.contentView)DrawerLayout drawer;//侧滑菜单
    @BindView(R.id.nav_view)NavigationView navigationView;
    @BindView(R.id.search_view)CustomSearchView searchView;//搜索
    @Nullable
    @BindView(R.id.fab) com.melnykov.fab.FloatingActionButton fab;//悬浮按钮
    @BindView(R.id.activity_main_coordlayout)CoordinatorLayout coordinatorLayout;
    @Nullable
    @BindView(R.id.nav_head_layout)View navLayout;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//butterknife绑定控件
        initViews();
    }

    public void initViews(){
        EventBus.getDefault().register(this);
        setSupportActionBar(this.toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //navigationView.setNavigationItemSelectedListener(this);
        searchView.setOnQueryTextListener(new CustomSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //TODO:
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initNavigationMenu(){
        //TODO:

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
