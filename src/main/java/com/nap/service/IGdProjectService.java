
package com.nap.service;

import javax.servlet.http.HttpServletRequest;

import com.nap.entity.po.GdProject;
import com.nap.entity.result.Page;
import com.nap.entity.vo.GdProjectExtend;
import com.nap.entity.vo.GdProjectQueryVo;

public interface IGdProjectService {

    Page<GdProjectExtend> queryByPage(Integer curPage, Integer pageSize, GdProjectQueryVo gdProjectQueryVo);
    
    GdProjectExtend queryByOrderNumber(String orderNumber);
    
    void update(GdProject project);

    void insert(GdProject project);

    GdProject findById(Integer projectId);

    void updateForStatus(GdProject newProject);
    
    GdProjectExtend findByIdUseExtend(Integer projectId);

    void deleteById(HttpServletRequest request, Integer id);

}
