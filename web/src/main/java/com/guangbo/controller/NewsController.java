package com.guangbo.controller;

import com.guangbo.common.WebResult;
import com.guangbo.dao.entity.FenleiResult;
import com.guangbo.dao.entity.NewsBack;
import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.entity.NewsType;
import com.guangbo.pachong.newsClassify.GraphModel;
import com.guangbo.service.INewsBackService;
import com.guangbo.service.INewsOperateService;
import com.guangbo.service.impl.NewsTypeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gaoguangbo on 2017/5/10.
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsOperateService newsOperateService;
    @Autowired
    private INewsBackService newsBackService;
    @Autowired
    private NewsTypeServiceImpl newsTypeService;

    /**
     * 发布新闻
     * @param newsInfo
     * @return
     */
    @RequestMapping(value = "/publish", produces = "application/json;charset=UTF-8")
    public String publishNews(NewsInfo newsInfo) {
        if (newsInfo.getId() == null) {
            newsOperateService.publish(newsInfo);
        }else {//更新
            newsOperateService.update(newsInfo);
        }
        return "index";
    }

    /**
     * 修改新闻
     * @param newsInfo
     * @return
     */
    @RequestMapping(value = "/modify", produces = "application/json;charset=UTF-8")
    public String modifyNews(NewsInfo newsInfo) {
        newsOperateService.publish(newsInfo);
        return "index";
    }

    /**
     * 通过主键查询新闻
     * @param news_id
     * @param model
     * @
     * @return
     */
    @RequestMapping("/getNewsById")
    public String getOneNews(Integer news_id, Model model,Boolean modify) {
        NewsInfo news = newsOperateService.getNews(news_id);
        model.addAttribute("news", news);
        if (modify != null && modify == true) {
            List<NewsType> list = newsTypeService.query(new NewsType());
            model.addAttribute("types", list);
            return "publish_news";
        }
        return "news_model";
    }

    /**
     * 获取新闻 ，带分页
     * @param newsInfo
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/getNews")
    @ResponseBody
    public WebResult getNews(NewsInfo newsInfo, Integer pageNum, Integer pageSize) {
        WebResult webResult = new WebResult();
        webResult.setCode("01");
        webResult.setMsg("失败");
        if (newsInfo.getTypeId() == -1) {
            newsInfo.setTypeId(null);
        }
        if (null != pageNum) {
            webResult.setResult(newsOperateService.queryByPage(newsInfo, pageNum, pageSize));
        }else {
            webResult.setResult(newsOperateService.query(newsInfo));
        }

        webResult.setCode("00");
        webResult.setMsg("成功");
        return webResult;
    }

    /**
     * 赞
     * @param news_id
     * @return
     */

    public Object zan(Integer news_id) {
        newsOperateService.zan(news_id);
        WebResult result = new WebResult();
        result.setCode("00");
        result.setMsg("成功");
        return result;
    }

    /**
     * 取消赞
     * @param news_id
     * @return
     */
    public Object deZan(Integer news_id) {
        newsOperateService.zan(news_id,true);
        WebResult result = new WebResult();
        result.setCode("00");
        result.setMsg("成功");
        return result;
    }

    /**
     * 从url中爬取新闻
     * @param newsUrl
     * @return
     */
    @RequestMapping("/getByUrl")
    @ResponseBody
    public Object geturl(String newsUrl) {
//        String url = "http://finance.sina.com.cn/stock/s/2017-05-16/doc-ifyfeivp5752185.shtml";
        FenleiResult result = new FenleiResult();
        try {
            GraphModel graphModel = new GraphModel();
            String[] fenlei = graphModel.fenlei(newsUrl);
            result.setContent(fenlei[0]);
            result.setType(fenlei[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 管理发布过的文章
     * @param model
     * @return
     */
    @RequestMapping("/management")
    public String admin(NewsInfo newsInfo,Integer pageNum, Integer pageSize, Model model) {
        WebResult result = getNews(newsInfo, pageNum, pageSize);
        if (result.getCode().equals("00")) {
            model.addAttribute("articles", result.getResult());
        }
        return "management";
    }
}


