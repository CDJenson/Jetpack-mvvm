package com.jenson.common.binding.command;


/**
 * author: CDJenson
 * date: 2020/5/7 16:45
 * version: 1.0
 * description: One-sentence description
 */
public class BindingCommand<T> {
    private BindingAction0 execute0;
    private BindingAction1<T> execute1;
    private BindingFunction0<Boolean> canExecute;

    public BindingCommand(BindingAction0 execute0) {
        this.execute0 = execute0;
    }

    public BindingCommand(BindingAction1<T> execute1) {
        this.execute1 = execute1;
    }

    public BindingCommand(BindingAction0 execute0, BindingFunction0<Boolean> canExecute) {
        this.execute0 = execute0;
        this.canExecute = canExecute;
    }

    public BindingCommand(BindingAction1<T> execute1, BindingFunction0<Boolean> canExecute) {
        this.execute1 = execute1;
        this.canExecute = canExecute;
    }


    public void execute() {
        if (execute0 != null && canExecute()) {
            execute0.call();
        }
    }

    public void execute(T t) {
        if (execute1 != null && canExecute()) {
            execute1.call(t);
        }
    }

    private boolean canExecute() {
        if (canExecute == null) {
            return true;
        }
        return canExecute.call();
    }
}
