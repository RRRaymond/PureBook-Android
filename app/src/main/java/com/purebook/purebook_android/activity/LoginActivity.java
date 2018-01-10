package com.purebook.purebook_android.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.purebook.purebook_android.R;
import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.presenter.LoginPresenter;

import butterknife.*;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

/**
 * 登录activity
 */

public class LoginActivity extends AppCompatActivity implements BaseView<BaseBean> {

    LoginPresenter mPresenter;

    @BindView(R.id.activity_login_logo) ImageView logo;
    @BindView(R.id.activity_login_user_name_text) EditText userNameEditText;
    @BindView(R.id.activity_login_user_password_text) EditText userPasswordEditText;
    @BindView(R.id.activity_login_login_button) Button loginButton;
    @BindView(R.id.activity_login_register_button) Button registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        this.mPresenter = new LoginPresenter(this,this);
        initViews();
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    private void initViews(){
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String userName = userNameEditText.getText().toString();
                String password =  userPasswordEditText.getText().toString();
                mPresenter.login(userName,password);

            }
        });
        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                toRegister();
            }
        });
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
        Toast.makeText(this, data.message, Toast.LENGTH_SHORT).show();
        toHome();//跳转首页
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 跳转到首页
     */
    public void toHome(){
        Intent intent = new Intent(this,MainActivity.class);
        //TODO:从json文件创建user对象并传值给main activity
        Bundle bundle = new Bundle();
        //bundle.putSerializable();

        startActivity(intent);
        this.finish();
    }

    /**
     * 跳转到注册
     */
    public void toRegister(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        this.finish();
    }


}
