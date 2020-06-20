package com.jenson.demo.model;

import com.blankj.utilcode.util.RegexUtils;
import com.jenson.api.netease_cloud_music.api.UserApi;
import com.jenson.api.netease_cloud_music.response.LoginResponse;
import com.jenson.common.http.RetrofitClient;
import com.jenson.common.mvvm.model.BaseModel;

import io.reactivex.rxjava3.core.Observable;


/**
 * author: CDJenson
 * date: 2020/5/9 14:16
 * version: 1.0
 * description: One-sentence description
 */
public class LoginModel extends BaseModel {

    private final UserApi userApi;

    public LoginModel() {
        userApi = RetrofitClient.getInstance().getRetrofit().create(UserApi.class);
    }

    public Observable<LoginResponse> login(String username, String password){
        return RegexUtils.isEmail(username) ? userApi.login(username,password) : userApi.loginByPhone(username,password);
    }
}
