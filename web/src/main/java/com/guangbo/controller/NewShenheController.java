package com.guangbo.controller;

import com.guangbo.common.WebResult;
import com.guangbo.dao.entity.NewsCheck;
import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.vo.NewsShenheVo;
import com.guangbo.dao.vo.PageInfoPO;
import com.guangbo.service.INewsOperateService;
import com.guangbo.service.INewsShenheService;
import com.guangbo.service.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gaoguangbo on 2017/6/11.
 */
@Controller
@RequestMapping("/newsshenhe")
public class NewShenheController {
    @Autowired
    private INewsOperateService iNewsOperateService;
    @Autowired
    private INewsShenheService iNewsShenheService;



    /**
     * 查询审核帖子
     * @param type
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public Object get(Integer type,Integer pageSize,Integer pageNum,String title) {
        if (pageNum == null || pageNum < 1) {
            pageNum =1;
        }
        if (pageSize == null || pageSize < 10) {
            pageSize = 10;
        }
        if (type == 0) {
            type =null;
        }

        NewsInfo newsInfo = new NewsInfo();
        newsInfo.setTypeId(type);
        newsInfo.setTitle(title);
        PageInfoPO<NewsInfo> newsInfoPageInfoPO = iNewsOperateService.queryByPage(newsInfo, pageNum, pageSize);
        List<NewsInfo> newsInfos = newsInfoPageInfoPO.getResults();
        List<Integer> newsIds = newsInfos.stream().map(e -> e.getId()).collect(Collectors.toList());
        List<NewsCheck> newsChecks = iNewsShenheService.queryByNewsIds(newsIds);
        /**
         * 组装新闻  和  审核
         */
        List<NewsShenheVo> list = new ArrayList<>();
        for(NewsInfo e: newsInfos) {
            NewsShenheVo temp = new NewsShenheVo(e);
            list.add(temp);
            for (NewsCheck f : newsChecks) {
                if (e.getId() == f.getNewsId()) {
                    temp.setCheck(f);
                    newsChecks.remove(f);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 添加审核
     *
     * @return
     */
    @RequestMapping("/put")
    @ResponseBody
    public Object put(NewsCheck record) {
        WebResult result = new WebResult();
        result.setCode("01");
        result.setMsg("错误");
        if (record.getNewsId() == null) {
            return result;
        }
        if (record.getCheckUserId() == null) {
            return result;
        }
        int insert = iNewsShenheService.insert(record);
        if (insert == 1) {
            result.setCode("00");
            result.setMsg("成功");
        }
        return result;
    }

}
