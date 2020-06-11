package com.jenson.demo.entity;

/**
 * author: CDJenson
 * date: 2020/4/22 9:49
 * version: 1.0
 * description: One-sentence description
 */
public class LoginResp {

    private String name;

    private String sex;

    public LoginResp(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "LoginResp{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
