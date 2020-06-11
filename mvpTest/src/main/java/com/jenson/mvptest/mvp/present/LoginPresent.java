package com.jenson.mvptest.mvp.present;

import android.os.Handler;

import com.jenson.mvptest.mvp.contact.LoginContact;
import com.jenson.mvptest.mvp.model.LoginModel;

/**
 * author: CDJenson
 * date: 2020/4/28 15:12
 * version: 1.0
 * description: One-sentence description
 */
public class LoginPresent implements LoginContact.IPresent {

    private LoginContact.IView loginView;
    private LoginModel loginModel;

    public LoginPresent(LoginContact.IView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel();
    }

    @Override
    public void login() {
        loginView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideLoading();
                boolean result = loginModel.login(loginView.getUserName(),loginView.getPassword());
                if(result){
                    loginView.intentToMain();
                }else{
                    loginView.toast("用户名或密码错误");
                }
            }
        },2000);

    }
}
