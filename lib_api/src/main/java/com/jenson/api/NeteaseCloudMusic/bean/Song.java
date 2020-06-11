package com.jenson.api.NeteaseCloudMusic.bean;

import java.util.List;

/**
 * author: CDJenson
 * date: 2020/5/26 11:24
 * version: 1.0
 * description: One-sentence description
 */
public class Song {
    /**
     * name : Old Time Rock & Roll
     * id : 1098827
     * position : 3
     * alias : []
     * status : 0
     * fee : 0
     * copyrightId : 5003
     * disc : 1
     * no : 3
     * artists : [{"name":"Bob Seger","id":29426,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}]
     * album : {"name":"Stranger in Town","id":114014,"type":"专辑","size":9,"picId":849922488313863,"blurPicUrl":"http://p2.music.126.net/xSrTjmar-9Mt1vQXBiZ15A==/849922488313863.jpg","companyId":0,"pic":849922488313863,"picUrl":"http://p2.music.126.net/xSrTjmar-9Mt1vQXBiZ15A==/849922488313863.jpg","publishTime":262800000007,"description":"","tags":"","company":"Capitol","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0},"songs":[],"alias":[],"status":1,"copyrightId":5003,"commentThreadId":"R_AL_3_114014","artists":[{"name":"Bob Seger","id":29426,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0,"topicPerson":0}],"subType":"录音室版","transName":null,"mark":0}
     * starred : false
     * popularity : 100
     * score : 100
     * starredNum : 0
     * duration : 195000
     * playedNum : 0
     * dayPlays : 0
     * hearTime : 0
     * ringtone :
     * crbt : null
     * audition : null
     * copyFrom :
     * commentThreadId : R_SO_4_1098827
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * copyright : 1
     * transName : null
     * sign : null
     * mark : 0
     * noCopyrightRcmd : null
     * mvid : 0
     * rtype : 0
     * rurl : null
     * bMusic : {"name":null,"id":64657915,"size":3125264,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":195000,"volumeDelta":-36700}
     * mp3Url : null
     * hMusic : {"name":null,"id":64657914,"size":7812886,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":195000,"volumeDelta":-40700}
     * mMusic : {"name":null,"id":93419342,"size":4687805,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":195000,"volumeDelta":-38200}
     * lMusic : {"name":null,"id":64657915,"size":3125264,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":195000,"volumeDelta":-36700}
     * reason : 根据你可能喜欢的单曲 Hero
     * privilege : {"id":1098827,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false}
     * alg : itembased
     */

    private String name;
    private int id;
    private int position;
    private int status;
    private int fee;
    private int copyrightId;
    private String disc;
    private int no;
    private Album album;
    private boolean starred;
    private int popularity;
    private int score;
    private int starredNum;
    private int duration;
    private int playedNum;
    private int dayPlays;
    private int hearTime;
    private String ringtone;
    private Object crbt;
    private Object audition;
    private String copyFrom;
    private String commentThreadId;
    private Object rtUrl;
    private int ftype;
    private int copyright;
    private Object transName;
    private Object sign;
    private int mark;
    private Object noCopyrightRcmd;
    private int mvid;
    private int rtype;
    private Object rurl;
    private Music bMusic;
    private Object mp3Url;
    private Music hMusic;
    private Music mMusic;
    private Music lMusic;
    private String reason;
    private Privilege privilege;
    private String alg;
    private List<?> alias;
    private List<Artist> artists;
    private List<?> rtUrls;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStarredNum() {
        return starredNum;
    }

    public void setStarredNum(int starredNum) {
        this.starredNum = starredNum;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedNum() {
        return playedNum;
    }

    public void setPlayedNum(int playedNum) {
        this.playedNum = playedNum;
    }

    public int getDayPlays() {
        return dayPlays;
    }

    public void setDayPlays(int dayPlays) {
        this.dayPlays = dayPlays;
    }

    public int getHearTime() {
        return hearTime;
    }

    public void setHearTime(int hearTime) {
        this.hearTime = hearTime;
    }

    public String getRingtone() {
        return ringtone;
    }

    public void setRingtone(String ringtone) {
        this.ringtone = ringtone;
    }

    public Object getCrbt() {
        return crbt;
    }

    public void setCrbt(Object crbt) {
        this.crbt = crbt;
    }

    public Object getAudition() {
        return audition;
    }

    public void setAudition(Object audition) {
        this.audition = audition;
    }

    public String getCopyFrom() {
        return copyFrom;
    }

    public void setCopyFrom(String copyFrom) {
        this.copyFrom = copyFrom;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public Object getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(Object rtUrl) {
        this.rtUrl = rtUrl;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public Object getTransName() {
        return transName;
    }

    public void setTransName(Object transName) {
        this.transName = transName;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Object getNoCopyrightRcmd() {
        return noCopyrightRcmd;
    }

    public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
        this.noCopyrightRcmd = noCopyrightRcmd;
    }

    public int getMvid() {
        return mvid;
    }

    public void setMvid(int mvid) {
        this.mvid = mvid;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public Object getRurl() {
        return rurl;
    }

    public void setRurl(Object rurl) {
        this.rurl = rurl;
    }

    public Music getBMusic() {
        return bMusic;
    }

    public void setBMusic(Music bMusic) {
        this.bMusic = bMusic;
    }

    public Object getMp3Url() {
        return mp3Url;
    }

    public void setMp3Url(Object mp3Url) {
        this.mp3Url = mp3Url;
    }

    public Music getHMusic() {
        return hMusic;
    }

    public void setHMusic(Music hMusic) {
        this.hMusic = hMusic;
    }

    public Music getMMusic() {
        return mMusic;
    }

    public void setMMusic(Music mMusic) {
        this.mMusic = mMusic;
    }

    public Music getLMusic() {
        return lMusic;
    }

    public void setLMusic(Music lMusic) {
        this.lMusic = lMusic;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
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

    public List<?> getRtUrls() {
        return rtUrls;
    }

    public void setRtUrls(List<?> rtUrls) {
        this.rtUrls = rtUrls;
    }

    public static class Album {
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
}
