package com.jenson.demo.ui;

import androidx.lifecycle.Observer;

import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.appbar.MaterialToolbar;
import com.jenson.common.event.LiveBus;
import com.jenson.common.mvvm.BaseActivity;
import com.jenson.common.mvvm.DataBindingConfig;
import com.jenson.demo.BR;
import com.jenson.demo.entity.LoginResp;
import com.jenson.demo.R;
import com.jenson.demo.databinding.ActivityMainBinding;
import com.jenson.demo.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    Observer<LoginResp> observer = loginResp -> LogUtils.dTag("main"+loginResp.toString());

    @Override
    protected void initToolbar(MaterialToolbar toolbar) {
        super.initToolbar(toolbar);
        toolbar.setTitle("首页");
    }

    @Override
    public int onBindContentView() {
        return R.layout.activity_main;
    }

    @Override
    public DataBindingConfig initDataBindingConfig() {
        return new DataBindingConfig(BR.viewModel);
    }

    @Override
    public void subscribeUi() {
        LiveBus.getInstance().with(LoginResp.class).observeForever(observer,true);
    }

    @Override
    public void initData() {
        mViewModel.initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LiveBus.getInstance().with(LoginResp.class).removeObserver(observer);
    }
}
