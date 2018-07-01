
package com.nap.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nap.entity.vo.GdProgressExtend;
import com.nap.mapper.extend.GdProgressMapperExtend;
import com.nap.service.IGdProgressService;

@Service
public class GdProgressService implements IGdProgressService{

    @Resource
    private GdProgressMapperExtend gdProgressMapperExtend;
    
    public List<GdProgressExtend> queryByProjectId(Integer projectId) {
        
        List<GdProgressExtend> progresss = gdProgressMapperExtend.queryByProjectId(projectId);
        return progresss;
    }
    

}
