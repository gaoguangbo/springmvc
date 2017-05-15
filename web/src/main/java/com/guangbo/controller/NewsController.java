package com.guangbo.controller;

import com.guangbo.common.WebResult;
import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.service.INewsOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaoguangbo on 2017/5/10.
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsOperateService newsOperateService;

    @RequestMapping(value = "/publish", produces = "application/json;charset=UTF-8")
    public String publishNews(NewsInfo newsInfo) {
        newsOperateService.publish(newsInfo);
        return "index";
    }

    @RequestMapping("/getNewsById")
    public String getOneNews(Integer news_id, Model model) {
        NewsInfo news = newsOperateService.getNews(news_id);
        model.addAttribute("news", news);
        return "news_model";
    }

    @RequestMapping("/getNews")
    @ResponseBody
    public WebResult getNews(NewsInfo newsInfo,Integer pageNum,Integer pageSize) {
        WebResult webResult = new WebResult();
        webResult.setCode("01");
        webResult.setMsg("失败");
        webResult.setResult(newsOperateService.queryByPage(newsInfo, pageNum, pageSize));
        webResult.setCode("00");
        webResult.setMsg("成功");
        return webResult;
    }
}
