package com.hezhan.security.web;

import com.hezhan.security.entity.User;
import com.hezhan.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by 何光义 on 2018/08/07 17:12
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    public List<User> userList(){
        return userService.findUserAll();
    }

    //获取所有用户列表
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userList());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    //根据id查询用户信息
    @GetMapping("{id}")
    public ModelAndView view(Model model,@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);

    }

    //获取form表单页面
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        Integer  ss = userService.saveOrUpdate(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userService.deleteUser(id);

        model.addAttribute("userList",userList());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
