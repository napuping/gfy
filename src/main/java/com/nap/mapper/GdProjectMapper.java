package com.nap.mapper;

import com.nap.entity.po.GdProject;
import com.nap.entity.po.GdProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdProjectMapper {
    int countByExample(GdProjectExample example);

    int deleteByExample(GdProjectExample example);

    int deleteByPrimaryKey(Integer projectId);

    int insert(GdProject record);

    int insertSelective(GdProject record);

    List<GdProject> selectByExample(GdProjectExample example);

    GdProject selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") GdProject record, @Param("example") GdProjectExample example);

    int updateByExample(@Param("record") GdProject record, @Param("example") GdProjectExample example);

    int updateByPrimaryKeySelective(GdProject record);

    int updateByPrimaryKey(GdProject record);
}