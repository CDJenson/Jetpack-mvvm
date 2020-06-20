package com.jenson.api.netease_cloud_music.api;

import com.jenson.api.netease_cloud_music.response.RecommendSongsResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

/**
 * author: CDJenson
 * date: 2020/5/25 16:30
 * version: 1.0
 * description: One-sentence description
 */
public interface RecommendApi {

    @GET("/recommend/songs")
    Observable<RecommendSongsResponse> songs();
}
