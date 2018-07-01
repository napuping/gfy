package com.nap.mapper;

import com.nap.entity.po.GdComment;
import com.nap.entity.po.GdCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdCommentMapper {
    int countByExample(GdCommentExample example);

    int deleteByExample(GdCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(GdComment record);

    int insertSelective(GdComment record);

    List<GdComment> selectByExampleWithBLOBs(GdCommentExample example);

    List<GdComment> selectByExample(GdCommentExample example);

    GdComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") GdComment record, @Param("example") GdCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") GdComment record, @Param("example") GdCommentExample example);

    int updateByExample(@Param("record") GdComment record, @Param("example") GdCommentExample example);

    int updateByPrimaryKeySelective(GdComment record);

    int updateByPrimaryKeyWithBLOBs(GdComment record);

    int updateByPrimaryKey(GdComment record);
}