package com.guangbo.service;

import com.guangbo.dao.entity.NewsCheck;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/6/11.
 */
public interface INewsShenheService extends IBaseService<NewsCheck>{

    public List<NewsCheck> queryByNewsIds(List<Integer> ids);
}
