
package com.nap.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.nap.entity.po.GdPay;
import com.nap.entity.po.GdProject;
import com.nap.entity.result.ResultData;
import com.nap.entity.vo.GdProjectExtend;
import com.nap.service.IGdPayService;
import com.nap.service.IGdProjectService;
import com.nap.service.IPayService;
import com.nap.util.FileUtil;
import com.nap.util.OrderNumberUtil;
import com.nap.util.PayUtil;

@RequestMapping("/pay")
@Controller
public class PayController {

    @Resource
    private AlipayClient alipayClient;

    @Resource
    private IPayService payService;
    
    @Resource
    private IGdProjectService projectService;
    
    @Resource
    private IGdPayService gdPayService;
    

    @Value("${charset}")
    private String charset;

    @Value("${signType}")
    private String signType;

    @Value("${public_key}")
    private String publicKey;

    @Value("${appid}")
    private String appid;
    
    @Value("${alipay_public_key}")
    private String apublicKey;

    @ResponseBody
    @RequestMapping("/notifyUrl")
    public String notifyUrls(HttpServletRequest request) {
        // 验证签名
        // 验证appid是否正确
        // 验证订单id是否存在
        // 验证返回的金额是否和原始金额一致
        // 判断订单的状态是否为已付款，若不，则更新订单状态为已付款，若是，则不进行更新 //可能多次回调
        Enumeration<?> params = request.getParameterNames();
        Map<String, String> map = convertMap(params, request);
        boolean flag;
        try {
            flag = AlipaySignature.rsaCheckV1(map, apublicKey, charset, signType);
            if(flag) {
                // 验证appid
                String fromAppId = map.get("auth_app_id");
                if(fromAppId.equals(appid)){
                    //验证 订单id是否存在
                    String orderNumber = map.get("out_trade_no");
                    GdProjectExtend project = projectService.queryByOrderNumber(orderNumber);
                    System.out.println(project == null);
                    if(project != null){
                        //验证返回的金额是否和原始金额一致
                        Double fromtotal = Double.valueOf(map.get("total_amount"));
                        String status = project.getStatus();
                        boolean f = false;
                        if(Integer.valueOf(status) < 3){
                            f = (fromtotal .equals(project.getPremoney()));
                        }
                        else if(Integer.valueOf(status) >= 3){
                            f = (fromtotal.equals(project.getRemainmoney()));
                            System.out.println((fromtotal == project.getRemainmoney()));
                        }
                        if(f){
                            //判断订单的状态是否为已付款，若不，则更新订单状态为已付款，若是，则不进行更新 //可能多次回调
                            GdProject newProject = new GdProject();
                            newProject.setProjectId(project.getProjectId());
                            if(Integer.valueOf(status) < 3){
                                newProject.setStatus("3");
                                //并重新生成单号，用于付余款
                                newProject.setOrdernum(OrderNumberUtil.createUniqueNumber());
                            }else{
                                //支付宝可能多次回调，需要多做一次判断，是否需要将3 改 为 4，
                                //根据穿过来的单号是否在数据库中存在(因为在第一次改为3的时候改变了单号)，不存在 则说明是重复回调不改4 存在说明需要将状态3改为4
                                GdProjectExtend statusProject = projectService.queryByOrderNumber(orderNumber);
                                if(statusProject != null)
                                    newProject.setStatus("4");
                            }
                            try {
                                if(!StringUtils.isEmpty(newProject.getStatus()))
                                projectService.updateForStatus(newProject);
                            } catch(Exception e) {
                                e.printStackTrace();
                                System.out.println("更新失败！！" + newProject);
                            }
                            /*if(!(status.equals("3") || status.equals("4"))){
                                String statustmp = Integer.valueOf(status) < 3 ? "3" : "4";
                                //更新状态
                                GdProject newProject = new GdProject();
                                newProject.setProjectId(project.getProjectId());
                                newProject.setStatus(statustmp);
                                //如果状态小于<3更新单号，用于付剩余钱
                                if(Integer.valueOf(status) < 3)
                                    newProject.setOrdernum(OrderNumberUtil.createUniqueNumber());
                                try {
                                    projectService.update(newProject);
                                } catch(Exception e) {
                                    e.printStackTrace();
                                    System.out.println("更新失败！！");
                                }*/
                                //删除对应二维码
                                String basePath = request.getSession().getServletContext().getRealPath("/");
                                String fileName =
                                        String.format("static%simages%spayqrcode%sqr-%s.png", 
                                                File.separator, File.separator,File.separator, orderNumber);
                                FileUtil.deleteFile(basePath + fileName);
                                //写入支付信息 gmt_create   <subject>
                                //buyer_id trade_status total_amount trade_no out_trade_no buyer_logon_id
                                GdPay pay = PayUtil.convert2Pay(map, request,project.getProjectId());
                                try {
                                    gdPayService.insert(pay);
                                } catch(Exception e) {
                                    e.printStackTrace();
                                    System.out.println("插入支付信息异常，单号为：" + pay.getOrdernum());
                                }
                            }
                        }
                    }
                }
        } catch(AlipayApiException e) {
            e.printStackTrace();
        }
        return "success";
    }
    
    //异步返回信息 转 map
    private Map<String, String> convertMap(Enumeration<?> params, HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        while(params.hasMoreElements()) {
            String name = String.valueOf(params.nextElement());
            String value = request.getParameter(name);
            map.put(name, value);
        }
        return map;
    }
    
    //支付 生成二维码
    @ResponseBody
    @RequestMapping("/mine/{orderNumber}/{type}/{totalAmount}")
    public ResultData pay(HttpServletRequest request, @PathVariable String orderNumber,
            @PathVariable Double totalAmount, @PathVariable String type) {
        try {
            ResultData data = payService.pay(orderNumber, totalAmount, type, request);
            return data;
        } catch(Exception e) {
            e.printStackTrace();
            return ResultData.build("300", "系统繁忙，稍后重试！");
        }
    }

}
