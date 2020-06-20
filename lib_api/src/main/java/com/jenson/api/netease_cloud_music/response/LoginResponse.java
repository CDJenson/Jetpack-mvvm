package com.jenson.api.netease_cloud_music.response;

import com.jenson.api.netease_cloud_music.bean.AccountBean;
import com.jenson.api.netease_cloud_music.bean.BindingsBean;
import com.jenson.api.netease_cloud_music.bean.ProfileBean;

import java.util.List;

/**
 * author: CDJenson
 * date: 2020/5/25 11:02
 * version: 1.0
 * description: One-sentence description
 */
public class LoginResponse extends BaseReponse{


    private static final long serialVersionUID = -4658317441987441442L;

    /**
     * loginType : 0
     * code : 200
     * account : {"id":16394569,"userName":"1_18173322830","type":1,"status":0,"whitelistAuthority":0,"createTime":0,"salt":"[B@39742374","tokenVersion":1,"ban":0,"baoyueVersion":-2,"donateVersion":0,"vipType":0,"viptypeVersion":1489680151497,"anonimousUser":false}
     * token : 6a033553fa712dc5d587cd754d71cfae6bf4f9fd0c41eb1a220dcd210e3b9be70931c3a9fbfe3df2
     * profile : {"description":"","djStatus":0,"userId":16394569,"defaultAvatar":false,"avatarUrl":"https://p3.music.126.net/tktIc0Mmya1C71PZStacww==/18818141511164600.jpg","province":440000,"avatarImgId":18818141511164600,"birthday":-2209017600000,"accountStatus":0,"avatarImgIdStr":"18818141511164600","backgroundImgIdStr":"2002210674180202","detailDescription":"","followed":false,"backgroundUrl":"https://p3.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg","gender":0,"experts":{},"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"nickname":"Good丿Boy","userType":0,"backgroundImgId":2002210674180202,"city":440300,"vipType":0,"signature":"","authority":0,"avatarImgId_str":"18818141511164600","followeds":0,"follows":5,"eventCount":1,"playlistCount":8,"playlistBeSubscribedCount":0}
     * bindings : [{"expired":false,"userId":16394569,"expiresIn":2147483647,"bindingTime":1590372351378,"refreshTime":1590372351,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"18173322830\",\"hasPassword\":true}","url":"","id":10637970308,"type":1}]
     * cookie : MUSIC_U=6a033553fa712dc5d587cd754d71cfae6bf4f9fd0c41eb1a220dcd210e3b9be70931c3a9fbfe3df2; Expires=Tue, 09-Jun-2020 03:01:25 GMT; Path=/;__remember_me=true; Expires=Tue, 09-Jun-2020 03:01:25 GMT; Path=/;__csrf=c3152801fbd559a3df36a2f8beb403f3; Expires=Tue, 09-Jun-2020 03:01:35 GMT; Path=/
     */

    private int loginType;
    private int code;
    private AccountBean account;
    private String token;
    private ProfileBean profile;
    private String cookie;
    private List<BindingsBean> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }
}
