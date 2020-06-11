package com.jenson.common.event;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/**
 * author: CDJenson
 * date: 2020/5/11 14:12
 * version: 1.0
 * description: 增加普通事件处理 (LiveData 默认使用粘性事件)
 *
 */
public class LiveBusEvent<T> extends SingleLiveEvent<T> {

    private static final int START_VERSION = -1;

    private int mVersion = START_VERSION;
    private ObserverWrapper mObserverWrapper;
    private T mStickyData;

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        observe(owner,observer,false);
    }

    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {
        observeForever(observer,false);
    }

    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer,boolean sticky) {
        mObserverWrapper = new ObserverWrapper(observer,this,sticky);
        super.observe(owner, mObserverWrapper);
    }

    public void observeForever(@NonNull Observer<? super T> observer,boolean sticky) {
        mObserverWrapper = new ObserverWrapper(observer,this,sticky);
        super.observeForever(mObserverWrapper);
    }

    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        mVersion++;
        super.setValue(value);
    }

    public void postValueSticky(T value){
        mStickyData = value;
        postValue(value);
    }

    public void setValueSticky(T value){
        mStickyData = value;
        setValue(value);
    }

    public void clearStickyData(){
        mStickyData =  null;
    }

    @Override
    public void removeObserver(@NonNull Observer<? super T> observer) {
        super.removeObserver(mObserverWrapper);
    }

    private class ObserverWrapper implements Observer<T> {

        private int mLastVersion = mVersion;
        private Observer<? super T> observer;
        private LiveBusEvent<T> liveBusEvent;
        private boolean sticky;

        ObserverWrapper(Observer<? super T> observer,LiveBusEvent<T> liveBusEvent,boolean sticky) {
            this.observer = observer;
            this.liveBusEvent = liveBusEvent;
            this.sticky = sticky;
        }

        @Override
        public void onChanged(T t) {
            if (mLastVersion >= mVersion) {
                if (sticky && mStickyData != null){
                    observer.onChanged(liveBusEvent.mStickyData);
                }
                return;
            }
            mLastVersion = mVersion;
            observer.onChanged(t);
        }

    }
}
