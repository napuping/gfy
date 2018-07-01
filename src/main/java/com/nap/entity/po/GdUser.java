package com.nap.entity.po;

import java.io.Serializable;
import java.util.Date;

public class GdUser implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String username;

    private String password;

    private String phone;

    private String sflag;

    private String qq;

    private Date registertime;

    private String selfsay;

    private String hpath;

    private Integer age;

    private String school;

    private String sex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSflag() {
        return sflag;
    }

    public void setSflag(String sflag) {
        this.sflag = sflag == null ? null : sflag.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getSelfsay() {
        return selfsay;
    }

    public void setSelfsay(String selfsay) {
        this.selfsay = selfsay == null ? null : selfsay.trim();
    }

    public String getHpath() {
        return hpath;
    }

    public void setHpath(String hpath) {
        this.hpath = hpath == null ? null : hpath.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}