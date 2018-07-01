
package com.nap.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nap.entity.po.GdProject;
import com.nap.entity.result.Page;
import com.nap.entity.vo.GdProjectExtend;
import com.nap.entity.vo.GdProjectQueryVo;
import com.nap.mapper.GdProjectMapper;
import com.nap.mapper.extend.GdProjectMapperExtend;
import com.nap.service.IGdProjectService;
import com.nap.util.FileUtil;
import com.nap.util.OrderNumberUtil;

@Service
public class GdProjectService implements IGdProjectService {

    @Resource
    private GdProjectMapperExtend gdProjectMapperExtend;
    
    @Resource
    private GdProjectMapper gdProjectMapper;

    public Page<GdProjectExtend> queryByPage(Integer curPage, Integer pageSize, GdProjectQueryVo gdProjectQueryVo) {

        //非空验证
        gdProjectQueryVo = gdProjectQueryVo == null ? new GdProjectQueryVo() : gdProjectQueryVo;

        //设置 status为4，查询 已付完款的数据
        gdProjectQueryVo.setStatus("('0','1','2','3','4')");

        Page<GdProjectExtend> page = new Page<GdProjectExtend>();
        PageHelper.startPage(curPage, pageSize);
        List<GdProjectExtend> gdProjectExtends = gdProjectMapperExtend.query(gdProjectQueryVo);
        PageInfo<GdProjectExtend> pageInfo = new PageInfo<GdProjectExtend>(gdProjectExtends);

        page.setCurPage(curPage);
        page.setData(pageInfo.getList());
        page.setPageSize(pageSize);
        page.setTotalCount(pageInfo.getTotal());
        // 设置总页数
        Integer totalPage = (int)(page.getTotalCount() % pageSize == 0 ? page.getTotalCount() / pageSize
                : page.getTotalCount() / pageSize + 1);
        page.setTotalPage(totalPage);
        return page;
    }

    // 通过单号查找 (包括金额)
    @Override
    public GdProjectExtend queryByOrderNumber(String orderNumber) {
        GdProjectQueryVo vo = new GdProjectQueryVo();
        vo.setOrdernum(orderNumber);
        List<GdProjectExtend> projects = gdProjectMapperExtend.query(vo);
        if(projects != null && projects.size() == 1)
            return projects.get(0);
        return null;
    }

    //更新 
    public void update(GdProject project) {
        //校验
        if(project == null || StringUtils.isEmpty(project.getProjectId()))
            throw new RuntimeException("无效更新！");
        
        //校验 status为1 3 4不能更新
       GdProject tmp = gdProjectMapper.selectByPrimaryKey(project.getProjectId());
       String status = tmp.getStatus();
        if(status.equals("1") || status.equals("3") || status.equals("4"))
            throw new RuntimeException("此信息所处状态已无法更新！");
        
        BeanUtils.copyProperties(project, 
                    tmp,new String[]{"status","userId","ordernum","isanonymous","pflag","iscomment","committime"});
        gdProjectMapper.updateByPrimaryKey(tmp);
    }

    //插入项目信息
    public void insert(GdProject project) {
        //项目名不能为空
        if(StringUtils.isEmpty(project.getProjectname()))
            throw new RuntimeException("项目名称不能为空！");
        if(!StringUtils.isEmpty(project.getIsanonymous()) && StringUtils.isEmpty(project.getContactway()))
            throw new RuntimeException("请留下联系方式，便于联系！");
        //补全属性
        project.setOrdernum(OrderNumberUtil.createUniqueNumber());
        project.setCommittime(new Date());
        project.setStatus("0"); //状态默认为0 待审核
        project.setIscomment("0");//评论默认为0 未评论
        /*project.setTypecode("web");//暂且写死
        project.setLancode("java");
        project.setPflag("0");*/ //暂写死 所有人能看
        //需要根据isanonymous字段判断是否匿名
       /* if(StringUtils.isEmpty(project.getUserId()))
            project.setIsanonymous("0");//0匿名
        else
            project.setIsanonymous("1");*///1费匿名
        if(StringUtils.isEmpty(project.getIsanonymous()))
            project.setIsanonymous("1");
        gdProjectMapper.insert(project);
    }
    

    //通过id查询
    public GdProject findById(Integer projectId) {
        GdProject project = gdProjectMapper.selectByPrimaryKey(projectId);
        return project;
    }

    //更新
    public void updateForStatus(GdProject newProject) {
        gdProjectMapper.updateByPrimaryKeySelective(newProject);
    }

    //使用扩展mapper查询
    public GdProjectExtend findByIdUseExtend(Integer projectId) {
        
        return gdProjectMapperExtend.queryById(projectId);
    }

    //删除project，通过id
    public void deleteById(HttpServletRequest request, Integer id) {
        //删除关联的文档
        GdProject project = gdProjectMapper.selectByPrimaryKey(id);
        if(project == null)
            throw new RuntimeException("数据库中无对应记录！");
        
        String filepath = project.getFilepath();
        if(!StringUtils.isEmpty(filepath)){
            //删除对应文档
            boolean flag = FileUtil.deleteFile(request.getSession()
                    .getServletContext().getRealPath("/") + filepath);
            if(!flag){
                //记录日志
                System.out.println("文件删除失败：id:" + id + "，路径：" + filepath);
            }
        }
        //删除关联的金额信息
        //删除关联的支付信息
        //删除关联的评论信息
        //删除相关的进度信息
        //删除关联的浏览信息
        //mapper中执行多条语句
        gdProjectMapperExtend.deleteById(id);
    }

}
