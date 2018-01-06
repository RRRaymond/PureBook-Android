package com.purebook.purebook_android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.purebook.purebook_android.R;
import com.purebook.purebook_android.presenter.LoginPresenter;
import com.purebook.purebook_android.view.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chrischen on 2017/12/26.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView{
    @BindView(R.id.activity_register_logo) ImageView logo;
    @BindView(R.id.activity_register_user_name_text) EditText userNameEditText;
    @BindView(R.id.activity_register_user_password_text) EditText userPasswordEditText;
    @BindView(R.id.activity_register_confirm_user_password_text) EditText confirmUserPasswordEditText;
    @BindView(R.id.activity_register_login_button) Button loginButton;
    @BindView(R.id.activity_register_register_button) Button registerButton;

    private LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initViews();

    }


    public void initViews(){

    }
}
