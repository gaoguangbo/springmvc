package com.guangbo.controller;

import com.guangbo.common.WebResult;
import com.guangbo.dao.entity.NewsBack;
import com.guangbo.dao.po.PageInfoPO;
import com.guangbo.service.INewsBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by gaoguangbo on 2017/5/14.
 * 评论Controller
 */
@Controller
@RequestMapping("/comment")
public class NewBackController {
    @Autowired
    private INewsBackService newsBackService;
    /**
     * 对新闻评论
     */
    @RequestMapping("/repay/{type}")
    @ResponseBody
    public WebResult newsBack(Integer followId,Integer userId,String content,@PathVariable String type) {
        WebResult webResult = new WebResult();
        webResult.setCode("01");
        webResult.setMsg("失败");
        NewsBack newsBack = new NewsBack();
        if (ObjectUtils.isEmpty(followId)) {
            return webResult;
        }
        if (ObjectUtils.isEmpty(userId)) {
            return webResult;
        }
        if (ObjectUtils.isEmpty(content)) {
            return webResult;
        }
        newsBack.setUserId(userId);
        newsBack.setNewsId(followId);
        newsBack.setContent(content);
        if (type.equals("news")) {
            newsBack.setType((byte) 0);
        } else if (type.equals("back")) {
            newsBack.setType((byte) 1);
        }
        int i = newsBackService.insert(newsBack);
        if (i == 1) {
            webResult.setCode("00");
            webResult.setMsg("成功");
        }
        return webResult;
    }

    @RequestMapping("/get/{type}")
    @ResponseBody
    public WebResult getComment(Integer followId,Integer pageNum,Integer pageSize,@PathVariable String type) {
        WebResult webResult = new WebResult();
        webResult.setCode("01");
        webResult.setMsg("失败");
        NewsBack newsBack = new NewsBack();
        newsBack.setNewsId(followId);
        if (type.equals("news")) {
            newsBack.setType((byte) 0);
        } else if (type.equals("back")) {
            newsBack.setType((byte) 1);
        }
        PageInfoPO<NewsBack> newsBackPageInfoPO = newsBackService.queryByPage(newsBack, pageNum,pageSize);
        webResult.setResult(newsBackPageInfoPO.getResults());
        webResult.setCode("00");
        webResult.setMsg("成功");
        return webResult;
    }

}
