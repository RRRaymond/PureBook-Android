package com.purebook.purebook_android.model;

import com.purebook.purebook_android.presenter.LoginPresenter;

/**
 * Created by chrischen on 2018/1/2.
 */

public class LoginModel implements IBaseModel {
    private LoginPresenter loginPresenter;

    public void LoginModel(LoginPresenter loginPresenter){
        this.loginPresenter = loginPresenter;
    }

    public void login(String name, String password){
        if(name == "wangii" &&password =="bageba"){
            this.loginPresenter.onLoginSuccess();
        }
    }
}
