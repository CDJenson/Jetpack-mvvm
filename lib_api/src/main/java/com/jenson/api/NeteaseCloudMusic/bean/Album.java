package com.jenson.api.NeteaseCloudMusic.bean;

import java.util.List;

/**
 * author: CDJenson
 * date: 2020/5/26 11:28
 * version: 1.0
 * description: One-sentence description
 */
public class Album {
    /**
     * name : Stranger in Town
     * id : 114014
     * type : 专辑
     * size : 9
     * picId : 849922488313863
     * blurPicUrl : http://p2.music.126.net/xSrTjmar-9Mt1vQXBiZ15A==/849922488313863.jpg
     * companyId : 0
     * pic : 849922488313863
     * picUrl : http://p2.music.126.net/xSrTjmar-9Mt1vQXBiZ15A==/849922488313863.jpg
     * publishTime : 262800000007
     * description :
     * tags :
     * company : Capitol
     * briefDesc :
     * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}
     * songs : []
     * alias : []
     * status : 1
     * copyrightId : 5003
     * commentThreadId : R_AL_3_114014
     * artists : [{"name":"Bob Seger","id":29426,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}]
     * subType : 录音室版
     * transName : null
     * mark : 0
     */

    private String name;
    private int id;
    private String type;
    private int size;
    private long picId;
    private String blurPicUrl;
    private int companyId;
    private long pic;
    private String picUrl;
    private long publishTime;
    private String description;
    private String tags;
    private String company;
    private String briefDesc;
    private Artist artist;
    private int status;
    private int copyrightId;
    private String commentThreadId;
    private String subType;
    private Object transName;
    private int mark;
    private List<?> songs;
    private List<?> alias;
    private List<Artist> artists;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }

    public String getBlurPicUrl() {
        return blurPicUrl;
    }

    public void setBlurPicUrl(String blurPicUrl) {
        this.blurPicUrl = blurPicUrl;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public long getPic() {
        return pic;
    }

    public void setPic(long pic) {
        this.pic = pic;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Object getTransName() {
        return transName;
    }

    public void setTransName(Object transName) {
        this.transName = transName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public List<?> getSongs() {
        return songs;
    }

    public void setSongs(List<?> songs) {
        this.songs = songs;
    }

    public List<?> getAlias() {
        return alias;
    }

    public void setAlias(List<?> alias) {
        this.alias = alias;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}