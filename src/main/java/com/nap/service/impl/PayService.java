
package com.nap.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayClient;
import com.nap.entity.po.GdPay;
import com.nap.entity.po.GdProject;
import com.nap.entity.po.GdProjectExample;
import com.nap.entity.po.GdProjectExample.Criteria;
import com.nap.entity.result.ResultData;
import com.nap.mapper.GdPayMapper;
import com.nap.mapper.GdProjectMapper;
import com.nap.service.IPayService;
import com.nap.util.FileUtil;
import com.nap.util.OrderNumberUtil;
import com.nap.util.PayUtil;
import com.nap.util.ZxingUtils;

@Service
public class PayService implements IPayService {

    @Resource
    private AlipayClient alipayClient;

    @Resource
    private GdProjectMapper gdProjectMapper;
    
    @Resource
    private GdPayMapper payMapper;

    @Value("${notifyUrl}")
    private String notifyUrl;

    @Value("${sellerId}")
    private String sellerId;
    
    @Value("${subject}")
    private String subject;

    // 订单号 查询 数据库
    // 用订单号去查询交易状态，（调用当面付查询接口）
        // 若无记录， 则创建二维码 
        // 若交易关闭，则根据订单号更改订单号，重新生成二维码（订单号不设为主键）（删除已经失效的二维码）
        // 若已支付，提示用户已支付
        // 若等待支付，则提示用户去支付宝支付||或者再次生成二维码？
    public ResultData pay(String orderNumber,
            Double totalAmount,String type,HttpServletRequest request) throws Exception {
        GdProjectExample example = new GdProjectExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrdernumEqualTo(orderNumber);
        List<GdProject> projects = gdProjectMapper.selectByExample(example);
        if(projects == null || projects.size() == 0)
            return ResultData.build("300", "数据库无此单号！");
        
        GdProject project = projects.get(0);
        
        //调用支付接口查询  // 400 无记录  500 交易关闭      ||   600 已支付    700 等待支付    300 查询失败         (无记录 )ACQ.TRADE_NOT_EXIST
        ResultData data = PayUtil.query(alipayClient, orderNumber);
        if(data.getCode().equals("600")){
            // 数据库订单状态 和 支付宝 状态不一致  则以支付宝状态为准 更新数据库  
            if(!project.getStatus().equals(type)){
                
                //此时获取支付信息 写入支付表
                Map<String,String> params = (Map<String, String>)data.getData();
                GdPay pay = PayUtil.convert2Pay(params, request, project.getProjectId());
                payMapper.insert(pay);//
                
                //更新状态
                project.setStatus(type);
                //这时 如果是状态3 则需要也更新一下 order 用于付剩余钱
                if(type.equals("3"))
                    project.setOrdernum(OrderNumberUtil.createUniqueNumber());
                gdProjectMapper.updateByPrimaryKeySelective(project);
                //需要删除 无用 的二维码图片 
                String fname = "qr-" + orderNumber + ".png";
                String path = request.getSession().
                        getServletContext().getRealPath("/") + "static/images/payqrcode/" + fname;
               if(FileUtil.deleteFile(path))
                   System.out.println("二维码删除成功：" + fname);//记录日志
                else
                   System.out.println("二维码删除失败：" + fname);
               
            }
            return ResultData.build("300", "订单已支付，请刷新页面！");
        }else if(data.getCode().equals("700")){
            return ResultData.build("300", "订单已创建，请前往支付宝支付！");
        }else if(data.getCode().equals("300"))
            return ResultData.build("300", "调用接口失败，请稍后重试！");
        else if(data.getCode().equals("500")){
            //交易关闭需要重新生成 单号 重新生成二维码  需要删除旧的二维码图片
            //删除旧码
            String fname = "qr-" + orderNumber + ".png";
            String path = request.getSession().
                    getServletContext().getRealPath("/") + "static/images/payqrcode/" + fname;
            FileUtil.deleteFile(path);
            if(FileUtil.deleteFile(path))
                System.out.println("二维码删除成功：" + fname);//记录日志
             else
                System.out.println("二维码删除失败：" + fname);
            
            orderNumber = OrderNumberUtil.createUniqueNumber();
            project.setOrdernum(orderNumber);
            gdProjectMapper.updateByPrimaryKeySelective(project);
        }
         //data.getCode 为400的情况 直接请求二维码
        ResultData dataPay = PayUtil.pay(alipayClient, orderNumber, sellerId, totalAmount, subject, notifyUrl);
        if(dataPay.getCode().equals("200")){
            //生成 二维码 返回路径
            String basePath = request.getSession().getServletContext().getRealPath("/");
            String fileName =
                    String.format("static%simages%spayqrcode%sqr-%s.png", 
                            File.separator, File.separator,File.separator, orderNumber);
            String filePath = new StringBuilder(basePath).append(fileName).toString();

            ZxingUtils.getQRCodeImge(String.valueOf(dataPay.getData()), 256, filePath);
            
            return ResultData.build("200", dataPay.getMessage(), fileName);
        }else
            return dataPay;
        
    }

    

}
