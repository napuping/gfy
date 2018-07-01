package com.nap.mapper;

import com.nap.entity.po.GdProgress;
import com.nap.entity.po.GdProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdProgressMapper {
    int countByExample(GdProgressExample example);

    int deleteByExample(GdProgressExample example);

    int deleteByPrimaryKey(Integer progressId);

    int insert(GdProgress record);

    int insertSelective(GdProgress record);

    List<GdProgress> selectByExampleWithBLOBs(GdProgressExample example);

    List<GdProgress> selectByExample(GdProgressExample example);

    GdProgress selectByPrimaryKey(Integer progressId);

    int updateByExampleSelective(@Param("record") GdProgress record, @Param("example") GdProgressExample example);

    int updateByExampleWithBLOBs(@Param("record") GdProgress record, @Param("example") GdProgressExample example);

    int updateByExample(@Param("record") GdProgress record, @Param("example") GdProgressExample example);

    int updateByPrimaryKeySelective(GdProgress record);

    int updateByPrimaryKeyWithBLOBs(GdProgress record);

    int updateByPrimaryKey(GdProgress record);
}