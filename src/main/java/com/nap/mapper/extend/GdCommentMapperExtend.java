
package com.nap.mapper.extend;

import java.util.List;

import com.nap.entity.vo.GdCommentExtend;
import com.nap.entity.vo.GdCommentQueryVo;

public interface GdCommentMapperExtend {

    List<GdCommentExtend> selectByPidOne(GdCommentQueryVo vo);
    List<GdCommentExtend> selectByPidCascade(Integer parentId);
    Long countByProjectId(Integer projectId);
}
