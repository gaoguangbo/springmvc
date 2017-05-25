package com.guangbo.service;

import com.guangbo.dao.entity.UserInfo;

/**
 * Created by gaoguangbo on 2017/5/24.
 */
public interface IUserInfoService extends IBaseService<UserInfo> {
     int updatePassWord(int userId, String oldPassword, String newPassword) ;
}
