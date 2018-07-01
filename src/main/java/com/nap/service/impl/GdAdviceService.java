
package com.nap.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nap.entity.po.GdAdvice;
import com.nap.mapper.GdAdviceMapper;
import com.nap.service.IGdAdviceService;

@Service
public class GdAdviceService implements IGdAdviceService{

    @Resource
    private GdAdviceMapper gdAdviceMapper;

    public void insert(GdAdvice advice) {
        //验证
        if(StringUtils.isEmpty(advice.getAdvicedesc()))
            throw new RuntimeException("描述不能为空！");
        if(StringUtils.isEmpty(advice.getAdvicecontent()))
            throw new RuntimeException("内容不能为空！");
        advice.setIsread("0");//0 未读 1已读 默认未读
        advice.setAdvicetime(new Date());
        gdAdviceMapper.insert(advice);
    }

   
    
}
