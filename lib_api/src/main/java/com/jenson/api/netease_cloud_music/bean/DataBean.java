package com.jenson.api.netease_cloud_music.bean;

import java.util.List;

/**
 * author: CDJenson
 * date: 2020/5/26 11:26
 * version: 1.0
 * description: One-sentence description
 */
public class DataBean {
    private List<Song> dailySongs;
    private List<?> orderSongs;

    public List<Song> getDailySongs() {
        return dailySongs;
    }

    public void setDailySongs(List<Song> dailySongs) {
        this.dailySongs = dailySongs;
    }

    public List<?> getOrderSongs() {
        return orderSongs;
    }

    public void setOrderSongs(List<?> orderSongs) {
        this.orderSongs = orderSongs;
    }
}
