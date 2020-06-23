package com.jenson.demo;

import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDexApplication;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.jenson.common.http.RetrofitClient;
import com.jenson.common.widget.refresh.BallPulseFooter;
import com.jenson.common.widget.refresh.StoreHouseHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

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

    static {
       SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
           @NonNull
           @Override
           public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
               StoreHouseHeader storeHouseHeader = new StoreHouseHeader(context);
               storeHouseHeader.initWithString("Jetpack-MVVM");
               return storeHouseHeader;
           }
       });

       SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
           @NonNull
           @Override
           public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
               BallPulseFooter ballPulseFooter = new BallPulseFooter(context);
               ballPulseFooter.setAnimatingColor(Color.WHITE);
               ballPulseFooter.setNormalColor(0xffcccccc);
               ballPulseFooter.setBackgroundColor(0xff333333);
               ballPulseFooter.setSpinnerStyle(SpinnerStyle.Scale);
               return ballPulseFooter;
           }
       });
    }
}
