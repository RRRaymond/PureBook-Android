package com.purebook.purebook_android.model;

import android.content.Context;

import com.purebook.purebook_android.activity.LoginActivity;
import com.purebook.purebook_android.activity.RegisterActivity;
import com.purebook.purebook_android.base.BaseBean;
import com.purebook.purebook_android.base.BaseModel;
import com.purebook.purebook_android.base.BaseRequestCallBack;

/**
 * Created by chrischen on 2018/1/2.
 */

public class RegisterModel extends BaseModel {
   private BaseRequestCallBack callBack;
   private RegisterActivity activity;

   public RegisterModel(BaseRequestCallBack callBack, Context context){
       super(callBack);
       this.activity = (RegisterActivity)context;
       this.callBack = callBack;
   }

   public void register(String userName,String password,String confirmPassword){
       callBack.requestBefore();

       if(userName.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
           callBack.requestFail("用户名或密码不能为空");
       }else if(password!=confirmPassword){
           callBack.requestFail("两次输入密码不一致");
       }else{
           BaseBean baseBean = new BaseBean();
           baseBean.status = "1";
           baseBean.message = "注册成功！";
           callBack.requestSuccess(baseBean);
       }
   }
}
