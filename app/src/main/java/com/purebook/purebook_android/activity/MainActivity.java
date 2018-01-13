package com.purebook.purebook_android.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.afollestad.materialdialogs.MaterialDialog;
import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.bean.Book;
import com.purebook.purebook_android.bean.BookColumn;
import com.purebook.purebook_android.fragment.ColumnFragment;
import com.purebook.purebook_android.presenter.MainPresenter;
import com.purebook.purebook_android.utils.SkinUtils;
import com.purebook.purebook_android.view.CustomSearchView;
import com.purebook.purebook_android.view.MainView;

import com.purebook.purebook_android.R;
import com.zhy.changeskin.SkinManager;

import org.simple.eventbus.EventBus;
import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MainActivity
 * @author chrischen
 */
public class MainActivity extends AppCompatActivity implements BaseView<BaseBean>,NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.contentView)DrawerLayout drawer;//整个layout
    @BindView(R.id.nav_view)NavigationView navigationView;//侧滑菜单
    @BindView(R.id.search_view)CustomSearchView searchView;//搜索
    @Nullable
    @BindView(R.id.fab) com.melnykov.fab.FloatingActionButton fab;//悬浮按钮
    @BindView(R.id.activity_main_coordlayout)CoordinatorLayout coordinatorLayout;
    @Nullable
    @BindView(R.id.nav_head_layout)View navLayout;

    private static final String FRAGGMENT_TAG = "FRAGGMENT_TAG";
    private ActionBarDrawerToggle toggle;
    private int mSelectPostion = -1;
    private Snackbar backPressSnackbar;
    private View mLogout;
    private TextView userNameText;
    private ImageView userAvatarImage;
    private List<BookColumn> bookColumns;
    private Fragment[] fragments;
    private Fragment mSelectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//butterknife绑定控件
        EventBus.getDefault().register(this);
        initViews();
    }

    /**
     * 初始化view
     */
    public void initViews(){
        setSupportActionBar(this.toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

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

        initNavigationMenu();
    }

    /**
     * 根据选择的tab替换fragment
     * @param position
     */
    private void replaceFragment(int position){
        if(position!=mSelectPostion){
            searchView.closeSearch();
            mSelectPostion = position;
            BookColumn item = bookColumns.get(position);
            toolbar.setTitle(item.getName());
            //TODO:
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            hideAllFragment(trans);
            if(fragments[position]!=null){
                trans.show(fragments[position]);
            }else{
                trans.add(R.id.activity_main_fragmelayout,getNewFragment(position,item),FRAGGMENT_TAG+position);
            }
            trans.commit();
            mSelectedFragment = fragments[position];
        }
    }

    private void hideAllFragment(FragmentTransaction trans){
        for(Fragment f:fragments){
            if(f!=null){
                trans.hide(f);
            }
        }
    }

    private Fragment getNewFragment(int position, BookColumn item) {
        if (fragments[position] == null) {
            //TODO
            //fragments[position] = ColumnFragment.newInstance(item);
        }
        return fragments[position];
    }

    /**
     * 登录传Intent获取User信息
     */
    private void getUser(){
        //TODO:

    }

    /**
     * 初始化侧滑菜单
     */
    private void initNavigationMenu(){
        //TODO:
        Menu menu =navigationView.getMenu();

        mLogout = navigationView.findViewById(R.id.nav_logout);
        userNameText = navigationView.findViewById(R.id.nav_nickname);
        userAvatarImage = navigationView.findViewById(R.id.nav_icon);

        //mLogout.setVisibility(View.VISIBLE);
        //mLogout.setOnClickListener(v -> new MaterialDialog.Builder(this).title("提示").content("确定要退出登陆吗？").positiveText("确认").negativeText("取消")
        //.backgroundColor(SkinUtils.getWindowColor()).contentColor(SkinUtils.getTextHeightColor()).titleColor(SkinUtils.getTextHeightColor()) .onPositive((dialog, which) -> logout()).show());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int groupId = item.getGroupId();
        if (groupId == 0) {
            item.setChecked(true);
            drawer.postDelayed(() -> replaceFragment(item.getOrder()), 0);
        } else if (groupId == R.id.navigation_group_setting) {
            int id = item.getItemId();
            switch (id) {
                //反馈建议
                case R.id.navigation_feedback:
                    //TODO:

                    //Intent intent = new Intent(this, FeedActivity.class);
                    //startActivity(intent);
                    break;
                //切换主题
                case R.id.navigation_chose_theme:

                    SkinUtils.toggleTheme();
                    break;
                case R.id.navigation_setting:
                    //TODO:
                    //SettingsActivity_.intent(this).start();
                    break;
            }
        }
        drawer.closeDrawers();
        return true;
    }


    /**
     *
     */
    private void logout() {
        //TODO:
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            if (backPressSnackbar == null) {
                backPressSnackbar = Snackbar.make(coordinatorLayout, R.string.msg_backpressed, Snackbar.LENGTH_LONG);
            }
            if (backPressSnackbar.isShown()) {
                super.onBackPressed();
            } else {
                backPressSnackbar.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
