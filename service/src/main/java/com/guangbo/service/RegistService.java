package com.guangbo.service;

import com.guangbo.dao.entity.UserInfo;

import java.util.List;

/**
 * Created by MiaoJinlong on 2017/5/13.
 */
public interface RegistService {
    //得到所有已经注册的人信息
    public List<UserInfo> getUserNameList();

    //插入用户注册信息
    public void insertUserInfo(UserInfo userInfo);

    //根据用户名字和密码得到信息
    public List<UserInfo> getUserInfoByUserNameAndPass(UserInfo userInfo);

    //修改code
    public void updateByPrimaryKey(UserInfo userInfo);

    //根据id取经纬度
    public UserInfo getUserLatLngById(int userId);
}
