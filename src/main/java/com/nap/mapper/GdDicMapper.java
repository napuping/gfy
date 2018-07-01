package com.nap.mapper;

import com.nap.entity.po.GdDic;
import com.nap.entity.po.GdDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdDicMapper {
    int countByExample(GdDicExample example);

    int deleteByExample(GdDicExample example);

    int deleteByPrimaryKey(Integer dicId);

    int insert(GdDic record);

    int insertSelective(GdDic record);

    List<GdDic> selectByExample(GdDicExample example);

    GdDic selectByPrimaryKey(Integer dicId);

    int updateByExampleSelective(@Param("record") GdDic record, @Param("example") GdDicExample example);

    int updateByExample(@Param("record") GdDic record, @Param("example") GdDicExample example);

    int updateByPrimaryKeySelective(GdDic record);

    int updateByPrimaryKey(GdDic record);
}