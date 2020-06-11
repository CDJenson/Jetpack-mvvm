package com.jenson.common.event;

import java.util.Map;

/**
 * author: CDJenson
 * date: 2020/5/7 9:48
 * version: 1.0
 * description: One-sentence description
 */
public class PageControlEvent {

    public final SingleLiveEvent<Map<String, Object>> startActivity = new SingleLiveEvent<>();

    public final SingleLiveEvent<Void> finishActivity = new SingleLiveEvent<>();

    public final SingleLiveEvent<Void> onBackPressed = new SingleLiveEvent<>();

    public final SingleLiveEvent<String> showProgressBarDialog = new SingleLiveEvent<>();

    public final SingleLiveEvent<Void> hideProgressBarDialog = new SingleLiveEvent<>();
}
