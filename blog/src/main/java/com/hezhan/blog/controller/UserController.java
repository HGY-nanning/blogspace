package com.hezhan.blog.controller;

import com.hezhan.blog.entity.User;
import com.hezhan.blog.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 用户控制器
 * Create by 何光义 on 2018/08/20 09:32
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserRepository userRepository;

    /**
     * 查看用户信息
     * @param model 绑定用户数据
     * @return  用户列表
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","查看用户");
        return new ModelAndView("/users/list","userModel",model);
    }

    /**
     * 根据id查询用户信息
     * @param id  用户id
     * @param model 绑定用户数据
     * @return 用户列表
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id")Long id, Model model){
        Optional<User> u = userRepository.findById(id);
        User user = u.get();
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户信息");
        return new ModelAndView("users/view","userModel",model);
    }

    //获取form表单页面
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null,null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    //创建用户
    @PostMapping
    public ModelAndView createUser(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:users");
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return 用户列表
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteById(id);

        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     * @param id 用户id
     * @param model 绑定用户数据
     * @return 用户信息
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        Optional<User> u = userRepository.findById(id);
        User user = u.get();

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
