package com.guangbo.controller;

import com.guangbo.common.WebResult;
import com.guangbo.dao.entity.UserInfo;
import com.guangbo.service.IUserInfoService;
import com.guangbo.service.RegistService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by MiaoJinlong on 2017/5/13.
 */
@Controller
@RequestMapping("/regist")
public class RegistController {
    @Autowired
    private  RegistService registService;
    @Autowired
    private IUserInfoService userInfoService;

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
            request.getSession().setAttribute("user",list.get(0));
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

    @RequestMapping("/useredit")
    public Object userEdit(UserInfo userInfo, @RequestParam("file") MultipartFile file) {
        WebResult result = new WebResult();
        result.setCode("00");
        result.setMsg("成功");
        String uploadDir = "/Users/gaoguangbo/Documents/java/springmvc/web/src/main/webapp/imagesup";
        String resDir = "../../imagesup/";
        if(!file.isEmpty()){
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadDir,
                        file.getOriginalFilename()));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //头像地址
        String iconStr = resDir  + file.getOriginalFilename();
        userInfo.setIcon(iconStr);
        int i = userInfoService.update(userInfo);
        if (i == 0) {
            result.setCode("01");
            result.setMsg("失败");
        }
        return result;
    }

}
