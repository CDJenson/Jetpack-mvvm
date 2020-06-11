package com.jenson.common.http;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 *  author: CDJenson
 *  date: 2020/5/22 10:28
 *	version: 1.0 
 *  description: One-sentence description
 */
public class RxAdapter {

    /**
     * ViewModel中调用此方法，会自动把当前rx请求注入到BaseModel中的CompositeDisposable，从而实现同步页面生命周期，页面销毁时自动取消当前未执行完毕的rx请求
     * @param consumer
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T,T> schedulersTransformer(Consumer<? super Disposable> consumer) {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(consumer);
    }

    public static <T> ObservableTransformer<T,T> schedulersTransformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T,T> schedulersTransformerIo() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io());
    }
}
