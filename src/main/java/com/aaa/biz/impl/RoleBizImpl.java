package com.aaa.biz.impl;



import com.aaa.biz.RoleBiz;
import com.aaa.dao.RoleMapper;
import com.aaa.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**

 * @Author: 陈建

 * @Date: 2020/5/29 0029 16:36

 * @Version 1.0

 */

@Service

public class RoleBizImpl implements RoleBiz {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    /**
     * 按照用户名查询用户信息
     *
     * @param username
     * @return
     */

    @Override
    public Role selectRoleByRolename(String username) {
        return roleMapper.selectRoleByRolename(username);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public int delRoleByID(List<String> ids) {
        return roleMapper.delRoleByID(ids);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Role> showRoleInfo(String roleName,String roleKey,String status ) {
        return roleMapper.selectRoleInfo(roleName,roleKey,status);
    }

}