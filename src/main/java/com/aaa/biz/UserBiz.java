package com.aaa.biz;

import com.aaa.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/22 0022 15:47
 * @Version 1.0
 * 用户相关的业务方法
 */
public interface UserBiz {

    PageInfo<User> selectAllUser(int page, int limit);

    public List<User> showUserInfo(String loginName,String phonenumber,String status);

    User selectUserByUsername(String username);
    int insertSelective(User record);
    int delUserByID(List<String> ids);
    int updateByPrimaryKeySelective(User record);

    int updateUser(User user);

    User selectByPrimaryKey(int  userId);
}
