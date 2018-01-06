package com.purebook.purebook_android.presenter;

import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.model.LoginModel;
import com.purebook.purebook_android.view.LoginView;

/**
 * Created by chrischen on 2018/1/2.
 */

public class LoginPresenter extends BasePresenter<LoginView>{
    private LoginView loginView;
    private ILoginModel loginModel;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        this.loginModel =  new LoginModel(this);
    }

    @Override
    public void login(String userName,String userPassword){
        this.loginModel.login(userName,userPassword);
    }

    @Override
    public void onDestroy(){
        this.loginView = null;
    }

    @Override
    public void onLoginSuccess(){
        if(this.loginView!=null){
            this.loginView.navigateToHome();
        }
    }

    @Override
    public void onLoginFailed(){

    }


}
