package com.jenson.common.mvvm.viewmodel;


import androidx.lifecycle.LifecycleEventObserver;

/**
 * author: CDJenson
 * date: 2020/5/6 16:46
 * version: 1.0
 * description: One-sentence description
 */
public interface IBaseViewModel<T> {

    T onBindModel();

    LifecycleEventObserver onBindLifecycleEventObserver();
}
