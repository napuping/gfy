
package com.nap.entity.vo;

import java.io.Serializable;

import com.nap.entity.po.GdProgress;

public class GdProgressExtend extends GdProgress implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }
    
}
