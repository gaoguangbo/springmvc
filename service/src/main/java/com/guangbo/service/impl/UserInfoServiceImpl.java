package com.guangbo.service.impl;

import com.guangbo.dao.entity.UserInfo;
import com.guangbo.dao.entity.UserInfoExample;
import com.guangbo.dao.mapper.UserInfoMapper;
import com.guangbo.dao.vo.PageInfoPO;
import com.guangbo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/24.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public int insert(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    public int delete(UserInfo record) {
        return 0;
    }

    public List<UserInfo> query(UserInfo record) {
        return null;
    }

    public int update(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }
    public int updatePassWord(int userId, String oldPassword, String newPassword) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(oldPassword);
        criteria.andUserIdEqualTo(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(newPassword);
        return userInfoMapper.updateByExampleSelective(userInfo,example);
    }
    public PageInfoPO<UserInfo> queryByPage(UserInfo record, int startLimit, int endLimit) {
        return null;
    }
}
