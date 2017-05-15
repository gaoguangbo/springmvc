package com.guangbo.service;


import com.guangbo.dao.entity.NewsInfo;

/**
 * Created by gaoguangbo on 2017/5/10.
 */
public interface INewsOperateService extends IBaseService<NewsInfo> {

    void publish(NewsInfo record);

    NewsInfo getNews(Integer news_jd);
}
