package com.jenson.common.http;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * author: CDJenson
 * date: 2020/5/22 11:27
 * version: 1.0
 * description: One-sentence description
 */
public abstract class ApiObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onError(@NonNull Throwable e) {
        onError(new ApiException(e));
    }

    public abstract void onError(ApiException e);

    @Override
    public void onComplete() {

    }

}
