package com.jenson.api.netease_cloud_music.api;

import com.jenson.api.netease_cloud_music.response.LoginResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: CDJenson
 * date: 2020/5/25 10:58
 * version: 1.0
 * description: One-sentence description
 */
public interface UserApi {

    @GET("/login/")
    Observable<LoginResponse> login(@Query("email") String email,@Query("password") String password);

    @GET("/login/cellphone")
    Observable<LoginResponse> loginByPhone(@Query("phone") String phone,@Query("password") String password);
}
