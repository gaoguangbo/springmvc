package com.guangbo.controller;

import com.guangbo.bayes.BayesMain;
import com.guangbo.common.WebResult;
import com.guangbo.dao.entity.NewsInfo;
import com.guangbo.dao.entity.NewsType;
import com.guangbo.po.FenLeiResult;
import com.guangbo.service.INewsBackService;
import com.guangbo.service.INewsOperateService;
import com.guangbo.service.impl.NewsTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @param newsId
     * @return
     */
    @RequestMapping("/zan")
    @ResponseBody
    public Object zan(Integer newsId) {
        newsOperateService.zan(newsId);
        WebResult result = new WebResult();
        result.setCode("00");
        result.setMsg("成功");
        return result;
    }

    /**
     * 取消赞
     * @param newsId
     * @return
     */
    @RequestMapping("/dezan")
    @ResponseBody
    public Object deZan(Integer newsId) {
        newsOperateService.zan(newsId,true);
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
        String text = "当前，个别地区违法违规举债担保时有发生，局部风险不容忽视。财政部、发改委、司法部、央行、银监会、证监会等六部门近日发布通知，进一步明确举债融资政策边界，规范地方政府举债融资行为，要求各地切实加强融资平台公司融资管理，规范政府与社会资本方的合作行为，建立跨部门联合监测和防控机制。我国政府债务风险情况如何？通知出台背景是什么？记者采访了有关部门和专家。 变相举债扰乱市场秩序、积聚财政金融风险 “新预算法实施以来，地方各级政府加快建立规范的举债融资机制，防范化解财政金融风险，取得明显成效。”财政部有关负责人介绍，截至2016年末，我国政府债务27.33万亿元。按照国家统计局公布的GDP初步核算数74.41万亿元计算，我国政府债务的负债率为36.7%，低于欧盟60%的警戒线，也低于主要市场经济国家和新兴市场国家水平，风险总体可控。 “但是，一些地区政府违法违规举债担保仍时有发生，此次六部门联合发布通知，就是针对一些地方出现的违规举债‘新变种’，开出负面清单严堵后门，坚决制止违法违规举债担保行为。”这位负责人表示。 地方违法违规举债的新变种，主要集中在融资平台公司、不规范的PPP项目、政府投资基金等领域，通过“明股暗债”等方式，变相举债。这些行为违反了现行法律法规和制度规定，扰乱了市场秩序，积聚了财政金融风险。 依据预算法，地方政府举债一律采取发行地方政府债券方式；除外国政府和国际经济组织贷款转贷外，地方政府及其所属部门，不得为任何单位和个人的债务以任何方式提供担保。 公益性资产、储备土地不得注入融资平台公司 “地方政府举债的正路只有一条，就是发行地方政府债券。这一点明确了，才能厘清政府和企业责任边界。”中央财经大学乔宝云教授表示，城投债算不算政府债，很多人弄不清楚。实际上，无论是城投债，还是融资平台公司供贷款融资，都是企业的市场行为，跟地方政府举债没有关系。 如何防范地方政府作为大股东，绕道融资平台变相举债？此次六部门开列的负面清单明确：地方政府不得违规将政府办公楼、学校、医院、公园等公益性资产及储备土地注入融资平台公司；不得承诺将储备土地预期出让收入作为融资平台公司偿债资金来源。 融资平台公司的融资，很多来自于银行等金融机构。部分金融机构对企业提供融资时，仍要求地方政府提供担保承诺。对此，通知明确，地方政府及其所属部门不得以文件、会议纪要、领导批示等任何形式，要求或决定企业为政府举债或变相为政府举债。 金融机构为融资平台公司等企业提供融资时，也不得要求或接受地方政府及所属部门出具担保函、承诺函、安慰函等提供担保。金融机构要切实加强风险防范，落实企业举债准入条件，按商业化原则履行相关程序，审慎评估举债人财务能力和还款来源。 政府与社会资本合作可让利，但不能承诺无风险收益 通知要求，严禁地方政府利用PPP以及各类政府投资基金，违法违规变相举债。 地方政府与社会资本合作，本应利益共享、风险共担。为了调动社会资本参与的积极性，政府可以少分享利益。但在一些地方，PPP和投资基金变成了“明股暗债”，亏了由政府资金“兜底”，社会资本方则“旱涝保收”，无论项目亏盈都有保本收益。这样一来，风险全部转到了政府一边，双方合作变成了社会资本“放贷”。 对此，六部门也开出了负面清单：不得以任何方式承诺回购社会资本方的投资本金，不得以任何方式承担社会资本方的投资本金损失，不得以任何方式向社会资本方承诺最低收益，避免地方政府违法违规通过承担项目全部风险的方式变相举债。同时，明确地方政府不得以借贷资金出资设立各类投资基金，不得对有限合伙制基金等任何股权投资方式额外附加条款变相举债。 加强跨部门联合惩戒，形成监管合力 “财政部将会同有关部门，建立地方政府债务常态化监督机制，定期核查违法违规融资担保问题。”财政部有关负责人表示，目前已分3批对部分市县政府、金融机构违法违规融资担保行为公开通报，警示和引导地方政府依法行政，督促金融机构回归服务实体经济本源。 针对地方政府融资担保行为的主要类型，相关部门将打破信息孤岛，建设大数据监测平台，统计监测政府中长期支出事项，并对融资平台公司举借银行贷款，发行资管产品、公司债券等加强监管，定期通报监测结果。 同时，加强跨部门联合惩戒，形成监管合力。对地方政府及其所属部门违法违规举债或担保的，对融资平台公司从事或参与违法违规融资活动的，对金融机构违法违规向地方政府提供融资，或要求或接受地方政府提供担保承诺的，对中介机构、法律服务机构违法违规为融资平台公司出具审计报告、资产评估报告、信用评级报告、法律意见书等的，发现一起、查处一起，绝不允许任何人凌驾于国家法律之上。";
        BayesMain classifier = new BayesMain();//构造Bayes分类器
        String classify = classifier.classify(text);//进行分类
        System.out.println("此项属于[" + classify + "]");

        FenLeiResult result = new FenLeiResult();
        result.setContent(text);
        result.setType(classify);
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


