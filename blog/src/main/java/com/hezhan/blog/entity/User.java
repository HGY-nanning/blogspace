package com.hezhan.blog.entity;

import javax.persistence.*;

/**
 * Create by 何光义 on 2018/08/24 10:41
 */
@Entity
public class User {

    @Id  // 主键
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 自增长策略
    private Long id;
    @Column(nullable = false) // 映射为字段，值不能为空
    private String name;
    @Column(nullable = false) // 映射为字段，值不能为空
    private Integer age;

    protected User() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
