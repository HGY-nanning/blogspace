package com.hezhan.bootstratp_thymeleaf.entity;

/**
 * 实体类
 * Create by 何光义 on 2018/07/31 11:48
 */
public class User {
    private long id; // 用户的唯一标识
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
