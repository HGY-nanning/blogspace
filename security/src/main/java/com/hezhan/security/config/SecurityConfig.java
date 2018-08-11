package com.hezhan.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.spec.EncodedKeySpec;

/**
 * 安全配置类
 * Create by 何光义 on 2018/08/10 14:58
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    //自定义配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/index").permitAll()
                .antMatchers("/users/**").hasAnyRole("ADMIN")
                .and()
                .formLogin()
               .loginPage("/login").failureUrl("/login-error");
    }
    //认证信息管理
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder() {
        })   //在内存用初始化一个用户
                .withUser("hgy1712").password("123456").roles("ADMIN");
    }

}
