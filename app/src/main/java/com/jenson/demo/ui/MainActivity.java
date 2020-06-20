package com.jenson.demo.ui;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.appbar.MaterialToolbar;
import com.jenson.api.netease_cloud_music.bean.Song;
import com.jenson.common.mvvm.BaseActivity;
import com.jenson.common.mvvm.DataBindingConfig;
import com.jenson.demo.BR;
import com.jenson.demo.R;
import com.jenson.demo.databinding.ActivityMainBinding;
import com.jenson.demo.viewmodel.MainViewModel;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected void initToolbar(MaterialToolbar toolbar) {
        super.initToolbar(toolbar);
        toolbar.setTitle("首页");
    }

    @Override
    public int onBindContentView() {
        return R.layout.activity_main;
    }

    @Override
    public DataBindingConfig initDataBindingConfig() {
        return new DataBindingConfig(BR.viewModel);
    }

    @Override
    public void initView() {
        ItemBinding<Song> itemBinding = ItemBinding.of(BR.item, R.layout.item_recomend_song);
        RecomendSongAdapter adapter = new RecomendSongAdapter();
        adapter.setItemBinding(itemBinding);
        adapter.setItems(mViewModel.items);
        mBinding.activityRecommendSongRv.setAdapter(adapter);
    }

    @Override
    public void initData() {
        mViewModel.initData();
    }

    public static class RecomendSongAdapter extends BindingRecyclerViewAdapter<Song>{
        @Override
        public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, Song item) {
            super.onBindBinding(binding, variableId, layoutRes, position, item);
            binding.getRoot().setOnClickListener(v -> ToastUtils.showShort(item.getName()));
        }
    }
}
