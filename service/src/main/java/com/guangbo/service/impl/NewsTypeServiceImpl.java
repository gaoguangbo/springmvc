package com.guangbo.service.impl;

import com.guangbo.dao.entity.NewsType;
import com.guangbo.dao.entity.NewsTypeExample;
import com.guangbo.dao.mapper.NewsTypeMapper;
import com.guangbo.dao.vo.PageInfoPO;
import com.guangbo.service.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/17.
 */
@Service
public class NewsTypeServiceImpl implements INewsTypeService {

    @Autowired
    private NewsTypeMapper newsTypeMapper;

    public int insert(NewsType record) {
        return 0;
    }

    public int delete(NewsType record) {
        return 0;
    }

    public List<NewsType> query(NewsType record) {
        NewsTypeExample example = new NewsTypeExample();
        NewsTypeExample.Criteria criteria = example.createCriteria();
        return newsTypeMapper.selectByExample(example);
    }

    public int update(NewsType record) {
        return 0;
    }

    public PageInfoPO<NewsType> queryByPage(NewsType record, int startLimit, int endLimit) {
        return null;
    }
}
