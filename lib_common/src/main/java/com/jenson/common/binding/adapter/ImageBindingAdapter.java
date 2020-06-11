package com.jenson.common.binding.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * author: CDJenson
 * date: 2020/5/26 14:55
 * version: 1.0
 * description: One-sentence description
 */
public class ImageBindingAdapter {

    @BindingAdapter(value = {"url", "placeholder","error"}, requireAll = false)
    public static void setImageUri(ImageView imageView, String url, int placeholder,int error) {
        if (!TextUtils.isEmpty(url)) {
            //使用Glide框架加载图片
            Glide.with(imageView.getContext())
                    .load(url)
                    .error(error)
                    .placeholder(placeholder)
                    .into(imageView);
        }
    }
}
