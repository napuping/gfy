
package com.nap.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nap.entity.po.GdPay;
import com.nap.mapper.GdPayMapper;
import com.nap.service.IGdPayService;

@Service
public class GdPayService implements IGdPayService{

    @Resource
    private GdPayMapper payMapper;
    
    public void insert(GdPay pay) {
        payMapper.insert(pay);
    }

}
