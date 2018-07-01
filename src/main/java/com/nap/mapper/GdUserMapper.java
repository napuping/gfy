package com.nap.mapper;

import com.nap.entity.po.GdUser;
import com.nap.entity.po.GdUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdUserMapper {
    int countByExample(GdUserExample example);

    int deleteByExample(GdUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(GdUser record);

    int insertSelective(GdUser record);

    List<GdUser> selectByExample(GdUserExample example);

    GdUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") GdUser record, @Param("example") GdUserExample example);

    int updateByExample(@Param("record") GdUser record, @Param("example") GdUserExample example);

    int updateByPrimaryKeySelective(GdUser record);

    int updateByPrimaryKey(GdUser record);
}