package com.example.bookmanager.JavaBean;

import cn.bmob.v3.BmobObject;

public class User extends BmobObject {
    //账号
    private String Account;
    //密码
    private String Password;

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
