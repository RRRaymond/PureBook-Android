package com.purebook.purebook_android.presenter;

import android.content.Context;

import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BasePresenter;
import com.purebook.purebook_android.base.BaseView;
import com.purebook.purebook_android.model.LoginModel;
import com.purebook.purebook_android.model.RegisterModel;

/**
 * 注册presenter
 * @author chrischen
 */

public class RegisterPresenter extends BasePresenter<BaseBean> {
    private RegisterModel model;

    public RegisterPresenter(BaseView mView, Context context) {
        super(mView, context);
        model = new RegisterModel(this,context);
    }

    public void login(String userName, String password) {
        model.register(userName,password);
    }


}
