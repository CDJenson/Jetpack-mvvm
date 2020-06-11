package com.jenson.common.event;

/**
 * author: CDJenson
 * date: 2020/5/7 9:41
 * version: 1.0
 * description: One-sentence description
 */
public class StateViewEvent {
    public final SingleLiveEvent<Integer> viewState = new SingleLiveEvent<>();
}
