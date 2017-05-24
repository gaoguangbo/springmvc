package com.guangbo.dao.mapper;

import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.entity.NewsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsInfoMapper {
    int countByExample(NewsInfoExample example);

    int deleteByExample(NewsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewsInfo record);

    int insertSelective(NewsInfo record);

    List<NewsInfo> selectByExampleWithBLOBs(NewsInfoExample example);

    List<NewsInfo> selectByExampleWithBLOBsByPage(NewsInfoExample example);

    List<NewsInfo> selectByExample(NewsInfoExample example);

    NewsInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewsInfo record, @Param("example") NewsInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsInfo record, @Param("example") NewsInfoExample example);

    int updateByExample(@Param("record") NewsInfo record, @Param("example") NewsInfoExample example);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKeyWithBLOBs(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);

    int zan(NewsInfo record);

    int deZan(NewsInfo record);
}