package com.jenson.common.event;

import java.util.concurrent.ConcurrentHashMap;

/**
 * author: CDJenson
 * date: 2020/5/11 9:17
 * version: 1.0
 * description: 利用LiveData实现的事件总线。
 */
public class LiveBus {

    private volatile static LiveBus mInstance;

    private ConcurrentHashMap<Class<?>, LiveBusEvent<?>> mClients = new ConcurrentHashMap<>();

    private LiveBus() {

    }

    public static LiveBus getInstance() {
        if (mInstance == null) {
            synchronized (LiveBus.class) {
                if (mInstance == null) {
                    mInstance = new LiveBus();
                }
            }
        }
        return mInstance;
    }

    @SuppressWarnings("unchecked")
    public <T> LiveBusEvent<T> with(Class<T> clazz) {
        if (!mClients.containsKey(clazz)) mClients.put(clazz, new LiveBusEvent<T>());
        return (LiveBusEvent<T>) mClients.get(clazz);
    }

    public void clear() {
        if (mClients != null) {
            mClients.clear();
            mClients = null;
        }
        mInstance = null;
    }
}
