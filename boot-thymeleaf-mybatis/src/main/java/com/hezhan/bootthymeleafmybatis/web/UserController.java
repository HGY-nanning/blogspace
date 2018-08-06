package com.hezhan.bootthymeleafmybatis.web;

import com.hezhan.bootthymeleafmybatis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Create by 何光义 on 2018/08/06 11:15
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userService.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }
}
