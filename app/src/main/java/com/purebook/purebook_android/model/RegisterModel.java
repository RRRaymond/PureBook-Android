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

   public void register(String userName,String password){
       callBack.requestBefore();

       if(userName.isEmpty()||password.isEmpty()){
           callBack.requestFail("用户名或密码不能为空");
       }else{
           BaseBean baseBean = new BaseBean();
           baseBean.status = "1";
           baseBean.message = "登录成功！";
           callBack.requestSuccess(baseBean);
       }

   }
}
