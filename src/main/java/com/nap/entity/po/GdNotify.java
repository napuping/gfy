package com.nap.entity.po;

import java.io.Serializable;
import java.util.Date;

public class GdNotify implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer notifyId;

    private String notifytitle;

    private String pflag;

    private Integer userId;

    private Integer adminId;

    private Date notifytime;

    private String notifycontent;

    public Integer getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Integer notifyId) {
        this.notifyId = notifyId;
    }

    public String getNotifytitle() {
        return notifytitle;
    }

    public void setNotifytitle(String notifytitle) {
        this.notifytitle = notifytitle == null ? null : notifytitle.trim();
    }

    public String getPflag() {
        return pflag;
    }

    public void setPflag(String pflag) {
        this.pflag = pflag == null ? null : pflag.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getNotifytime() {
        return notifytime;
    }

    public void setNotifytime(Date notifytime) {
        this.notifytime = notifytime;
    }

    public String getNotifycontent() {
        return notifycontent;
    }

    public void setNotifycontent(String notifycontent) {
        this.notifycontent = notifycontent == null ? null : notifycontent.trim();
    }
}