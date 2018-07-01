
package com.nap.service;

import com.nap.entity.po.GdComment;
import com.nap.entity.result.Page;
import com.nap.entity.vo.GdCommentExtend;
import com.nap.entity.vo.GdCommentQueryVo;

public interface IGdCommentService {

    Page<GdCommentExtend> getParentComment(GdCommentQueryVo vo,int curPage,int pageSize);
    
    Page<GdCommentExtend> getSubComment(int curPage,int pageSize,Integer parentId);
    
    long countComments(Integer projectId);

    void insert(GdComment comment);

    void reply(GdComment comment);
}
