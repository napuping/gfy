
package com.nap.service;

import com.nap.entity.po.GdUser;
import com.nap.entity.vo.GdUserQueryVo;

public interface IUserService {

    GdUser queryByUserAndPassword(GdUserQueryVo vo,boolean isEncry);
    
    Integer queryTotalNum();

    void save(GdUser user) throws Exception;

    GdUser queryUserByPhone(String mobile);
    
    GdUser isExistByUsername(String username);

    GdUser update(GdUser user);

    void updateHeader(Integer userId, String path);

}
