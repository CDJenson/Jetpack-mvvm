package com.jenson.common.mvvm.viewmodel;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.jenson.common.event.PageControlEvent;
import com.jenson.common.event.StateViewEvent;
import com.jenson.common.mvvm.model.BaseModel;
import com.jenson.common.widget.StateView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

/**
 * author: CDJenson
 * date: 2020/5/6 16:42
 * version: 1.0
 * description: One-sentence description
 */
public abstract class BaseViewModel<T extends BaseModel> extends AndroidViewModel implements IBaseViewModel<T>, Consumer<Disposable> {

    protected T mModel;
    private StateViewEvent mStateViewEvent;
    private PageControlEvent mPageControlEvent;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mModel = onBindModel();
    }

    public StateViewEvent getStateViewEvent() {
        if (mStateViewEvent == null) {
            mStateViewEvent = new StateViewEvent();
        }
        return mStateViewEvent;
    }

    public PageControlEvent getPageControlEvent() {
        if (mPageControlEvent == null) {
            mPageControlEvent = new PageControlEvent();
        }
        return mPageControlEvent;
    }


    public void postShowContentViewEvent() {
        if (mStateViewEvent != null) {
            mStateViewEvent.viewState.setValue(StateView.VIEW_STATE_CONTENT);
        }
    }

    public void postShowLoadingViewEvent() {
        if (mStateViewEvent != null) {
            mStateViewEvent.viewState.setValue(StateView.VIEW_STATE_LOADING);
        }
    }

    public void postShowEmptyViewEvent() {
        if (mStateViewEvent != null) {
            mStateViewEvent.viewState.setValue(StateView.VIEW_STATE_EMPTY);
        }
    }

    public void postShowErrorViewEvent() {
        if (mStateViewEvent != null) {
            mStateViewEvent.viewState.setValue(StateView.VIEW_STATE_ERROR);
        }
    }

    public void postStartActivityEvent(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(ParameterField.CLASS, clz);
        if (bundle != null) {
            params.put(ParameterField.BUNDLE, bundle);
        }
        mPageControlEvent.startActivity.postValue(params);
    }

    public void postFinishActivityEvent() {
        mPageControlEvent.finishActivity.call();
    }

    public void postOnBackPressedEvent() {
        mPageControlEvent.onBackPressed.call();
    }

    public void postShowProgressBarDialog(String message) {
        mPageControlEvent.showProgressBarDialog.postValue(message);
    }

    public void postHideProgressBarDialog() {
        mPageControlEvent.hideProgressBarDialog.call();
    }

    //viewmodel中Rxjava操作只需调用doOnSubscribe(this)便会自动触发accept方法。
    @Override
    public void accept(Disposable disposable) throws Throwable {
        if (mModel != null) mModel.addSubscribe(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mModel != null) mModel.onCleared();
    }

    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String BUNDLE = "BUNDLE";
    }

}
