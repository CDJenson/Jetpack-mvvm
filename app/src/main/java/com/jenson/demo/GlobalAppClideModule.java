package com.jenson.demo;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * author: CDJenson
 * date: 2020/5/28 9:42
 * version: 1.0
 * description: 1)唯一性  2)发现所有的LibraryGlideModule 3)全局配置
 */
@GlideModule
public class GlobalAppClideModule extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);
        builder.setLogLevel(Log.DEBUG);
    }
}
