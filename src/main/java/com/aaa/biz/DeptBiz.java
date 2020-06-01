package com.aaa.biz;

import com.aaa.entity.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:36
 * @Version 1.0
 */
public interface DeptBiz {
   List<Dept> selectAllDept();
   PageInfo<Dept> showDeptInfo(int page, int limit,int status,String deptName);

   void addDept(Dept dept);
   void deleteDept(Integer deptID);
   void updateDept(Dept dept);

   int delDeptsByID(List<String> list);
}
