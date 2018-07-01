package com.nap.entity.po;

import java.io.Serializable;
import java.util.Date;

public class GdProgress implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer progressId;

    private String title;

    private Date createtime;

    private Integer projectId;

    private Integer writer;

    private String content;

    public Integer getProgressId() {
        return progressId;
    }

    public void setProgressId(Integer progressId) {
        this.progressId = progressId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getWriter() {
        return writer;
    }

    public void setWriter(Integer writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}