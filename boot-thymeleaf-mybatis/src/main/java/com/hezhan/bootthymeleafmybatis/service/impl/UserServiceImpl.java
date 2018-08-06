package com.hezhan.bootthymeleafmybatis.service.impl;

import com.hezhan.bootthymeleafmybatis.dao.UserMapper;
import com.hezhan.bootthymeleafmybatis.entity.User;
import com.hezhan.bootthymeleafmybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by 何光义 on 2018/08/06 11:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Integer saveUser(User user) {
        if(user.getId()!=null){
            return updateUser(user);
        }
        return userMapper.insertSelective(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> listUser() {
        return userMapper.selectAll();
    }
}
