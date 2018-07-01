
package com.nap.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nap.entity.po.GdComment;
import com.nap.entity.po.GdProject;
import com.nap.entity.result.Page;
import com.nap.entity.vo.GdCommentExtend;
import com.nap.entity.vo.GdCommentQueryVo;
import com.nap.mapper.GdCommentMapper;
import com.nap.mapper.GdProjectMapper;
import com.nap.mapper.extend.GdCommentMapperExtend;
import com.nap.service.IGdCommentService;

@Service
public class GdCommentService implements IGdCommentService{
    
    @Resource
    private GdCommentMapperExtend commentMapperExtend;
    
    @Resource
    private GdCommentMapper commentMapper;
    
    @Resource
    private GdProjectMapper gdProjectMapper;
    
    //获取project下的所有评论
    public long countComments(Integer projectId){
        return commentMapperExtend.countByProjectId(projectId);
    }
    
    //得到分页父评论
    public Page<GdCommentExtend> getParentComment(GdCommentQueryVo vo,int curPage,int pageSize){
        if(StringUtils.isEmpty(vo.getOrderBy()))
            vo.setOrderBy("commenttime desc");//默认按时间降序
        
        //得到分页数据
        PageHelper.startPage(curPage, pageSize);
        List<GdCommentExtend> comments = commentMapperExtend.selectByPidOne(vo);
       
        PageInfo<GdCommentExtend> tpage = new PageInfo<GdCommentExtend>(comments);
        //创建page分页封装类
        Page<GdCommentExtend> page = new Page<GdCommentExtend>();
        page.setCurPage(curPage);
        page.setPageSize(pageSize);
        page.setTotalCount(tpage.getTotal());
        page.setTotalPage(tpage.getPages());
        //处理分页数据，得到父评论下的 第一页 的子评论
        for(GdCommentExtend comment : comments){
            Page<GdCommentExtend> subPage = getSubComment(1, 5, comment.getCommentId());
            comment.setSubPage(subPage);
        }
        page.setData(comments);
        return page;
    }
    
    //获取某一父评论下的所有子评论
    public Page<GdCommentExtend> getSubComment(int curPage,int pageSize,Integer parentId){
        List<GdCommentExtend> comments = new ArrayList<GdCommentExtend>();
        getSubCommentProcess(comments,parentId);//递归查找所有子评论
        
        Page<GdCommentExtend> page = new Page<GdCommentExtend>();
        page.setCurPage(curPage);
        page.setPageSize(pageSize);
        page.setTotalCount((long)comments.size());
        //计算总页数
        int tpage = comments.size() % pageSize == 0 ?  comments.size()/pageSize : comments.size()/pageSize + 1;
        page.setTotalPage(tpage);
        
        //从comments中取对应页数据
        List<GdCommentExtend> data = new ArrayList<GdCommentExtend>();
        if(comments.size() > 0){
            int start = (curPage - 1)*pageSize;
            int end = (curPage - 1)*pageSize + pageSize;
            end = end >= comments.size() ? comments.size() : end;
            for(int i = start; i < end; i++){
                data.add(comments.get(i));
            }
        }
        page.setData(data);
        return page;
    }
    //递归查找所有子评论
    private void getSubCommentProcess(List<GdCommentExtend> comments, Integer parentId) {
        List<GdCommentExtend> tmp = commentMapperExtend.selectByPidCascade(parentId);
        if(tmp != null && tmp.size() > 0){
            for(GdCommentExtend comment : tmp){
                comments.add(comment);
                getSubCommentProcess(comments, comment.getCommentId());
            }
        }
    }

    //插入评论
    public void insert(GdComment comment) {
        //插入后检测该项目信息里的iscomment字段是否更新为1 若无则置为1
        commentMapper.insert(comment);
        GdProject project = gdProjectMapper.selectByPrimaryKey(comment.getProjectId());
        if(project.getIscomment().equals("0")){
            GdProject tmp = new GdProject();
            tmp.setProjectId(comment.getProjectId());
            tmp.setIscomment("1");
            gdProjectMapper.updateByPrimaryKeySelective(tmp);
        }
    }

    //回复
    public void reply(GdComment comment) {
        if(StringUtils.isEmpty(comment.getParentId()) || StringUtils.isEmpty(comment.getContent()))
            throw new RuntimeException("数据不合法！");
        comment.setCommenttime(new Date());
         commentMapper.insert(comment);
       
    }

}
