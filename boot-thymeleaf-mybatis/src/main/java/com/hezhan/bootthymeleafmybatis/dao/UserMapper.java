package com.hezhan.bootthymeleafmybatis.dao;

import com.hezhan.bootthymeleafmybatis.entity.User;

import java.util.List;

public interface UserMapper {
    Integer deleteByPrimaryKey(Long id);

    Integer insert(User record);

    Integer insertSelective(User record);

    User selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(User record);

    Integer updateByPrimaryKey(User record);

    List<User> selectAll();
}