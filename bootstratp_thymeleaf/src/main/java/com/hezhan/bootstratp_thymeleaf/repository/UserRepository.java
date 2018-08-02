package com.hezhan.bootstratp_thymeleaf.repository;

import com.hezhan.bootstratp_thymeleaf.entity.User;

import java.util.List;

/**
 * Create by 何光义 on 2018/07/31 21:52
 */
public interface UserRepository {
    /**
     * 新增或者修改用户
     * @param user
     * @return
     */
    User saveOrUpateUser(User user);

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
