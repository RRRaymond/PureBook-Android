package com.purebook.purebook_android.bean;

/**
 * Created by chrischen on 2017/12/26.
 */

public class User {
    private String userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userPortrait;


    public User(String name,String password){
        this.userName = name;
        this.userPassword = password;
    }

    public void setUserId(String id){this.userId=id;}
    public String getUserName(){return this.userName;}
    public String getUserPassword(){return this.userPassword;}
    public void setUserName(String name){this.userName = name;}
    public void setUserPassword(String password){this.userPassword = password;}

}
