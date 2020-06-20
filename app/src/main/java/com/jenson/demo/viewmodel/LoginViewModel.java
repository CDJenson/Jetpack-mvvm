package com.jenson.demo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleEventObserver;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jenson.api.netease_cloud_music.response.LoginResponse;
import com.jenson.common.http.ApiException;
import com.jenson.common.http.ApiObserver;
import com.jenson.common.http.RxAdapter;
import com.jenson.common.mvvm.viewmodel.BaseViewModel;
import com.jenson.demo.model.LoginModel;
import com.jenson.demo.ui.MainActivity;

/**
 * author: CDJenson
 * date: 2020/4/21 17:32
 * version: 1.0
 * description: One-sentence description
 */
public class LoginViewModel extends BaseViewModel<LoginModel> {

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        username.set(SPUtils.getInstance().getString("username"));
        password.set(SPUtils.getInstance().getString("password"));
    }

    public void login() {
        postShowProgressBarDialog("登录中...");
        mModel.login(username.get(), password.get())
                .compose(RxAdapter.schedulersTransformer(this))
                .doFinally(this::postHideProgressBarDialog)
                .subscribe(new ApiObserver<LoginResponse>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        postStartActivityEvent(MainActivity.class, null);
                        SPUtils.getInstance().put("username", username.get());
                        SPUtils.getInstance().put("password", password.get());
                    }
                });
    }

    @Override
    public LoginModel onBindModel() {
        return new LoginModel();
    }

    @Override
    public LifecycleEventObserver onBindLifecycleEventObserver() {
        return (source, event) -> {
        };
    }
}
