package com.guangbo.controller;

import com.guangbo.dao.entity.NewsType;
import com.guangbo.service.impl.NewsTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/17.
 */
@RequestMapping("/type")
public class NewTypeController {
    @Autowired
    private NewsTypeServiceImpl newsTypeService;
    @RequestMapping("/get")
    @ResponseBody
    public Object getTypes() {
        List<NewsType> query = newsTypeService.query(new NewsType());
        return query;
    }
}
