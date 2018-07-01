package com.nap.entity.po;

import java.io.Serializable;

public class GdType implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer typeId;

    private String tcode;

    private String showtext;

    private String pcode;

    private String isleaf;

    private Integer sort;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode == null ? null : tcode.trim();
    }

    public String getShowtext() {
        return showtext;
    }

    public void setShowtext(String showtext) {
        this.showtext = showtext == null ? null : showtext.trim();
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf == null ? null : isleaf.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}