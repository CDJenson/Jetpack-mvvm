package com.jenson.demo.viewmodel;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.LifecycleEventObserver;

import com.jenson.api.netease_cloud_music.bean.Song;
import com.jenson.api.netease_cloud_music.response.RecommendSongsResponse;
import com.jenson.common.binding.command.BindingCommand;
import com.jenson.common.event.SingleLiveEvent;
import com.jenson.common.http.ApiException;
import com.jenson.common.http.ApiObserver;
import com.jenson.common.http.RxAdapter;
import com.jenson.common.mvvm.viewmodel.BaseViewModel;
import com.jenson.demo.model.MainModel;

/**
 * author: CDJenson
 * date: 2020/5/11 9:30
 * version: 1.0
 * description: One-sentence description
 */
public class MainViewModel extends BaseViewModel<MainModel> {

    public final ObservableList<Song> items = new ObservableArrayList<>();

    public final SingleLiveEvent<Void> stopRefresh = new SingleLiveEvent<>();
    public final SingleLiveEvent<Void> stopLoadMore = new SingleLiveEvent<>();

    public final BindingCommand<?> onRefresh = new BindingCommand<>(this::fetchData);
    public final BindingCommand<?> onLoadMore = new BindingCommand<>(() -> new Handler().postDelayed(stopLoadMore::call, 1500));

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public MainModel onBindModel() {
        return new MainModel();
    }

    @Override
    public LifecycleEventObserver onBindLifecycleEventObserver() {
        return null;
    }

    public void fetchData() {
        mModel.recommendSongs()
                .compose(RxAdapter.schedulersTransformer(this))
                .doFinally(stopRefresh::call)
                .subscribe(new ApiObserver<RecommendSongsResponse>() {
                    @Override
                    public void onError(ApiException e) {
                        postShowErrorViewEvent();
                    }

                    @Override
                    public void onNext(RecommendSongsResponse recommendSongsResponse) {
                        postShowContentViewEvent();
                        items.addAll(recommendSongsResponse.getRecommend());
                    }
                });

    }
}
