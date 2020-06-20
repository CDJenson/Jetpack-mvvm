package com.jenson.api.netease_cloud_music.bean;

/**
 * author: CDJenson
 * date: 2020/5/26 11:56
 * version: 1.0
 * description: One-sentence description
 */
public class Music {
    /**
     * name : null
     * id : 64657914
     * size : 7812886
     * extension : mp3
     * sr : 44100
     * dfsId : 0
     * bitrate : 320000
     * playTime : 195000
     * volumeDelta : -40700
     */

    private Object name;
    private String id;
    private int size;
    private String extension;
    private int sr;
    private int dfsId;
    private int bitrate;
    private int playTime;
    private String volumeDelta;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public int getDfsId() {
        return dfsId;
    }

    public void setDfsId(int dfsId) {
        this.dfsId = dfsId;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getVolumeDelta() {
        return volumeDelta;
    }

    public void setVolumeDelta(String volumeDelta) {
        this.volumeDelta = volumeDelta;
    }
}
