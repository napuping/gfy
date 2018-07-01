
package com.nap.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nap.entity.po.GdNotify;
import com.nap.entity.po.GdNotifyExample;
import com.nap.mapper.GdNotifyMapper;
import com.nap.service.IGdNotifyService;

@Service
public class GdNotifyService implements IGdNotifyService{

    @Resource
    private GdNotifyMapper gdNotifyMapper;
    
    public GdNotify findLastNotify() {
        GdNotifyExample example = new GdNotifyExample();
        example.setOrderByClause("notifytime desc");
        List<GdNotify> notifys = gdNotifyMapper.selectByExampleWithBLOBs(example);
        if(notifys != null && notifys.size() > 0)
            return notifys.get(0);
        return null;
    }

   
}
