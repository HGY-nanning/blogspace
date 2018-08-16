package com.hezhan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页控制器
 * Create by 何光义 on 2018/08/16 21:43
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {

    /**
     * 用户主页
     * @param username 用户名
     * @return 用户主页
     */
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username")String username){
        return "/userspace/u";

    }

    /**
     * 搜索获取用户博客列表
     * @param username  用户名
     * @param order  默认是最新排序
     * @param category  搜索博客分类
     * @param keyword  搜索关键字
     * @return 用户博客列表
     */
    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username")String username,
                                   @RequestParam(value = "order",required = false,defaultValue = "new")String order,
                                   @RequestParam(value = "category",required = false)Long category,
                                   @RequestParam(value = "keyword")String keyword){

        if (category!=null){
            return "/userspace/u";
        }else if(keyword!=null){
            return "/userspace/u";
        }
        return "/userspace/u";
    }

    /**
     *  进入博客
     * @param id  博客id
     * @return 博客
     */
    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id")Long id){
        return "/userspace/blog";
    }

    /**
     * 编辑博客
     * @return 编辑页面
     */
    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
        return "/userspace/blogedit";
    }
}
