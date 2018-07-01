
package com.nap.service;

import javax.servlet.http.HttpServletRequest;

import com.nap.entity.result.ResultData;

public interface IPayService {

    //type 标识 订单属于哪种状态 3 已付定金   4 已付全款  传值时直接传数字
    ResultData pay(String orderNumber, 
            Double totalAmount,String type,HttpServletRequest request) throws Exception;
    
   

}
