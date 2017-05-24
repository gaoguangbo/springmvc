package com.guangbo.controller;

import com.guangbo.dao.entity.UserInfo;
import com.guangbo.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by MiaoJinlong on 2017/5/13.
 */
@Controller
@RequestMapping("/regist")
public class RegistController {
    @Autowired
    RegistService registService;
    public  List<UserInfo> userInfos;

//    public Logger logger = Logger.getLogger(RegistController.class);
    @PostConstruct
    public void init() {
        userInfos = registService.getUserNameList();
    }

    @RequestMapping(value="/checkUserName" ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkUserName(String userName){

        String warnMsg = "该用户名可用";
        for (UserInfo userInfo : userInfos){
            if(userInfo.getUsername().equals(userName)) {
                warnMsg = "该用户名已经存在";
                break;
            }
        }
        return warnMsg;
    }

    @RequestMapping(value="/checkEmail",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkEmail(String email){
        String warnMsg = "该邮箱可用";
        for (UserInfo userInfo : userInfos){
            if(userInfo.getEmail().equals(email)) {
                warnMsg = "该邮箱已经注册过";
                return warnMsg;
            }
        }
        return warnMsg;
    }

    @RequestMapping("/insertUserInfo")
    public String insertUserInfo(UserInfo userInfo) {
        registService.insertUserInfo(userInfo);
        return "login";
    }

    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model, HttpServletRequest request){
        List<UserInfo> list = registService.getUserInfoByUserNameAndPass(userInfo);
        if(list.size() <= 0 || list == null){
            return "login";
        }
        UserInfo curUserInfo = list.get(0);
        if(curUserInfo.getCode() == 1){
            request.getSession().setAttribute("userId",list.get(0).getUserId());
            String msg = "登录成功！！！";
            model.addAttribute("msg",msg);
            model.addAttribute("userInfo",curUserInfo);
            //return "index";
            return "index";
        }
            String msg = "<a href = 'http://mail.163.com/'  target='_Blank'>"+curUserInfo.getEmail()+"</a>";
            model.addAttribute("msg","请先激活"+msg+"在登录");
            model.addAttribute("UserInfo",list.get(0));
            return "login";
    }

    @RequestMapping("/modifyCode")
    public String modifyCode(UserInfo userInfo, Model model, HttpServletRequest request){
        registService.updateByPrimaryKey(userInfo);
        return "login";
    }

    @RequestMapping("/modifylocal")
    public String modifyLocal(UserInfo userInfo){
        if(userInfo.getUserId() == null){
            return "login";
        }
        registService.updateByPrimaryKey(userInfo);
        return "index";
    }

}
