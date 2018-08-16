package com.hezhan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * blogs控制器
 * Create by 何光义 on 2018/08/16 21:31
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {


    /**
     * 获取博客列表
     * @param order  默认按最新排序
     * @param keyword  搜索关键字
     * @return
     */
    @GetMapping
    public String listBlogs(@RequestParam(value = "order",required = false,defaultValue = "new")String order,
                            @RequestParam(value = "keyword",required = false,defaultValue = "") String keyword){
        return "redirect:/index?order="+order+"&keyword"+keyword;
    }
}
