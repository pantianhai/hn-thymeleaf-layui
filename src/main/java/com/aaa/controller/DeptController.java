package com.aaa.controller;

import com.aaa.biz.DeptBiz;
import com.aaa.entity.Dept;
import com.aaa.entity.LayUiTable;
import com.aaa.util.MyConstants;
import com.aaa.util.ResultEntity;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



/**
 * @Author: 陈建
 * @Date: 2020/5/29 0029 16:27
 * @Version 1.0
 */

@Controller

public class DeptController {
    @Autowired
    private DeptBiz deptBiz;
    @RequestMapping("/dept/toShowDept")

    public String  toShowDept(){
        return "dept/showDept";
    }



    @RequestMapping("/dept/showDept")
    @ResponseBody
    public LayUiTable showDept() {
        //开始查询
        List<Dept> deptList = deptBiz.selectAllDept();

        LayUiTable layUiTable = new LayUiTable();

        layUiTable.setCode(0);

        layUiTable.setMsg("返回消息");

        layUiTable.setData(deptList);

        return layUiTable;

    }



//	根据关键字查询数据并且分页显示

    @RequestMapping("/show/dept")

    @ResponseBody

    public LayUiTable showDeptInfo(

            @RequestParam(value="page", defaultValue="1") Integer page,

            @RequestParam(value="limit", defaultValue="5") Integer limit,

            @RequestParam(value="status", defaultValue="-1") Integer status,

            @RequestParam(value="deptName", defaultValue="") String deptName

    ) {

        //开始查询

        PageInfo<Dept> pageInfo = deptBiz.showDeptInfo(page, limit,status,deptName);

        LayUiTable layUiTable = new LayUiTable();

        layUiTable.setCode(0);

        layUiTable.setMsg("返回消息");

        //设置分页之后的返回值

        layUiTable.setCount(pageInfo.getTotal());

        layUiTable.setData(pageInfo.getList());

        return layUiTable;

    }

    @RequestMapping("/add/dept")

    @ResponseBody

    public ResultEntity<Dept> addDept(Dept dept)

    {

        deptBiz.addDept(dept);

        return ResultEntity.successWithoutData();

    }



    @RequestMapping("/delete/dept")

    @ResponseBody

    public ResultEntity<Dept> deleteDept(@RequestParam(value="deptId")Integer deptId)

    {

        deptBiz.deleteDept(deptId);

        return ResultEntity.successWithoutData();

    }



    @RequestMapping("/delete/depts")

    @ResponseBody

    public ResultEntity<Dept> delUser(@RequestParam(value = "depts") String  depts){

        //将json字符串转换成list对象

        List<String> list= (List<String>) JSON.parse(depts);

        int i = deptBiz.delDeptsByID(list);

        if(i>0){

            return ResultEntity.successWithoutData();

        }else {

            return ResultEntity.failed(MyConstants.delFailMsg);

        }

    }



    @RequestMapping("/update/dept")

    @ResponseBody

    public ResultEntity<Dept> updateDept(Dept dept)

    {

        deptBiz.updateDept(dept);

        return ResultEntity.successWithoutData();

    }

}