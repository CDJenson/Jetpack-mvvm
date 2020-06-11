package com.jenson.common.mvvm.model;


import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * author: CDJenson
 * date: 2020/5/6 15:46
 * version: 1.0
 * description: One-sentence description
 */
public class BaseModel implements IBaseModel {

    //同步页面生命周期，自动释放RxJava请求，避免内存泄漏
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    //所有RxJava请求，特别是异步请求都应该添加到 mCompositeDisposable
    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        if(mCompositeDisposable != null) mCompositeDisposable.clear();
    }
}
