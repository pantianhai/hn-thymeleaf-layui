package com.aaa.biz;

import com.aaa.entity.Role;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:36
 * @Version 1.0
 */
public interface  RoleBiz {
   List<Role> selectAllRole();

   public Role selectRoleByRolename(String username);

   public int insertSelective(Role record);


   public int delRoleByID(List<String> ids);

   public int updateByPrimaryKeySelective(Role record);

   public List<Role> showRoleInfo(String roleName,String roleKey,String status );
}
