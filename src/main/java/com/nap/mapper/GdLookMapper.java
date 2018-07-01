package com.nap.mapper;

import com.nap.entity.po.GdLook;
import com.nap.entity.po.GdLookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdLookMapper {
    int countByExample(GdLookExample example);

    int deleteByExample(GdLookExample example);

    int deleteByPrimaryKey(Integer lookId);

    int insert(GdLook record);

    int insertSelective(GdLook record);

    List<GdLook> selectByExample(GdLookExample example);

    GdLook selectByPrimaryKey(Integer lookId);

    int updateByExampleSelective(@Param("record") GdLook record, @Param("example") GdLookExample example);

    int updateByExample(@Param("record") GdLook record, @Param("example") GdLookExample example);

    int updateByPrimaryKeySelective(GdLook record);

    int updateByPrimaryKey(GdLook record);
}