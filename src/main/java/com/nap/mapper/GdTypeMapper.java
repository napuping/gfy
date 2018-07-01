package com.nap.mapper;

import com.nap.entity.po.GdType;
import com.nap.entity.po.GdTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdTypeMapper {
    int countByExample(GdTypeExample example);

    int deleteByExample(GdTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(GdType record);

    int insertSelective(GdType record);

    List<GdType> selectByExample(GdTypeExample example);

    GdType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") GdType record, @Param("example") GdTypeExample example);

    int updateByExample(@Param("record") GdType record, @Param("example") GdTypeExample example);

    int updateByPrimaryKeySelective(GdType record);

    int updateByPrimaryKey(GdType record);
}