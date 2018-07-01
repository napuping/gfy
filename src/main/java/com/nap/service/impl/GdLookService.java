
package com.nap.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nap.entity.po.GdLook;
import com.nap.mapper.GdLookMapper;
import com.nap.service.IGdLookService;

@Service
public class GdLookService implements IGdLookService{

    @Resource
    private GdLookMapper gdLookMapper;
    
    //插入
    public void insert(GdLook look) {
        gdLookMapper.insert(look);
    }

   
}
