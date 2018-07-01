package com.nap.mapper;

import com.nap.entity.po.GdNotify;
import com.nap.entity.po.GdNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdNotifyMapper {
    int countByExample(GdNotifyExample example);

    int deleteByExample(GdNotifyExample example);

    int deleteByPrimaryKey(Integer notifyId);

    int insert(GdNotify record);

    int insertSelective(GdNotify record);

    List<GdNotify> selectByExampleWithBLOBs(GdNotifyExample example);

    List<GdNotify> selectByExample(GdNotifyExample example);

    GdNotify selectByPrimaryKey(Integer notifyId);

    int updateByExampleSelective(@Param("record") GdNotify record, @Param("example") GdNotifyExample example);

    int updateByExampleWithBLOBs(@Param("record") GdNotify record, @Param("example") GdNotifyExample example);

    int updateByExample(@Param("record") GdNotify record, @Param("example") GdNotifyExample example);

    int updateByPrimaryKeySelective(GdNotify record);

    int updateByPrimaryKeyWithBLOBs(GdNotify record);

    int updateByPrimaryKey(GdNotify record);
}