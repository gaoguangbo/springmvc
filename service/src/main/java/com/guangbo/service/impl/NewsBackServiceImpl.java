package com.guangbo.service.impl;

import com.guangbo.dao.entity.NewsBack;
import com.guangbo.dao.entity.NewsBackExample;
import com.guangbo.dao.mapper.NewsBackMapper;
import com.guangbo.dao.po.PageInfoPO;
import com.guangbo.service.INewsBackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/14.
 * 新闻评论 、 评论回帖服务
 */
public class NewsBackServiceImpl implements INewsBackService {
    @Autowired
    private NewsBackMapper newsBackMapper;

    public int insert(NewsBack record) {
        return newsBackMapper.insertSelective(record);
    }

    public int delete(NewsBack record) {
        return 0;
    }

    public List<NewsBack> query(NewsBack record) {
        NewsBackExample example = new NewsBackExample();
        NewsBackExample.Criteria criteria = example.createCriteria();
        if (record.getId() != null) {
            criteria.andIdEqualTo(record.getId());
        }
        if (record.getId() != null) {
            criteria.andUserIdEqualTo(record.getId());
        }
        return newsBackMapper.selectByExample(example);
    }

    public int update(NewsBack record) {
        return 0;
    }

    public PageInfoPO<NewsBack> queryByPage(NewsBack record, int startLimit, int endLimit) {
        return null;
    }
}
