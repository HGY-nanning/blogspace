package com.hezhan.bootstratp_thymeleaf.repository;

import com.hezhan.bootstratp_thymeleaf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Create by 何光义 on 2018/07/31 21:53
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    //保证id是唯一性的,计数的
    private static AtomicLong counte = new AtomicLong();
    //存储用户信息
    private final ConcurrentMap<Long,User> usermap = new ConcurrentHashMap<>();

    //添加或者修改用户
   @Override
    public User saveOrUpateUser(User user) {
        Long id = user.getId();
        if (id <=0){
            //返回一个自增的long值
            id = counte.incrementAndGet();
            user.setId(id);
        }
        this.usermap.put(id,user);
        return user;
    }
    //删除用户
    @Override
    public void deleteUser(Long id) {
        this.usermap.remove(id);
    }

    //根据id获取用户信息
    @Override
    public User getUserById(Long id) {
        return this.usermap.get(id);
    }

    //获取所有用户
    @Override
    public List<User> listUser() {
        return new ArrayList<User>(this.usermap.values());
    }
}
