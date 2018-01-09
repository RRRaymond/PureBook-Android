package com.purebook.purebook_android.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.purebook.purebook_android.R;
import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.presenter.LoginPresenter;
import com.purebook.purebook_android.presenter.RegisterPresenter;

import butterknife.*;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

/**
 * 注册activity
 * @author chrischen
 */

public class RegisterActivity extends AppCompatActivity implements BaseView<BaseBean> {

    RegisterPresenter mPresenter;

    @BindView(R.id.activity_register_logo) ImageView logo;
    @BindView(R.id.activity_register_user_name_text) EditText userNameEditText;
    @BindView(R.id.activity_register_user_password_text) EditText userPasswordEditText;
    @BindView(R.id.activity_register_confirm_user_password_text) EditText userConfirmPasswordEditText;
    @BindView(R.id.activity_register_login_button) Button loginButton;
    @BindView(R.id.activity_register_register_button) Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initViews();
        this.mPresenter = new RegisterPresenter(this,this);
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
                toLogin();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String userName = userNameEditText.getText().toString();
                String password =  userPasswordEditText.getText().toString();
                String confirmPassword = userConfirmPasswordEditText.getText().toString();
                mPresenter.register(userName,password,confirmPassword);

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

    /**
     * 注册成功，跳转首页
     * @param data
     */
    @Override
    public void onSuccess(BaseBean data){
        Toast.makeText(this, data.message, Toast.LENGTH_SHORT).show();
        //TODO
        toMain();
    }

    /**
     * 注册失败
     * @param msg
     */
    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void toLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void toMain(){
        //TODO
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}
