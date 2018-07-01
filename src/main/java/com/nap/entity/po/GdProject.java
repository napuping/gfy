package com.nap.entity.po;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import org.springframework.util.StringUtils;

public class GdProject implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer projectId;

    private String projectname;

    private String projectdesc;

    private String filepath;

    private Date committime;

    private String status;

    private Integer userId;

    private String typecode;

    private String lancode;

    private String ordernum;

    private String isanonymous;

    private String pflag;

    private String contactway;

    private String iscomment;
    
    public String getFilename(){
        if(!StringUtils.isEmpty(filepath)){
            String[] tmp = null;
            String split = File.separator;
            if(split.indexOf("/") != -1)
                tmp = filepath.split("/");
            else if(split.indexOf("\\") != -1)
                tmp = filepath.split("\\\\");
            return tmp[tmp.length-1];
        }
        return null;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getProjectdesc() {
        return projectdesc;
    }

    public void setProjectdesc(String projectdesc) {
        this.projectdesc = projectdesc == null ? null : projectdesc.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Date getCommittime() {
        return committime;
    }

    public void setCommittime(Date committime) {
        this.committime = committime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    public String getLancode() {
        return lancode;
    }

    public void setLancode(String lancode) {
        this.lancode = lancode == null ? null : lancode.trim();
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getIsanonymous() {
        return isanonymous;
    }

    public void setIsanonymous(String isanonymous) {
        this.isanonymous = isanonymous == null ? null : isanonymous.trim();
    }

    public String getPflag() {
        return pflag;
    }

    public void setPflag(String pflag) {
        this.pflag = pflag == null ? null : pflag.trim();
    }

    public String getContactway() {
        return contactway;
    }

    public void setContactway(String contactway) {
        this.contactway = contactway == null ? null : contactway.trim();
    }

    public String getIscomment() {
        return iscomment;
    }

    public void setIscomment(String iscomment) {
        this.iscomment = iscomment == null ? null : iscomment.trim();
    }
}