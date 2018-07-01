
package com.nap.entity.vo;

public class GdProjectQueryVo extends GdProjectExtend {

    // 用于排序
    private String orderBy;
    
    private String ordernum;
    
    public String getOrdernum() {
        return ordernum;
    }

    
    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
