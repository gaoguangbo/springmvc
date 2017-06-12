package com.guangbo.service.impl;

import com.guangbo.dao.entity.NewsCheck;
import com.guangbo.dao.entity.NewsCheckExample;
import com.guangbo.dao.mapper.NewsCheckMapper;
import com.guangbo.dao.vo.PageInfoPO;
import com.guangbo.service.INewsShenheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoguangbo on 2017/6/11.
 */
@Service
public class NewsShenheServiceImpl implements INewsShenheService {
    @Autowired
    private NewsCheckMapper newsCheckMapper;

    public int insert(NewsCheck record) {
        return newsCheckMapper.insertSelective(record);
    }

    public int delete(NewsCheck record) {
        return 0;
    }

    public List<NewsCheck> queryByNewsIds(List<Integer> ids) {
        NewsCheckExample example = new NewsCheckExample();
        NewsCheckExample.Criteria criteria = example.createCriteria();
        if (ids == null || ids.size() == 0) {
            return new ArrayList<NewsCheck>();
        }
            criteria.andNewsIdIn(ids);
        List<NewsCheck> newsChecks = newsCheckMapper.selectByExample(example);
        return newsChecks;
    }
    public List<NewsCheck> query(NewsCheck record) {
        NewsCheckExample example = new NewsCheckExample();
        NewsCheckExample.Criteria criteria = example.createCriteria();
        if (record.getId() != null) {
            criteria.andIdEqualTo(record.getId());
        }
        if (record.getAuthorId() != null) {
            criteria.andAuthorIdEqualTo(record.getAuthorId());
        }
        if (record.getIsCheck() != null) {
            criteria.andIsCheckEqualTo(record.getIsCheck());
        }
        if (record.getNewsId() != null) {
            criteria.andNewsIdEqualTo(record.getNewsId());
        }
        if (record.getCheckUserId() != null) {
            criteria.andCheckUserIdEqualTo(record.getCheckUserId());
        }
        List<NewsCheck> newsChecks = newsCheckMapper.selectByExample(example);
        return newsChecks;
    }

    public int update(NewsCheck record) {
        return 0;
    }

    public PageInfoPO<NewsCheck> queryByPage(NewsCheck record, int startLimit, int endLimit) {
        return null;
    }
}
