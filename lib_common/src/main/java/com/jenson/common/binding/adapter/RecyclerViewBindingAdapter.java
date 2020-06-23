package com.jenson.common.binding.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.jenson.common.binding.command.BindingCommand;
import com.jenson.common.widget.RecyclerViewItemDecoration;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * author: CDJenson
 * date: 2020/6/19 15:53
 * version: 1.0
 * description: One-sentence description
 */
public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = {
            "itemDecorationOrientation",
            "itemDecorationSize",
            "itemDecorationColor",
            "itemDecorationFirstLineVisible"},
            requireAll = false)
    public static void itemDocration(RecyclerView recyclerView,
                                     int itemDecorationOrientation,
                                     int itemDecorationSize,
                                     int itemDecorationColor,
                                     boolean itemDecorationFirstLineVisible) {

        RecyclerViewItemDecoration.Builer builer = new RecyclerViewItemDecoration.Builer();
        if (itemDecorationOrientation >= 0 && itemDecorationSize <= 3) {
            builer.setOrientation(itemDecorationOrientation);
        }
        if (itemDecorationSize > 0) {
            builer.setSize(SizeUtils.dp2px(itemDecorationSize));
        }
        if (itemDecorationColor > 0) {
            builer.setColor(itemDecorationColor);
        }
        builer.setFirstLineVisible(itemDecorationFirstLineVisible);
        recyclerView.addItemDecoration(builer.create());
    }

    @BindingAdapter(value = {"onRefreshCommand","onLoadMoreCommand"},requireAll = false)
    public static void onRefreshCommand(SmartRefreshLayout smartRefreshLayout, final BindingCommand onRefreshCommand, final BindingCommand onLoadMoreCommond) {
        if(onRefreshCommand != null){
            smartRefreshLayout.setOnRefreshListener(refreshLayout -> onRefreshCommand.execute());
        }
        if(onLoadMoreCommond != null){
            smartRefreshLayout.setOnLoadMoreListener(refreshLayout -> onLoadMoreCommond.execute());
        }

    }
}
