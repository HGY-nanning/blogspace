package com.hezhan.security.service.Impl;

import com.hezhan.security.dao.UserMapper;
import com.hezhan.security.entity.User;
import com.hezhan.security.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by 何光义 on 2018/08/07 17:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    //添加或修改用户
    @Override
    public Integer saveOrUpdate(User user) {
        if (user.getId()!=null){
            return userMapper.updateByPrimaryKeySelective(user);
        }
        return userMapper.insert(user);
    }

    //根据id查询用户信息
    @Override
    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //获取所有用户列表
    @Override
    public List<User> findUserAll() {
        return userMapper.selectAll();
    }

    //删除用户
    @Override
    public Integer deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
