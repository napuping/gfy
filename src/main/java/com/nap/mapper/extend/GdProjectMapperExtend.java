package com.nap.mapper.extend;

import java.util.List;

import com.nap.entity.vo.GdProjectExtend;
import com.nap.entity.vo.GdProjectQueryVo;

public interface GdProjectMapperExtend {
    
    List<GdProjectExtend> query(GdProjectQueryVo vo);
    
    GdProjectExtend queryById(Integer projectId);

    void deleteById(Integer id);
}