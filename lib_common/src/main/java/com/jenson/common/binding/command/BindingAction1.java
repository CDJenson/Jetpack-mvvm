package com.jenson.common.binding.command;

import androidx.annotation.NonNull;

/**
 * author: CDJenson
 * date: 2020/5/8 14:35
 * version: 1.0
 * description: One-sentence description
 */
public interface BindingAction1<T> {
    void call(@NonNull T t);
}
