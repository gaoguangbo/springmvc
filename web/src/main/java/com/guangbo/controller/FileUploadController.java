package com.guangbo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by gaoguangbo on 2017/5/12.
 */
@Controller
public class FileUploadController {
    @RequestMapping(value = "/upload",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false)MultipartFile file, ModelMap model) {
        String uploadDir = "/Users/gaoguangbo/Documents/java/springmvc/web/src/main/webapp/imagesup";
        if(!file.isEmpty()){
            try {
                //这里将上传得到的文件保存至 d:\\temp\\file 目录
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadDir,
                        file.getOriginalFilename()));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "http://localhost:8080/imagesup/"+ file.getOriginalFilename();
    }
}
