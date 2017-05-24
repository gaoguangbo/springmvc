package com.guangbo.controller;

import com.guangbo.dao.entity.NewsType;
import com.guangbo.service.impl.NewsTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/15.
 */
@Controller
public class WelComeController {
    @Autowired
    private NewsTypeServiceImpl newsTypeService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping("/publish")
    public String publish(Model model) {
        List<NewsType> list = newsTypeService.query(new NewsType());
        model.addAttribute("types", list);
        return "publish_news";
    }

    @RequestMapping("/regist")
    public String regist() {
        return "regist";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}