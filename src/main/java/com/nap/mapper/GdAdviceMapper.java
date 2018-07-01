package com.nap.mapper;

import com.nap.entity.po.GdAdvice;
import com.nap.entity.po.GdAdviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdAdviceMapper {
    int countByExample(GdAdviceExample example);

    int deleteByExample(GdAdviceExample example);

    int deleteByPrimaryKey(Integer adviceId);

    int insert(GdAdvice record);

    int insertSelective(GdAdvice record);

    List<GdAdvice> selectByExampleWithBLOBs(GdAdviceExample example);

    List<GdAdvice> selectByExample(GdAdviceExample example);

    GdAdvice selectByPrimaryKey(Integer adviceId);

    int updateByExampleSelective(@Param("record") GdAdvice record, @Param("example") GdAdviceExample example);

    int updateByExampleWithBLOBs(@Param("record") GdAdvice record, @Param("example") GdAdviceExample example);

    int updateByExample(@Param("record") GdAdvice record, @Param("example") GdAdviceExample example);

    int updateByPrimaryKeySelective(GdAdvice record);

    int updateByPrimaryKeyWithBLOBs(GdAdvice record);

    int updateByPrimaryKey(GdAdvice record);
}