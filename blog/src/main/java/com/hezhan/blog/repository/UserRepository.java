package com.hezhan.blog.repository;

import com.hezhan.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by 何光义 on 2018/08/24 10:48
 */
public interface UserRepository extends JpaRepository<User,Long> {
}

