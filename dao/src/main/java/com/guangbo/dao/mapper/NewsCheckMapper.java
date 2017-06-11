package com.guangbo.dao.mapper;

import com.guangbo.dao.entity.NewsCheck;
import com.guangbo.dao.entity.NewsCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsCheckMapper {
    int countByExample(NewsCheckExample example);

    int deleteByExample(NewsCheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsCheck record);

    int insertSelective(NewsCheck record);

    List<NewsCheck> selectByExample(NewsCheckExample example);

    NewsCheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsCheck record, @Param("example") NewsCheckExample example);

    int updateByExample(@Param("record") NewsCheck record, @Param("example") NewsCheckExample example);

    int updateByPrimaryKeySelective(NewsCheck record);

    int updateByPrimaryKey(NewsCheck record);
}