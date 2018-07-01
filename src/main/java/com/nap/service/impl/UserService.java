
package com.nap.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.nap.entity.po.GdUser;
import com.nap.entity.po.GdUserExample;
import com.nap.entity.po.GdUserExample.Criteria;
import com.nap.entity.vo.GdUserQueryVo;
import com.nap.mapper.GdUserMapper;
import com.nap.service.IUserService;
import com.nap.util.RegexUtil;

@Service
public class UserService implements IUserService {

    @Resource
    private GdUserMapper gdUserMapper;

    @Override
    public GdUser queryByUserAndPassword(GdUserQueryVo vo, boolean isEncry) {

        // 非空验证
        vo = vo == null ? new GdUserQueryVo() : vo;

        if(StringUtils.isEmpty(vo.getUsername()) || StringUtils.isEmpty(vo.getPassword()))
            return null;

        // 判断是否需要加密
        String password = isEncry ? DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()) : vo.getPassword();

        GdUserExample example = new GdUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(vo.getUsername());
        criteria.andPasswordEqualTo(password);

        List<GdUser> users = gdUserMapper.selectByExample(example);

        if(users != null && users.size() == 1)
            return users.get(0);

        return null;
    }

    // 获取总人数
    public Integer queryTotalNum() {
        return gdUserMapper.countByExample(null);
    }

    // 查找用户是否存在
    public GdUser isExistByUsername(String username) {
        if(StringUtils.isEmpty(username))
            return null;
        GdUserExample example = new GdUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<GdUser> users = gdUserMapper.selectByExample(example);

        if(users != null && users.size() == 1)
            return users.get(0);
        return null;
    }

    // 保存
    public void save(GdUser user) throws Exception {
        user = user == null ? new GdUser() : user;
        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())
                || StringUtils.isEmpty(user.getPhone()))
            throw new RuntimeException("必填项为空！");
        if(isExistByUsername(user.getUsername()) != null)
            throw new RuntimeException("该用户名已经存在！");
        if(!RegexUtil.checkPhone(user.getPhone()))
            throw new RuntimeException("手机号格式不正确！");
        if(queryUserByPhone(user.getPhone()) != null)
            throw new RuntimeException("您已注册过了，请登录！");
        // 补全属性
        user.setRegistertime(new Date());
        user.setSflag("0");
        //密码加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        
        gdUserMapper.insertSelective(user);
    }

    @Override
    public GdUser queryUserByPhone(String mobile) {
        if(StringUtils.isEmpty(mobile))
            return null;
        GdUserExample example = new GdUserExample();
        Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(mobile);
        List<GdUser> users = gdUserMapper.selectByExample(example);
        if(users != null && users.size() == 1)
            return users.get(0);
        return null;
    }
    
    //更新
    public GdUser update(GdUser user) {
        if(StringUtils.isEmpty(user.getUserId()))
            throw new RuntimeException("数据不合法！");
        //验证
        GdUser usertmp = gdUserMapper.selectByPrimaryKey(user.getUserId());
        if(usertmp == null)
            throw new RuntimeException("数据库无此记录");
        //更新
        gdUserMapper.updateByPrimaryKey(user);
        return gdUserMapper.selectByPrimaryKey(user.getUserId());
    }

    @Override
    public void updateHeader(Integer userId, String path) {
        GdUser tmp = gdUserMapper.selectByPrimaryKey(userId);
        if(tmp == null)
            throw new RuntimeException("用户不存在!");
        GdUser user = new GdUser();
        user.setUserId(userId);
        user.setHpath(path);
        gdUserMapper.updateByPrimaryKeySelective(user);
    }

}
