package com.nap.mapper.extend;

import java.util.List;

import com.nap.entity.vo.GdTypeExtend;

public interface GdTypeMapperExtend {
    
    List<GdTypeExtend> queryByParentCode(String code);
    
    
}