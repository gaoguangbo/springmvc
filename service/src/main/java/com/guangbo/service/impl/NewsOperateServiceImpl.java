package com.guangbo.service.impl;

import com.guangbo.dao.entity.NewsBackExample;
import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.entity.NewsInfoExample;
import com.guangbo.dao.mapper.NewsBackMapper;
import com.guangbo.dao.mapper.NewsInfoMapper;
import com.guangbo.dao.po.PageInfoPO;
import com.guangbo.service.INewsOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/10.
 */
@Service
public class NewsOperateServiceImpl implements INewsOperateService {
    @Autowired
    private NewsInfoMapper newsInfoMapper;

    public int insert(NewsInfo record) {
        return 0;
    }

    public int delete(NewsInfo record) {
        return 0;
    }

    public List<NewsInfo> query(NewsInfo record) {
        return null;
    }

    public int update(NewsInfo record) {
        return 0;
    }

    public PageInfoPO<NewsInfo> queryByPage(NewsInfo record, int startLimit, int endLimit) {
        NewsInfoExample example = new NewsInfoExample();
        NewsInfoExample.Criteria criteria = example.createCriteria();
        example.setPageNum(startLimit, endLimit);
        PageInfoPO<NewsInfo> res = new NewsInfoExample();
        res.setPageNum(startLimit, endLimit);
        res.setResults(newsInfoMapper.selectByExampleWithBLOBs(example));
        return res;
    }

    public void publish(NewsInfo record) {
        newsInfoMapper.insertSelective(record);
    }

    public NewsInfo getNews(Integer news_id) {
        NewsInfo newsInfo = newsInfoMapper.selectByPrimaryKey(news_id);
        return newsInfo;
    }
}
