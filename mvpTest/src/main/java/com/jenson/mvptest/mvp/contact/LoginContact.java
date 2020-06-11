package com.jenson.mvptest.mvp.contact;

/**
 * author: CDJenson
 * date: 2020/4/28 14:44
 * version: 1.0
 * description: One-sentence description
 */
public interface LoginContact {

    interface IPresent {
        void login();
    }

    interface IModel {
        boolean login(String username, String password);
    }

    interface IView {

        void showLoading();

        void hideLoading();

        String getUserName();

        String getPassword();

        void intentToMain();

        void toast(String msg);
    }
}
