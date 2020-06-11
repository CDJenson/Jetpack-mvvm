package com.jenson.common.binding.command;

import androidx.annotation.NonNull;

/**
 * author: CDJenson
 * date: 2020/5/8 14:40
 * version: 1.0
 * description: One-sentence description
 */
public interface BindingFunction1<T, R> {
    R call(@NonNull T t) throws Exception;
}
