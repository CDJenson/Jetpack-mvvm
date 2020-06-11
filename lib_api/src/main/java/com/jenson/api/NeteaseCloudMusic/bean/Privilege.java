package com.jenson.api.NeteaseCloudMusic.bean;

/**
 * author: CDJenson
 * date: 2020/5/26 11:45
 * version: 1.0
 * description: One-sentence description
 */
public class Privilege {
    /**
     * id : 1098827
     * fee : 0
     * payed : 0
     * st : 0
     * pl : 320000
     * dl : 320000
     * sp : 7
     * cp : 1
     * subp : 1
     * cs : false
     * maxbr : 320000
     * fl : 320000
     * toast : false
     * flag : 128
     * preSell : false
     */

    private int id;
    private int fee;
    private int payed;
    private int st;
    private int pl;
    private int dl;
    private int sp;
    private int cp;
    private int subp;
    private boolean cs;
    private int maxbr;
    private int fl;
    private boolean toast;
    private int flag;
    private boolean preSell;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getPl() {
        return pl;
    }

    public void setPl(int pl) {
        this.pl = pl;
    }

    public int getDl() {
        return dl;
    }

    public void setDl(int dl) {
        this.dl = dl;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSubp() {
        return subp;
    }

    public void setSubp(int subp) {
        this.subp = subp;
    }

    public boolean isCs() {
        return cs;
    }

    public void setCs(boolean cs) {
        this.cs = cs;
    }

    public int getMaxbr() {
        return maxbr;
    }

    public void setMaxbr(int maxbr) {
        this.maxbr = maxbr;
    }

    public int getFl() {
        return fl;
    }

    public void setFl(int fl) {
        this.fl = fl;
    }

    public boolean isToast() {
        return toast;
    }

    public void setToast(boolean toast) {
        this.toast = toast;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean isPreSell() {
        return preSell;
    }

    public void setPreSell(boolean preSell) {
        this.preSell = preSell;
    }
}
