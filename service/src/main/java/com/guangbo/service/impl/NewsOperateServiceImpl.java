package com.guangbo.service.impl;

import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.mapper.NewsInfoMapper;
import com.guangbo.service.INewsOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaoguangbo on 2017/5/10.
 */
@Service
public class NewsOperateServiceImpl implements INewsOperateService {
    @Autowired
    private NewsInfoMapper newsInfoMapper;
    public void publish(NewsInfo record) {
        newsInfoMapper.insert(record);
    }

    public NewsInfo getNews(Integer news_id) {
        NewsInfo newsInfo = newsInfoMapper.selectByPrimaryKey(news_id);
        return newsInfo;
    }
}
