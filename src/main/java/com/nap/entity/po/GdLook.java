package com.nap.entity.po;

import java.io.Serializable;

public class GdLook implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer lookId;

    private String lookip;

    private String looker;

    private Integer projectId;

    public Integer getLookId() {
        return lookId;
    }

    public void setLookId(Integer lookId) {
        this.lookId = lookId;
    }

    public String getLookip() {
        return lookip;
    }

    public void setLookip(String lookip) {
        this.lookip = lookip == null ? null : lookip.trim();
    }

    public String getLooker() {
        return looker;
    }

    public void setLooker(String looker) {
        this.looker = looker == null ? null : looker.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}