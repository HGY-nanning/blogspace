package com.hezhan.security.service;

import com.hezhan.security.entity.User;

import java.util.List;

/**
 * Create by 何光义 on 2018/08/07 16:35
 */
public interface UserService {

    /**
     * 创建用户或修改用户信息
     * @param user 用户信息
     * @return 受影响的行数
     */
    Integer saveOrUpdate(User user);

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User findUserById(Long id);

    /**
     * 获取所有用户列表
     * @return 受影响的行数
     */
    List<User> findUserAll();

    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 受影响的行数
     */
    Integer deleteUser(Long id);
}
