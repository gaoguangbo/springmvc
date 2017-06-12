package com.guangbo.dao.vo;

import com.guangbo.dao.entity.NewsCheck;
import com.guangbo.dao.entity.NewsInfo;

import java.util.Date;

/**
 * Created by gaoguangbo on 2017/6/11.
 */
public class NewsShenheVo {
    private Integer id;

    private Integer authorId;

    private String title;

    private Integer typeId;

    private Integer regionId;

    private String keywords;

    private Integer clicktimes;

    private Integer repaytimes;

    private String picUrl;

    private Byte isCheck;

    private Date createTime;

    private String content;

    private Integer checkUserId;

    private String checkContent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getClicktimes() {
        return clicktimes;
    }

    public void setClicktimes(Integer clicktimes) {
        this.clicktimes = clicktimes;
    }

    public Integer getRepaytimes() {
        return repaytimes;
    }

    public void setRepaytimes(Integer repaytimes) {
        this.repaytimes = repaytimes;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public NewsShenheVo() {
    }
    public NewsShenheVo(NewsInfo newsInfo) {
        this.id = newsInfo.getId();
        this.authorId = newsInfo.getAuthorId();
        this.title = newsInfo.getTitle();
        this.typeId = newsInfo.getTypeId();
        this.regionId = newsInfo.getRegionId();
        this.keywords = newsInfo.getKeywords();
        this.clicktimes = newsInfo.getClicktimes();
        this.repaytimes = newsInfo.getRepaytimes();
        this.picUrl = newsInfo.getPicUrl();
        this.content = newsInfo.getContent();
        this.createTime = newsInfo.getCreateTime();
    }
    public NewsShenheVo(NewsInfo newsInfo, NewsCheck newsCheck) {
        this.id = newsInfo.getId();
        this.authorId = newsInfo.getAuthorId();
        this.title = newsInfo.getTitle();
        this.typeId = newsInfo.getTypeId();
        this.regionId = newsInfo.getRegionId();
        this.keywords = newsInfo.getKeywords();
        this.clicktimes = newsInfo.getClicktimes();
        this.repaytimes = newsInfo.getRepaytimes();
        this.createTime = newsInfo.getCreateTime();
        this.picUrl = newsInfo.getPicUrl();
        this.isCheck = newsCheck.getIsCheck();
        this.content = newsInfo.getContent();
        this.checkUserId = newsCheck.getCheckUserId();
        this.checkContent = newsCheck.getCheckContent();
    }

    public void setCheck(NewsCheck newsCheck) {
        this.isCheck = newsCheck.getIsCheck();
        this.checkUserId = newsCheck.getCheckUserId();
        this.checkContent = newsCheck.getCheckContent();
    }
}
