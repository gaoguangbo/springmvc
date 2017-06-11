package com.guangbo.dao.mapper;

import com.guangbo.dao.entity.NewsBack;
import com.guangbo.dao.entity.NewsBackExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NewsBackMapper {
    int countByExample(NewsBackExample example);

    int deleteByExample(NewsBackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsBack record);

    int insertSelective(NewsBack record);

    List<NewsBack> selectByExampleWithBLOBs(NewsBackExample example);

    List<NewsBack> selectByExample(NewsBackExample example);

    NewsBack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsBack record, @Param("example") NewsBackExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsBack record, @Param("example") NewsBackExample example);

    int updateByExample(@Param("record") NewsBack record, @Param("example") NewsBackExample example);

    int updateByPrimaryKeySelective(NewsBack record);

    int updateByPrimaryKeyWithBLOBs(NewsBack record);

    int updateByPrimaryKey(NewsBack record);

    List<NewsBack> selectByExampleByPage(NewsBackExample examples);
}