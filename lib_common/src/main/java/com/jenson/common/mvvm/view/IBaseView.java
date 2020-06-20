package com.jenson.common.mvvm.view;

import com.jenson.common.mvvm.DataBindingConfig;

/**
 * author: CDJenson
 * date: 2020/5/6 15:48
 * version: 1.0
 * description: One-sentence description
 */
public interface IBaseView {

    int onBindContentView();

    DataBindingConfig initDataBindingConfig();

    void initView();

    void initData();
}
