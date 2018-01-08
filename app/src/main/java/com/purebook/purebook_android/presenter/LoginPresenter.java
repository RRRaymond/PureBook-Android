package com.purebook.purebook_android.presenter;

import android.content.Context;

import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.model.LoginModel;

/**
 * 登录presenter
 * @author chrischen
 */

public class LoginPresenter extends BasePresenter<BaseBean> {
    private LoginModel model;

    public LoginPresenter(BaseView mView, Context context) {
        super(mView, context);
        model = new LoginModel(this,context);
    }

    public void login(String userName, String password) {
        model.login(userName,password);
    }


}
