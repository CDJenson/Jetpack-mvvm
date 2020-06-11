package com.jenson.demo;

import androidx.multidex.MultiDexApplication;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.jenson.common.http.RetrofitClient;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/**
 * author: CDJenson
 * date: 2020/5/15 14:30
 * version: 1.0
 * description: One-sentence description
 */
public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        LogUtils.getConfig().setGlobalTag("GLog");
        RetrofitClient.getInstance().setGlobalRetrofit(new RetrofitClient.DefaultRetrofitWrap("http://172.21.10.221:3000"));
        //rx全局异常处理，防止出现一些未被捕获到的rx异常而导致应用奔溃
        RxJavaPlugins.setErrorHandler(throwable -> LogUtils.d("setErrorHandler", throwable.getMessage()));
    }

}
