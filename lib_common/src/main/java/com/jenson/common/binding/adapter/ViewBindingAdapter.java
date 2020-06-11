package com.jenson.common.binding.adapter;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.jenson.common.binding.command.BindingCommand;
import com.jenson.common.binding.command.BindingResponseCommand;

import java.util.Calendar;

/**
 * author: CDJenson
 * date: 2020/5/7 16:55
 * version: 1.0
 * description: One-sentence description
 */
public class ViewBindingAdapter {

    /**
     * 点击事件：防抖
     *
     * @param view
     * @param bindingCommand
     * @param disableThrottle 是否关闭防抖（默认开启）
     */
    @BindingAdapter(value = {"onClickCommand", "disableThrottle"}, requireAll = false)
    public static void onClickCommand(View view, final BindingCommand bindingCommand, final boolean disableThrottle) {
            view.setOnClickListener(new onThrottleHelper(disableThrottle, new onThrottleClickListener() {
                @Override
                public void onClick(View view) {
                    if (bindingCommand != null) {
                        try {
                            bindingCommand.execute();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }));
    }

    /**
     * 长按事件
     * setOnLongClickListener 返回值为false会继续执行onClick事件，为true则只会消费onLongClick方法
     * @param view
     * @param bindingResponseCommand
     */
    @BindingAdapter({"onLongClickCommand"})
    public static void onLongClickCommand(View view, final BindingResponseCommand<View,Boolean> bindingResponseCommand) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(bindingResponseCommand != null){
                    try {
                        return bindingResponseCommand.execute(v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });
    }

    /**
     * 焦点变更事件
     * @param view
     * @param onFocusChangeCommand
     */
    @BindingAdapter({"onFocusChangeCommand"})
    public static void onFocusChangeCommand(View view, final BindingCommand<Boolean> onFocusChangeCommand) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (onFocusChangeCommand != null) {
                    try {
                        onFocusChangeCommand.execute(hasFocus);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static class onThrottleHelper implements View.OnClickListener {
        private static final int LIMIT_TIME = 1000;
        private long lastClickTime = 0;
        private boolean disableThrottle;
        private onThrottleClickListener onThrottleClickListener = null;

        private onThrottleHelper(boolean disableThrottle, onThrottleClickListener onThrottleClickListener) {
            this.disableThrottle = disableThrottle;
            this.onThrottleClickListener = onThrottleClickListener;
        }

        @Override
        public void onClick(View v) {
            if (disableThrottle && onThrottleClickListener != null) {
                onThrottleClickListener.onClick(v);
            } else {
                long curTime = Calendar.getInstance().getTimeInMillis();
                if (curTime - lastClickTime > LIMIT_TIME) {
                    lastClickTime = curTime;
                    if (onThrottleClickListener != null) {
                        onThrottleClickListener.onClick(v);
                    }
                }
            }
        }
    }

    private interface onThrottleClickListener {
        void onClick(View view);
    }
}
