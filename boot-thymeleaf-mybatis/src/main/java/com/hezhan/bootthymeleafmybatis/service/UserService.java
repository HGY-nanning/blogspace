package com.hezhan.bootthymeleafmybatis.service;

import com.hezhan.bootthymeleafmybatis.entity.User;

import java.util.List;

/**
 * Create by 何光义 on 2018/08/06 11:04
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer saveUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取所有用户的列表
     * @return
     */
    List<User> listUser();
}
