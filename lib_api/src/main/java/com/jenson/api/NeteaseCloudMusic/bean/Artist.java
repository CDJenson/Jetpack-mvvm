package com.jenson.api.NeteaseCloudMusic.bean;

import java.util.List;

/**
 * author: CDJenson
 * date: 2020/5/26 11:44
 * version: 1.0
 * description: One-sentence description
 */
public class Artist {
    /**
     * name : Bob Seger
     * id : 29426
     * picId : 0
     * img1v1Id : 0
     * briefDesc :
     * picUrl : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
     * img1v1Url : http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
     * albumSize : 0
     * alias : []
     * trans :
     * musicSize : 0
     * topicPerson : 0
     */

    private String name;
    private int id;
    private int picId;
    private int img1v1Id;
    private String briefDesc;
    private String picUrl;
    private String img1v1Url;
    private int albumSize;
    private String trans;
    private int musicSize;
    private int topicPerson;
    private List<?> alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public int getImg1v1Id() {
        return img1v1Id;
    }

    public void setImg1v1Id(int img1v1Id) {
        this.img1v1Id = img1v1Id;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getImg1v1Url() {
        return img1v1Url;
    }

    public void setImg1v1Url(String img1v1Url) {
        this.img1v1Url = img1v1Url;
    }

    public int getAlbumSize() {
        return albumSize;
    }

    public void setAlbumSize(int albumSize) {
        this.albumSize = albumSize;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public int getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(int musicSize) {
        this.musicSize = musicSize;
    }

    public int getTopicPerson() {
        return topicPerson;
    }

    public void setTopicPerson(int topicPerson) {
        this.topicPerson = topicPerson;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }
}
