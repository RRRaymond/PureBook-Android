package com.purebook.purebook_android.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.purebook.purebook_android.R;
import com.purebook.purebook_android.base.BaseActivity;
import com.purebook.purebook_android.base.BaseMvpActivity;
import com.purebook.purebook_android.view.LoginView;
import com.purebook.purebook_android.presenter.LoginPresenter;

import butterknife.*;
import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

/**
 * 登录activity
 */

@ActivityView(layout = R.layout.activity_login,presenter = LoginPresenter.class)
public class LoginActivity extends AppCompatActivity implements LoginView{

    @Presenter
    LoginPresenter mPresenter;

    @BindView(R.id.activity_login_logo) ImageView logo;
    @BindView(R.id.activity_login_user_name_text) EditText userNameEditText;
    @BindView(R.id.activity_login_user_password_text) EditText userPasswordEditText;
    @BindView(R.id.activity_login_login_button) Button loginButton;
    @BindView(R.id.activity_login_register_button) Button registerButton;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
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

    private void initViews(){
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String userName = userNameEditText.getText().toString();
                String userPassword =  userPasswordEditText.getText().toString();

                if(userName.isEmpty()||userPassword.isEmpty()){
                    Toast.makeText(getApplicationContext(), "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                mPresenter.login(userName,userPassword);

            }
        });
    }

    public void navigateToHome(){
        startActivity(new Intent(this,MainActivity.class));
        Toast.makeText(this,"成功登录",Toast.LENGTH_SHORT).show();
        this.finish();
    }



}
