
package com.nap.entity.vo;

import java.io.Serializable;

import com.nap.entity.po.GdComment;
import com.nap.entity.result.Page;

public class GdCommentExtend extends GdComment implements Serializable{

    private static final long serialVersionUID = 1L;

    private Page<GdCommentExtend> subPage;

    // 扩展
    private String username;

    private String username2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public Page<GdCommentExtend> getSubPage() {
        return subPage;
    }

    public void setSubPage(Page<GdCommentExtend> subPage) {
        this.subPage = subPage;
    }

    @Override
    public String toString() {
        return "GdCommentExtend [subPage=" + subPage + ", getCommentId()=" + getCommentId() + ", getParentId()="
                + getParentId() + ", getProjectId()=" + getProjectId() + ", getUserId()=" + getUserId()
                + ", getContent()=" + getContent() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
