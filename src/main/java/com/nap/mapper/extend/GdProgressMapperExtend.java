
package com.nap.mapper.extend;

import java.util.List;

import com.nap.entity.vo.GdProgressExtend;

public interface GdProgressMapperExtend {
    
    List<GdProgressExtend> queryByProjectId(Integer projectId);

}
