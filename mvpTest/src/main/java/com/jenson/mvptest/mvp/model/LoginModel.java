package com.jenson.mvptest.mvp.model;

import com.jenson.mvptest.mvp.contact.LoginContact;

/**
 * author: CDJenson
 * date: 2020/4/28 15:13
 * version: 1.0
 * description: One-sentence description
 */
public class LoginModel implements LoginContact.IModel {

    @Override
    public boolean login(String username, String password) {
        if(username.equals("jack") && password.equals("123456")){
            return true;
        }
        return false;
    }
}
