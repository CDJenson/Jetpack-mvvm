package com.jenson.common.binding.command;

/**
 * author: CDJenson
 * date: 2020/5/8 15:35
 * version: 1.0
 * description: One-sentence description
 */
public class BindingResponseCommand<T, R> {
    private BindingFunction0<R> function0;
    private BindingFunction1<T, R> function1;
    private BindingFunction0<Boolean> canExecute;

    public BindingResponseCommand(BindingFunction0<R> function0) {
        this.function0 = function0;
    }

    public BindingResponseCommand(BindingFunction1<T, R> function0) {
        this.function1 = function0;
    }

    public BindingResponseCommand(BindingFunction0<R> function0, BindingFunction0<Boolean> canExecute) {
        this.function0 = function0;
        this.canExecute = canExecute;
    }

    public BindingResponseCommand(BindingFunction1<T, R> function0, BindingFunction0<Boolean> canExecute) {
        this.function1 = function0;
        this.canExecute = canExecute;
    }


    public R execute() {
        if (function0 != null && canExecute()) {
            return function0.call();
        }
        return null;
    }

    public R execute(T parameter) {
        if (function1 != null && canExecute()) {
            return function1.call(parameter);
        }
        return null;
    }

    private boolean canExecute() {
        if (canExecute == null) {
            return true;
        }
        return canExecute.call();
    }

}
