package com.nap.mapper;

import com.nap.entity.po.GdPay;
import com.nap.entity.po.GdPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdPayMapper {
    int countByExample(GdPayExample example);

    int deleteByExample(GdPayExample example);

    int deleteByPrimaryKey(Integer payId);

    int insert(GdPay record);

    int insertSelective(GdPay record);

    List<GdPay> selectByExample(GdPayExample example);

    GdPay selectByPrimaryKey(Integer payId);

    int updateByExampleSelective(@Param("record") GdPay record, @Param("example") GdPayExample example);

    int updateByExample(@Param("record") GdPay record, @Param("example") GdPayExample example);

    int updateByPrimaryKeySelective(GdPay record);

    int updateByPrimaryKey(GdPay record);
}