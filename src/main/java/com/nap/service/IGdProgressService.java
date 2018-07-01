
package com.nap.service;

import java.util.List;

import com.nap.entity.vo.GdProgressExtend;

public interface IGdProgressService {
    
    List<GdProgressExtend> queryByProjectId(Integer projectId);

}
