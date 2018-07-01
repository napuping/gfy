
package com.nap.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nap.entity.vo.GdTypeExtend;
import com.nap.mapper.extend.GdTypeMapperExtend;
import com.nap.service.IGdTypeService;

@Service
public class GdTypeService implements IGdTypeService{

    @Resource
    private GdTypeMapperExtend gdTypeMapperExtand;
    
    //查询类型信息
    public List<GdTypeExtend> getTypeList() {
        return gdTypeMapperExtand.queryByParentCode("ptype");
    }

    //查询语言信息
    public List<GdTypeExtend> getLanList() {
        return gdTypeMapperExtand.queryByParentCode("plan");
    }

    
}
