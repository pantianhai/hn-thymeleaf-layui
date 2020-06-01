package com.aaa.dao;

import com.aaa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int  userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByUsername(String username);

    List<User> selectUserInfo(String loginName,String phonenumber,String status);

    List<User> selectUser( @Param("loginName")String loginName, @Param("phonenumber")String phonenumber, @Param("status")String status);

    int delUserByID( @Param("ids") List<String> ids);

    List<User> selectAllUser();

    int updateUser(String loginname,String email,String phonenumber,String password,String status);

    int updateUser(User user);
}

