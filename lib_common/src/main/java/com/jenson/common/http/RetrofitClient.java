package com.jenson.common.http;

import com.jenson.common.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: CDJenson
 * date: 2020/5/22 15:44
 * version: 1.0
 * description: One-sentence description
 */
public class RetrofitClient {

    private static RetrofitClient mInstance;
    private RetrofitWrap mRetrofitWrap;

    private RetrofitClient() {

    }

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitClient();
                }
            }
        }
        return mInstance;
    }

    public void setGlobalRetrofit(RetrofitWrap retrofitWrap) {
        this.mRetrofitWrap = retrofitWrap;
    }

    public Retrofit getRetrofit() {
        return mRetrofitWrap.get();
    }

    public <T> T create(final Class<T> service){
        return mRetrofitWrap.get().create(service);
    }

    //添加请求头信息:比如token
    public void addHeader(String key, String token) {
        mRetrofitWrap.addHeader(key, token);
    }

    public static class DefaultRetrofitWrap implements RetrofitWrap {
        private static final int DEFAULT_TIMEOUT = 10;

        private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
        private Retrofit retrofit;
        private String baseUrl;
        private OkHttpClient.Builder okHttpBuilder;
        private InjectHeaderInterceptor injectHeaderInterceptor;

        public DefaultRetrofitWrap(String baseUrl) {
            this.baseUrl = baseUrl;
            this.okHttpBuilder = newOkHttpbuilder();
        }

        public DefaultRetrofitWrap(String baseUrl, OkHttpClient.Builder okHttpBuilder) {
            this.baseUrl = baseUrl;
            this.okHttpBuilder = okHttpBuilder;
        }

        public DefaultRetrofitWrap addInterceptor(Interceptor interceptor) {
            if (okHttpBuilder != null) {
                okHttpBuilder.addInterceptor(interceptor);
            }
            return this;
        }

        private OkHttpClient.Builder newOkHttpbuilder() {
            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
            okHttpBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                    readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).
                    writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            okHttpBuilder.addInterceptor(httpLoggingInterceptor);

            injectHeaderInterceptor = new InjectHeaderInterceptor();
            okHttpBuilder.addInterceptor(injectHeaderInterceptor);

            okHttpBuilder.cookieJar(new CookieJar() {
                @Override
                public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> list) {
                    cookieStore.put(httpUrl.host(), list);
                }

                @NotNull
                @Override
                public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
                    List<Cookie> cookies = cookieStore.get(httpUrl.host());
                    return cookies != null ? cookies : new ArrayList<>();
                }
            });

            return okHttpBuilder;
        }

        @Override
        public Retrofit get() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .client(okHttpBuilder.build())
                        .baseUrl(baseUrl)
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

        @Override
        public void addHeader(String key, String value) {
            injectHeaderInterceptor.addHeader(key, value);
        }
    }

    public interface RetrofitWrap {

        Retrofit get();

        void addHeader(String key, String value);
    }

}
