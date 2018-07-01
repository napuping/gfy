
package com.nap.entity.vo;

import java.io.Serializable;

import com.nap.entity.po.GdProject;

public class GdProjectExtend extends GdProject implements Serializable{
    private static final long serialVersionUID = 1L;

    private String username;

    private Long comments;

    private Long look;

    private Double totalmoney;

    private Double premoney;

    private Double remainmoney;

    private String statustext;

    private String typetext;

    private String lantext;

    public String getTypetext() {
        return typetext;
    }

    public void setTypetext(String typetext) {
        this.typetext = typetext;
    }

    public String getLantext() {
        return lantext;
    }

    public void setLantext(String lantext) {
        this.lantext = lantext;
    }

    public String getStatustext() {
        return statustext;
    }

    public void setStatustext(String statustext) {
        this.statustext = statustext;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Double getPremoney() {
        return premoney;
    }

    public void setPremoney(Double premoney) {
        this.premoney = premoney;
    }

    public Double getRemainmoney() {
        return remainmoney;
    }

    public void setRemainmoney(Double remainmoney) {
        this.remainmoney = remainmoney;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public Long getLook() {
        return look;
    }

    public void setLook(Long look) {
        this.look = look;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
