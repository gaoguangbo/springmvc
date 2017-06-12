package com.guangbo.service.impl;

import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.entity.NewsInfoExample;
import com.guangbo.dao.mapper.NewsInfoMapper;
import com.guangbo.dao.vo.PageInfoPO;
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
        NewsInfoExample example = new NewsInfoExample();
        NewsInfoExample.Criteria criteria = example.createCriteria();
        if (record.getId() != null) {
            criteria.andIdEqualTo(record.getId());
        }
        if (record.getAuthorId() != null) {
            criteria.andAuthorIdEqualTo(record.getAuthorId());
        }
        if (record.getIsCheck() != null) {
            criteria.andIsCheckEqualTo(record.getIsCheck());
        }
        if (record.getTypeId() != null) {
            criteria.andTypeIdEqualTo(record.getTypeId());
        }
        return newsInfoMapper.selectByExampleWithBLOBs(example);
    }

    public int update(NewsInfo record) {
        return newsInfoMapper.updateByPrimaryKeySelective(record);
    }

    public PageInfoPO<NewsInfo> queryByPage(NewsInfo record, int startLimit, int endLimit) {
        NewsInfoExample example = new NewsInfoExample();
        NewsInfoExample.Criteria criteria = example.createCriteria();
        if (record.getTypeId() != null) {
            criteria.andTypeIdEqualTo(record.getTypeId());
        }
        if (record.getIsCheck() != null) {
            criteria.andIsCheckEqualTo(record.getIsCheck());
        }
        if (record.getTitle() != null) {
            criteria.andTitleLike("%"+record.getTitle()+"%");
        }
        example.setPageNum(startLimit, endLimit);
        PageInfoPO<NewsInfo> res = new NewsInfoExample();
        res.setPageNum(startLimit, endLimit);
        res.setResults(newsInfoMapper.selectByExampleWithBLOBsByPage(example));
        return res;
    }

    public void publish(NewsInfo record) {
        newsInfoMapper.insertSelective(record);
    }

    public NewsInfo getNews(Integer news_id) {
        NewsInfo newsInfo = newsInfoMapper.selectByPrimaryKey(news_id);
        return newsInfo;
    }

    public void zan(Integer news_id) {
        NewsInfo newsInfo = new NewsInfo();
        newsInfo.setId(news_id);
        newsInfoMapper.zan(newsInfo);

    }

    public void zan(Integer news_id, boolean flag) {
        if (flag == false) {
            zan(news_id);
            return;
        }
        NewsInfo newsInfo = new NewsInfo();
        newsInfo.setId(news_id);
        newsInfoMapper.deZan(newsInfo);
    }
}
