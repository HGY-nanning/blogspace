package com.hezhan.bootthymeleafmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hezhan.bootthymeleafmybatis.dao")
public class BootThymeleafMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootThymeleafMybatisApplication.class, args);
	}
}
