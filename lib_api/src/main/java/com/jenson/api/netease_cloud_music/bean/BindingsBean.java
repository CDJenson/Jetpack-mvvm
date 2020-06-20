package com.jenson.api.netease_cloud_music.bean;

/**
 * author: CDJenson
 * date: 2020/5/25 11:12
 * version: 1.0
 * description: One-sentence description
 */
public class BindingsBean {
    /**
     * expired : false
     * userId : 16394569
     * expiresIn : 2147483647
     * bindingTime : 1590372351378
     * refreshTime : 1590372351
     * tokenJsonStr : {"countrycode":"","cellphone":"18173322830","hasPassword":true}
     * url :
     * id : 10637970308
     * type : 1
     */

    private boolean expired;
    private int userId;
    private int expiresIn;
    private long bindingTime;
    private int refreshTime;
    private String tokenJsonStr;
    private String url;
    private long id;
    private int type;

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public long getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(long bindingTime) {
        this.bindingTime = bindingTime;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }

    public String getTokenJsonStr() {
        return tokenJsonStr;
    }

    public void setTokenJsonStr(String tokenJsonStr) {
        this.tokenJsonStr = tokenJsonStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
