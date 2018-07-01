
package com.nap.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nap.entity.result.Page;
import com.nap.entity.vo.GdProjectExtend;
import com.nap.entity.vo.GdProjectQueryVo;
import com.nap.entity.vo.GdTypeExtend;
import com.nap.service.IGdProjectService;
import com.nap.service.IGdTypeService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    private IGdProjectService gdProjectService;
    
    @Resource
    private IGdTypeService gdTypeService;
    
    @Value("${preUrl}")
    private String preUrl;
    
    @RequestMapping("test")
    public String test(){
        
        return "public/pjaxData";
    }
    
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer curPage,
                 @RequestParam(defaultValue = "5") Integer pageSize,
                     @RequestHeader(name="X-PJAX",required=false) String PJAX,
                       GdProjectQueryVo gdProjectQueryVo,Model model) {
        
        //处理不同类型的按钮，便于传参、过滤数据
        //类型数据
        List<GdTypeExtend> types = gdTypeService.getTypeList();
        handleUrl(types, "typecode", gdProjectQueryVo);
        model.addAttribute("types", types);
        //语言数据
        List<GdTypeExtend> lans = gdTypeService.getLanList();
        handleUrl(lans, "lancode", gdProjectQueryVo);
        model.addAttribute("lans", lans);
        //其他分类
        

        //数据库获取展示数据,封装在page中 并将page放入model中，便于前台取相关数据
        gdProjectQueryVo.setPflag("0");//设置对象为所有人看见
        Page<GdProjectExtend> page = gdProjectService.queryByPage(curPage, pageSize, gdProjectQueryVo);
        model.addAttribute("page", page);
        
        //处理分页按钮url连接参数 （累加过滤参数和排序参数）
        String filter = handlerFilterParam(gdProjectQueryVo);
        String orderby = handlerOrderByParam(gdProjectQueryVo);
        String phref = createPageBtnHref(filter, orderby);
        //传入链接 生成按钮 放入model
        String btns = page.generateButton(phref);
        model.addAttribute("btns", btns);
        
        //处理排序 ，原则：拼接过滤数据参数 || 排序是一组按钮 || 按时间排序（默认committime）|按评论排序（comments）|按浏览次数(look)
        //前台展示按钮时 需要设置class属性，如：class='time|comments|look',便于区别展示当前选中的参数值
        //时间排序按钮连接
        String time = handlerOrderBy("committime", gdProjectQueryVo);
        model.addAttribute("time", time);
        //评论排序按钮连接
        String comments = handlerOrderBy("comments", gdProjectQueryVo);
        model.addAttribute("comment", comments);
        //浏览次数按钮排序链接
        String look = handlerOrderBy("look", gdProjectQueryVo);
        model.addAttribute("look", look);
        
        //处理全部按钮链接
        //全部类型 按钮链接
        String alltypeurl = writeUrl("typecode", gdProjectQueryVo);
        alltypeurl = alltypeurl.equals("") ? preUrl : preUrl + "?" + alltypeurl;
        model.addAttribute("alltypeurl", alltypeurl);
        //全部语言按钮 链接
        String alllanurl = writeUrl("lancode", gdProjectQueryVo);
        alllanurl = alllanurl.equals("") ? preUrl : preUrl + "?" + alllanurl;
        model.addAttribute("alllanurl", alllanurl);
        
        //记录当前参数值 便于前台区别展示
        //记录当前typecode值
        String typecode = gdProjectQueryVo.getTypecode();
        typecode = StringUtils.isEmpty(typecode) ? "" : typecode;
        model.addAttribute("activetype", typecode);
        //记录当前lancode值
        String lancode = gdProjectQueryVo.getLancode();
        lancode = StringUtils.isEmpty(lancode) ? "" : lancode;
        model.addAttribute("activelan", lancode);
        //记录当前的排序值
        String aorderby = gdProjectQueryVo.getOrderBy();
        aorderby = StringUtils.isEmpty(aorderby) ? "" : aorderby;
        model.addAttribute("activeorder", aorderby);
        
        //判断是否是pjax请求
        if(StringUtils.isEmpty(PJAX))
            return "public/home";
        else
            return "public/pjaxData";
            
        
    }
    
    //综合过滤参数和排序参数 用于分页按钮链接
    public String createPageBtnHref(String filter,String orderby){
        String phref = "";
        if(StringUtils.isEmpty(filter) && !StringUtils.isEmpty(orderby))
            phref = preUrl + "?" + orderby;
        else if(!StringUtils.isEmpty(filter) && StringUtils.isEmpty(orderby))
            phref = preUrl + "?" + filter;
        else if(StringUtils.isEmpty(filter) && StringUtils.isEmpty(orderby))
            phref = preUrl;
        else
            phref = preUrl + "?" + filter + "&" + orderby;
        if(phref.indexOf("?") != -1)
            phref +=  "&curPage=";
        else
            phref += "?curPage=";
        return phref;
    }
    
    //处理排序按钮
    public String handlerOrderBy(String value,GdProjectQueryVo gdProjectQueryVo){
        String temp = "";
        temp = handlerFilterParam(gdProjectQueryVo);
        String result = temp.equals("") ?  preUrl + "?orderBy=" + value: preUrl + "?" + temp + "&orderBy=" + value;
        return result;
    }

    //参数拼接原则：同一类型，不论有无值都不进行拼接，不同类型，有值进行拼接，无不拼接
    //遍历GdTypeExtend，将不同类型的有值的参数进行与自己拼接
    public void handleUrl(List<GdTypeExtend> datas,String type,GdProjectQueryVo vo){
        String param = writeUrl(type, vo);
        for(GdTypeExtend gdTypeExtend : datas){
            String url = preUrl + "?" + type + "=" + gdTypeExtend.getTcode() + (param.equals("")? param : "&" + param);
            gdTypeExtend.setUrl(url);
        }
    }
    //不是自己类型的且有值的就拼接
    public String writeUrl(String type, GdProjectQueryVo vo) {
        String param = "";
        if(!type.equals("typecode") && !StringUtils.isEmpty(vo.getTypecode())) {
            String typecode = vo.getTypecode();
            param += "typecode=" + typecode + "&";
        }
        if(!type.equals("lancode") && !StringUtils.isEmpty(vo.getLancode())) {
            String lancode = vo.getLancode();
            param += "lancode=" + lancode + "&";
        }
        //若有其他类型，依次添加
        return param.equals("") ? param : param.substring(0,param.length()-1);
    }
    
    //拼接不为空的过滤参数
    public String handlerFilterParam(GdProjectQueryVo gdProjectQueryVo){
        String param = "";
        String typecode = gdProjectQueryVo.getTypecode();
        if(!StringUtils.isEmpty(typecode)){
            param += "typecode=" + typecode + "&";
        }
        String lancode = gdProjectQueryVo.getLancode();
        if(!StringUtils.isEmpty(lancode)){
            param += "lancode=" + lancode + "&";
        }
        return param.equals("") ? param : param.substring(0,param.length()-1);
    }
    
    //拼接不为空的排序参数值
    public String handlerOrderByParam(GdProjectQueryVo gdProjectQueryVo){
        String res = "";
        String orderBy = gdProjectQueryVo.getOrderBy();
        if(!StringUtils.isEmpty(orderBy)){
            res += "orderBy=" + orderBy;
        }
        return res;
    }

}
