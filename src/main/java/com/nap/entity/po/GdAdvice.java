package com.nap.entity.po;

import java.io.Serializable;
import java.util.Date;

public class GdAdvice implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Integer adviceId;

    private Integer userId;

    private Date advicetime;

    private String advicedesc;

    private String isread;

    private String advicecontent;

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAdvicetime() {
        return advicetime;
    }

    public void setAdvicetime(Date advicetime) {
        this.advicetime = advicetime;
    }

    public String getAdvicedesc() {
        return advicedesc;
    }

    public void setAdvicedesc(String advicedesc) {
        this.advicedesc = advicedesc == null ? null : advicedesc.trim();
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread == null ? null : isread.trim();
    }

    public String getAdvicecontent() {
        return advicecontent;
    }

    public void setAdvicecontent(String advicecontent) {
        this.advicecontent = advicecontent == null ? null : advicecontent.trim();
    }
}