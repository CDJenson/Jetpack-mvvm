package com.jenson.demo.model;

import com.jenson.api.netease_cloud_music.api.RecommendApi;
import com.jenson.api.netease_cloud_music.response.RecommendSongsResponse;
import com.jenson.common.http.RetrofitClient;
import com.jenson.common.mvvm.model.BaseModel;
import com.jenson.demo.entity.LoginResp;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Function;

/**
 * author: CDJenson
 * date: 2020/5/13 10:39
 * version: 1.0
 * description: One-sentence description
 */
public class MainModel extends BaseModel {

    private final RecommendApi recommendApi;

    public MainModel() {
        recommendApi = RetrofitClient.getInstance().create(RecommendApi.class);
    }

    public Observable<LoginResp> fetchData() {
        return Observable.just(new LoginResp("Jack", "boy")).delay(2, TimeUnit.SECONDS).flatMap(new Function<LoginResp, ObservableSource<LoginResp>>() {
            @Override
            public ObservableSource<LoginResp> apply(LoginResp loginResp) throws Throwable {
                return new Observable<LoginResp>() {
                    @Override
                    protected void subscribeActual(@NonNull Observer<? super LoginResp> observer) {
                        observer.onError(new Throwable("I make the trouble."));
                        observer.onNext(loginResp);
                    }
                };
            }
        });
    }

    public Observable<RecommendSongsResponse> recommendSongs() {
        return recommendApi.songs();
    }
}
