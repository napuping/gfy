
package com.nap.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.nap.entity.po.GdPay;
import com.nap.entity.po.GdUser;
import com.nap.entity.result.ResultData;

public class PayUtil {

    public static ResultData pay(AlipayClient client, 
            String orderNumber, String sellerId, Double totalAmount,
            String subject, String notifyUrl) {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setOutTradeNo(orderNumber);
        model.setTotalAmount(String.valueOf(totalAmount));
        model.setSubject(subject);
        model.setSellerId(sellerId);
        model.setQrCodeTimeoutExpress("12m");
        model.setTimeoutExpress("12m");
        request.setBizModel(model);
        request.setNotifyUrl(notifyUrl);
        try {
            AlipayTradePrecreateResponse response = client.execute(request);
            String code = response.getCode();
            // 10000 业务调用成功 非10000 业务失败 submsg中带有错误信息
            if(!code.equals("10000"))
               return ResultData.build("300", response.getSubMsg());
            else
               return ResultData.build("200", "返回二维码", response.getQrCode());
        } catch(AlipayApiException e) {
            e.printStackTrace();
           return  ResultData.build("300", "调用接口时出现异常！");
        }
    }
    // 400 无记录  500 交易关闭      ||   600 已支付    700 等待支付    300 查询失败   ACQ.TRADE_NOT_EXIST
    public static ResultData query(AlipayClient client, String orderNumber){
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo(orderNumber);
        request.setBizModel(model);
        try {
            AlipayTradeQueryResponse response = client.execute(request);
            String code = response.getCode();
            String tradeStatus = response.getTradeStatus();
            //调用出现异常情况
            if(!code.equals("10000") ){
                if(response.getSubCode().equals("ACQ.TRADE_NOT_EXIST"))
                    return ResultData.build("400", "无记录！");
                else
                    return ResultData.build("300", response.getSubMsg());
            }
            //成功后返回状态情况
            if(tradeStatus.endsWith("TRADE_CLOSED"))
                return ResultData.build("500", "交易关闭！");
            else if(tradeStatus.equals("TRADE_SUCCESS")){//在已支付状态时  把返回的支付信息也封装到resultdata中，便于写支付信息
                Map<String, String> params = convert2Map(response);
                return ResultData.build("600","已支付！",params);
            }
            else if(tradeStatus.equals("WAIT_BUYER_PAY"))
                return ResultData.build("700", "等待支付！");
            else
                return ResultData.build("800", "交易结束！");
            
        } catch(AlipayApiException e) {
            e.printStackTrace();
            return ResultData.build("300", "查询失败！");
        }
    }
    private static Map<String,String> convert2Map(AlipayTradeQueryResponse response){
        Map<String,String> params = new HashMap<String, String>();
        params.put("gmt_create", new SimpleDateFormat
                ("yyyy-MM-dd HH:mm:ss").format(response.getSendPayDate()));
        params.put("buyer_id", response.getBuyerUserId());
        params.put("trade_status", response.getTradeStatus());
        params.put("total_amount", response.getTotalAmount());
        params.put("trade_no", response.getTradeNo());
        params.put("out_trade_no", response.getOutTradeNo());
        params.put("buyer_logon_id", response.getBuyerLogonId());
        params.put("subject", "?");
        return params;
    }
    
    //封装支付信息
    public static GdPay convert2Pay(Map<String,String> map,HttpServletRequest request,Integer projectId){
        GdPay pay = new GdPay();
        String paytime = map.get("gmt_create");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paytime);
        } catch(ParseException e) {
            e.printStackTrace();
            System.out.println("格式化时间错误");
        }
        String buyerid = map.get("buyer_id");
        String tradestatus = map.get("trade_status");
        Double totalamount = Double.valueOf(map.get("total_amount"));
        String tradeno = map.get("trade_no");
        String ordernum = map.get("out_trade_no");
        String loginid = map.get("buyer_logon_id");
        String subject = map.get("subject");
        GdUser user = SessionUtil.getObject(request, "user", GdUser.class);
        Integer userid = null;
        if(user != null)
             userid = user.getUserId();
        pay.setProjectId(projectId);
        pay.setSubject(subject);
        pay.setBuyerid(buyerid);
        pay.setLoginid(loginid);
        pay.setOrdernum(ordernum);
        pay.setPaytime(date);
        pay.setTotalamount(totalamount);
        pay.setTradeno(tradeno);
        pay.setTradestatus(tradestatus);
        pay.setUserid(userid);
        return pay;
        
    }

}
