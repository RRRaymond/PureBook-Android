package com.purebook.purebook_android.model;

import android.content.Context;

import com.purebook.purebook_android.activity.LoginActivity;
import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BaseModel;
import com.purebook.purebook_android.base.BaseRequestCallBack;
import com.purebook.purebook_android.presenter.LoginPresenter;

/**
 * Created by chrischen on 2018/1/2.
 */

public class LoginModel extends BaseModel {
   private BaseRequestCallBack callBack;
   private LoginActivity activity;

   public LoginModel(BaseRequestCallBack callBack, Context context){
       super(callBack);
       this.activity = (LoginActivity)context;
       this.callBack = callBack;
   }

   public void login(String userName,String password){
       callBack.requestBefore();

       if(userName.isEmpty()||password.isEmpty()){
           callBack.requestFail("用户名或密码不能为空");
       }else{
           //TODO:处理登录逻辑，获取json进行匹配判定，如果匹配则转化为gson对象
           BaseBean baseBean = new BaseBean();
           baseBean.status = "1";
           baseBean.message = "登录成功！";
           callBack.requestSuccess(baseBean);
       }

   }
}
