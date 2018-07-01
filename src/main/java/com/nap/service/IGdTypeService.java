
package com.nap.service;

import java.util.List;

import com.nap.entity.vo.GdTypeExtend;

public interface IGdTypeService {
    
    List<GdTypeExtend> getTypeList();
    
    List<GdTypeExtend> getLanList();

}
