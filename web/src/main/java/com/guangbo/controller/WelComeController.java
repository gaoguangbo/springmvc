package com.guangbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaoguangbo on 2017/5/15.
 */
@Controller
public class WelComeController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/publish")
    public String publish() {
        return "publish_news";
    }
}
