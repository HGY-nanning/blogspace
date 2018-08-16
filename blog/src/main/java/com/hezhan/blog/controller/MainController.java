package com.hezhan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 * Create by 何光义 on 2018/08/16 21:15
 */
@Controller
public class MainController {

    //访问跟路径重点向到index
    @GetMapping("/")
    public String root(){
        return "redirect:index";
    }

    //访问index跳转到index.html
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //登录页面
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //登录错误
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登陆失败,用户名或密码错误");
        return "login";
    }

    //注册页面
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}