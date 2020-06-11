package com.jenson.api.NeteaseCloudMusic.bean;

/**
 * author: CDJenson
 * date: 2020/5/25 11:11
 * version: 1.0
 * description: One-sentence description
 */
public class ProfileBean {

    /**
     * description :
     * djStatus : 0
     * userId : 16394569
     * defaultAvatar : false
     * avatarUrl : https://p3.music.126.net/tktIc0Mmya1C71PZStacww==/18818141511164600.jpg
     * province : 440000
     * avatarImgId : 18818141511164600
     * birthday : -2209017600000
     * accountStatus : 0
     * avatarImgIdStr : 18818141511164600
     * backgroundImgIdStr : 2002210674180202
     * detailDescription :
     * followed : false
     * backgroundUrl : https://p3.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg
     * gender : 0
     * experts : {}
     * mutual : false
     * remarkName : null
     * expertTags : null
     * authStatus : 0
     * nickname : Good丿Boy
     * userType : 0
     * backgroundImgId : 2002210674180202
     * city : 440300
     * vipType : 0
     * signature :
     * authority : 0
     * avatarImgId_str : 18818141511164600
     * followeds : 0
     * follows : 5
     * eventCount : 1
     * playlistCount : 8
     * playlistBeSubscribedCount : 0
     */

    private String description;
    private int djStatus;
    private int userId;
    private boolean defaultAvatar;
    private String avatarUrl;
    private int province;
    private long avatarImgId;
    private long birthday;
    private int accountStatus;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;
    private String detailDescription;
    private boolean followed;
    private String backgroundUrl;
    private int gender;
    private ExpertsBean experts;
    private boolean mutual;
    private Object remarkName;
    private Object expertTags;
    private int authStatus;
    private String nickname;
    private int userType;
    private long backgroundImgId;
    private int city;
    private int vipType;
    private String signature;
    private int authority;
    private String avatarImgId_str;
    private int followeds;
    private int follows;
    private int eventCount;
    private int playlistCount;
    private int playlistBeSubscribedCount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDjStatus() {
        return djStatus;
    }

    public void setDjStatus(int djStatus) {
        this.djStatus = djStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isDefaultAvatar() {
        return defaultAvatar;
    }

    public void setDefaultAvatar(boolean defaultAvatar) {
        this.defaultAvatar = defaultAvatar;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public long getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(long avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAvatarImgIdStr() {
        return avatarImgIdStr;
    }

    public void setAvatarImgIdStr(String avatarImgIdStr) {
        this.avatarImgIdStr = avatarImgIdStr;
    }

    public String getBackgroundImgIdStr() {
        return backgroundImgIdStr;
    }

    public void setBackgroundImgIdStr(String backgroundImgIdStr) {
        this.backgroundImgIdStr = backgroundImgIdStr;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public ExpertsBean getExperts() {
        return experts;
    }

    public void setExperts(ExpertsBean experts) {
        this.experts = experts;
    }

    public boolean isMutual() {
        return mutual;
    }

    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }

    public Object getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(Object remarkName) {
        this.remarkName = remarkName;
    }

    public Object getExpertTags() {
        return expertTags;
    }

    public void setExpertTags(Object expertTags) {
        this.expertTags = expertTags;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public long getBackgroundImgId() {
        return backgroundImgId;
    }

    public void setBackgroundImgId(long backgroundImgId) {
        this.backgroundImgId = backgroundImgId;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getAvatarImgId_str() {
        return avatarImgId_str;
    }

    public void setAvatarImgId_str(String avatarImgId_str) {
        this.avatarImgId_str = avatarImgId_str;
    }

    public int getFolloweds() {
        return followeds;
    }

    public void setFolloweds(int followeds) {
        this.followeds = followeds;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public int getPlaylistCount() {
        return playlistCount;
    }

    public void setPlaylistCount(int playlistCount) {
        this.playlistCount = playlistCount;
    }

    public int getPlaylistBeSubscribedCount() {
        return playlistBeSubscribedCount;
    }

    public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
        this.playlistBeSubscribedCount = playlistBeSubscribedCount;
    }
}
