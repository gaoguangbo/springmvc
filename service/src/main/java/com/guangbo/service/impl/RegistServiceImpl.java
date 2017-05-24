package com.guangbo.service.impl;

import com.guangbo.common.MailUtil;
import com.guangbo.dao.entity.UserInfo;
import com.guangbo.dao.entity.UserInfoExample;
import com.guangbo.dao.mapper.UserInfoMapper;
import com.guangbo.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MiaoJinlong on 2017/5/13.
 */
@Service
public class RegistServiceImpl implements RegistService {
    @Autowired
    UserInfoMapper userInfoMapper;
//     public Logger logger = Logger.getLogger(RegistServiceImpl.class);
    public List<UserInfo> getUserNameList() {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria cc = example.createCriteria();
//        logger.setLevel(Level.INFO);
//        logger.info("查询成功！！"+userInfoMapper.selectByExample(example));
        return userInfoMapper.selectByExample(example);
    }

    public void insertUserInfo(UserInfo userInfo) {
//        userInfoMapper.insertSelective(userInfo);
        try {
            MailUtil.sendTo("<a href = 'http://127.0.0.1:8080/regist/modifyCode?username="+userInfo.getUsername()+"'>激活帐号</a>",userInfo.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        userInfoMapper.insertSelective(userInfo);
//        logger.setLevel(Level.INFO);
//        logger.info("添加成功！！");
    }

    public List<UserInfo> getUserInfoByUserNameAndPass(UserInfo userInfo) {
        UserInfoExample example = new UserInfoExample();

        UserInfoExample.Criteria cc = example.createCriteria();
        cc.andUsernameEqualTo(userInfo.getUsername());
        cc.andPasswordEqualTo(userInfo.getPassword());

        return userInfoMapper.selectByExample(example);
    }

    public UserInfo getUserLatLngById(int userId){
        return userInfoMapper.selectByPrimaryKey(userId);
    }
    public void updateByPrimaryKey(UserInfo userInfo){
        UserInfoExample example = new UserInfoExample();

        UserInfoExample.Criteria cc = example.createCriteria();
        cc.andUsernameEqualTo(userInfo.getUsername());
        userInfo.setCode(1);
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }
}
