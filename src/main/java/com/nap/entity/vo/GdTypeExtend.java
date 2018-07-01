
package com.nap.entity.vo;

import java.io.Serializable;
import java.util.List;

import com.nap.entity.po.GdType;

public class GdTypeExtend extends GdType implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String url;
    
    private List<GdTypeExtend> children;
    
    
    public List<GdTypeExtend> getChildren() {
        return children;
    }

    
    public void setChildren(List<GdTypeExtend> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Override
    public String toString() {
        return "GdTypeExtend [url=" + url + "]";
    }

    

}
