package com.jenson.common.http;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author: CDJenson
 * date: 2020/5/25 16:22
 * version: 1.0
 * description: One-sentence description
 */
public class InjectHeaderInterceptor implements Interceptor {

    private HashMap<String,String> map;

    InjectHeaderInterceptor() {
       map = new HashMap<>();
    }

    void addHeader(String key, String value){
        if (map != null){
            map.put(key,value);
        }
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        if(map != null){
            Request.Builder builder = request.newBuilder();
            for (Map.Entry<String,String> entry : map.entrySet()){
                if(entry.getKey() != null && entry.getValue() != null){
                    builder.header(entry.getKey(),entry.getValue());
                }
            }
            request = builder.build();
        }
        return chain.proceed(request);
    }
}
