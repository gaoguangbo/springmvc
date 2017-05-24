<!DOCTYPE html>
<!-- saved from url=(0031)http://a285.wangzhanyanshi.com/ -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="alternate" media="only screen and (max-width: 640px)" href="http://m.a285.wangzhanyanshi.com/">


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui">
    <link rel="shortcut icon" href="http://a285.wangzhanyanshi.com/favicon.ico" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="../../source/nbase_cf47e58.css">
    <title>我的头条</title>
    <meta name="keywords" content="今日头条">
    <meta name="description" content="《今日头条》(TouTiao.com)是一款会自动学习的资讯软件,它会聪明地分析你的兴趣爱好,自动为你推荐喜欢的内容,并且越用越懂你.你关心的,才是头条!">
    <link rel="stylesheet" type="text/css" href="../../source/core_b666bd6.css">
    <link rel="stylesheet" type="text/css" href="../../source/newindex_b0deca1.css">
    <script type="text/javascript" charset="gb2312" src="../../source/lib_538033e.js"></script>
    <script src="../../source/analytics.js"></script>
    <script src="../../source/uaredirect.js" type="text/javascript"></script>
    <script src="../../js/lib/jquery-1.10.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            syncnews(-1);
        });
    </script>
    <!--反馈 start-->
    <script>
        $(function () {
            $('.feedbtn').click(function () {
                $('.feedback_dialog').toggleClass('on')
            });
            $('.feedback_dialog .close').click(function () {
                $('.feedback_dialog').removeClass('on')
            })
        });
        function submitfeedback(obj) {
            var name = '匿名';
            var email = $('[name=email]').val();
            var lytext = $('[name=lytext]').val();
            if (!email) {
                alert('请填写联系方式');
                return false;
            }
            if (!lytext) {
                alert('您的意见');
                return false;
            }

        }
    </script>


</head>
<body class="v2016" youdao="bind">

<div id="wrapper" class="index-wrapper">
    <div id="pagelet-nnav">

        <div class="dialog feedback_dialog">
            <div class="dialog-header">
                <h3>意见反馈</h3>
            </div>
            <div class="dialog-inner" data-node="inner">
                <div class="feedback_panel">
                    <form action="" method="post" name="form1"
                          onsubmit="return submitfeedback(this)">
                        <ul>
                            <li>
                                <p class="label">联系方式（必填）</p>
                                <div class="input-group">
                                    <input class="email" placeholder="您的邮箱" type="text" name="email">
                                </div>
                            </li>
                            <li>
                                <p class="label">您的意见（必填）</p>
                                <div class="input-group">
                                    <textarea style="height:100px;" name="lytext" class="content" maxlength="140"
                                              placeholder="请填写您的意见，不超过140字"></textarea>
                                </div>
                            </li>
                            <li>
                                <div class="input-group">
                                    <input name="name" type="hidden" id="name" value="匿名">
                                    <input type="submit" name="Submit3" class="submit-btn" value="提交">
                                    <input name="enews" type="hidden" id="enews" value="AddGbook">
                                    <input type="hidden" name="ecmsfrom" value="/">
                                    <span class="msg" data-node="msg"></span>
                                    <a data-node="close" class="close" href="javascript:;">[关闭]</a>
                                </div>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
        <!--反馈 end-->
        <div class="topbarWrapper" style="height: 34px;">

            <ul class="left">
                <li class="tb-item"><a class="tb-link"
                                       href="">放到桌面</a>
                </li>
                <li class="tb-item"><a class="tb-link add-favorite" data-node="addToFavorites" ga_event="nav_pin"
                                       href="javascript:;" onclick="alert('请按Ctrl+D收藏');">添加到收藏夹</a></li>
           <li>
           </li>
            </ul>


            <ul class="right">
                <li class="tb-item"><span><script src="${user.icon}"></script></span></li>
                <li class="tb-item"><a class="tb-link" href="javascript:;">${user.username}</a></li>
                <li class="tb-item"><a class="tb-link" href="/admin">媒体号</a></li>
                <li class="tb-item"><a class="tb-link"
                                       href=""
                                       onclick="return confirm('确认要退出?');">退出</a></li>
                <style>
                    #mth {
                        display: none
                    }
                </style>
                <li class="tb-item" id="mth"><a class="tb-link" href="#">媒体号</a>
                </li>
                <li class="tb-item"><a class="tb-link feedbtn" href="javascript:;" js_ga_event="nav_feedback"
                                       data-node="navFeedback">反馈</a></li>
                <li class="tb-item right-more" data-node="more">
                    <a class="tb-link" href="http://a285.wangzhanyanshi.com/about/" ga_event="nav_more">更多</a>
                    <div class="layer">
                        <ul>

                            <li><a href="http://m.a285.wangzhanyanshi.com/" class="layer-item">手机版</a></li>

                            <li><a href="http://a285.wangzhanyanshi.com/about/about.html" class="layer-item">关于我们</a>
                            </li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/join.html" class="layer-item">加入头条</a>
                            </li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/report.html" class="layer-item">媒体报道</a>
                            </li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/media_partners.html" class="layer-item">媒体合作</a>
                            </li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/cooperation.html"
                                   class="layer-item">产品合作</a></li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/media_cooperation.html"
                                   class="layer-item">合作说明</a></li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/contact.html" class="layer-item">联系我们</a>
                            </li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/user_agreement.html" class="layer-item">用户协议</a>
                            </li>
                            <li><a href="http://a285.wangzhanyanshi.com/about/complain.html" class="layer-item">投诉指引</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

        <!--[if lt IE 9 ]>
        <style>.midbarWrapper {
            border-bottom: 1px solid #e8e8e8;
        }</style><![endif]-->
        <div class="midbarWrapper">
            <div class="midbar-inner">
                <div class="logo-box">
                    <a class="logo-link" href="" ga_event="nav_icon"><img class="logo"
                                                                                                         src="../../source/logo.png"></a>
                </div>
                <div class="search-box">
                    <form action="" method="post" data-node="searchForm"
                          target="_blank">
                        <div class="input-group clearfix">
                            <input autocomplete="off" ga_event="nav_search_input" data-node="searchInput"
                                   name="keyboard" type="text" placeholder="搜索我关心的..." value="">
                            <div class="btn-submit">
                                <input type="hidden" name="show" value="title">
                                <input type="hidden" name="tempid" value="1">
                                <input type="hidden" name="tbname" value="news">
                                <button ga_event="nav_search" type="submit" href="javascript:;">
                                    <i class="icon icon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="user-box" data-node="userbox">

                    <div class="username-box clearfix" data-node="username">
                        <a ga_event="nav_login" class="nav-login user-item" href="javascript:;" data-node="login">
                            <span></span>
                        </a>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div id="container" class="clearfix">
        <div class="index-left">
            <div id="pagelet-channels" class="">
                <ul class="channel-box" data-node="channelBox">
                    <li class="channel-item">
                        <a ga_event="news_recommend" class="item item_index  selected"
                           href="http://a285.wangzhanyanshi.com/" data-node="category" data-category="__all__"><span
                                class="channel-tag">推荐</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_1 " href="javascript:void(0);" onclick="syncnews(1)"
                           data-category="news_hot"><span class="channel-tag news_hot">热点</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_2 " href="javascript:void(0);" onclick="syncnews(3)"
                           data-category="news_society"><span class="channel-tag news_society">社会</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_3 " href="javascript:void(0);" onclick="syncnews(4)"
                           data-category="news_entertainment"><span class="channel-tag news_entertainment">娱乐</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_4 " href="javascript:void(0);" onclick="syncnews(5)"
                           data-category="news_tech"><span class="channel-tag news_tech">科技</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_5 " href="javascript:void(0);" onclick="syncnews(6)"
                           data-category="news_car"><span class="channel-tag news_car">汽车</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_6 " href="javascript:void(0);"
                           data-category="news_sports"><span class="channel-tag news_sports">体育</span></a>
                    </li>
                    <li class="channel-item">
                        <a class="item item_7 " href="javascript:void(0);"
                           data-category="news_finance"><span class="channel-tag news_finance">财经</span></a>
                    </li>


                    <!--<li class="channel-item more-item magic-btn" data-node="foldBox">
                        <a ga_event="click_hide_channel" class="item" href="javascript:;" data-node="fold"><span class="channel-tag fold">收起</span></a>
                    </li>-->
                </ul>
                <div class="moreBox" data-node="moreBox">
                    <a ga_event="click_show_channel" class="moreBtn" href="javascript:;"><span class="channel-tag more">更多</span></a>
                    <ul class="more-channels" data-node="moreChannels">

                        <li class="channel-item item_news_military">
                            <a class="item " href=""><span
                                    class="channel-tag news_military">军事</span></a>
                        </li>
                        <li class="channel-item item_news_world">
                            <a class="item " href=""><span
                                    class="channel-tag news_world">国际</span></a>
                        </li>
                        <li class="channel-item item_news_fashion">
                            <a class="item " href=""><span
                                    class="channel-tag news_fashion">时尚</span></a>
                        </li>
                        <li class="channel-item item_news_travel">
                            <a class="item " href=""><span
                                    class="channel-tag news_travel">旅游</span></a>
                        </li>
                        <li class="channel-item item_news_discovery">
                            <a class="item " href=""><span
                                    class="channel-tag news_discovery">探索</span></a>
                        </li>
                        <li class="channel-item item_news_baby">
                            <a class="item " href=""><span
                                    class="channel-tag news_baby">育儿</span></a>
                        </li>
                        <li class="channel-item item_news_regimen">
                            <a class="item " href=""><span
                                    class="channel-tag news_regimen">养生</span></a>
                        </li>
                        <li class="channel-item item_news_story">
                            <a class="item " href=""><span
                                    class="channel-tag news_story">故事</span></a>
                        </li>
                        <li class="channel-item item_news_essay">
                            <a class="item " href=""><span
                                    class="channel-tag news_essay">美文</span></a>
                        </li>
                        <li class="channel-item item_news_game">
                            <a class="item " href=""><span
                                    class="channel-tag news_game">游戏</span></a>
                        </li>
                        <li class="channel-item item_news_history">
                            <a class="item " href=""><span
                                    class="channel-tag news_history">历史</span></a>
                        </li>
                        <li class="channel-item item_news_food">
                            <a class="item " href=""><span
                                    class="channel-tag news_food">美食</span></a>
                        </li>
                    </ul>
                </div>

            </div>
        </div>


        <div class="index-main">
            <div id="pagelet-nfeedlist">
                <div class="feedcomm" data-node="commItem">
                    <span class="comm-close" data-node="commClose"></span>
                    <a ga_event="click_banner" target="_blank" data-node="commLink"></a>
                </div>
                <p class="alert-msg" data-node="alertMsg">
                    <img src="../../source/loading_50c5e3e.gif">
                    <span>推荐数据加载中...</span>
                </p>
                <div class="unread" data-node="unread" ga_event="click_feed_update"><span>您有未读新闻，点击查看</span></div>
                <ul id="newsbox" data-node="listBox" class="listBox" scrollpagination="enabled">

                </ul>
                <a href="javascript:;" class="loadmore" data-node="loadMore" style="display: none;">正在为您加载更多...</a>
            </div>
        </div>
        <div class="index-right">
            <div id="pagelet-weather">
                <iframe allowtransparency="true" frameborder="0" width="250" height="98" scrolling="no"
                        src=""></iframe>
            </div>


            <div id="pagelet-commbox" style="">
                <!--<a ga_event="click_banner" class="img-box" target="_blank" data-node="link">
                    <img data-node="img" onload="this.style.opacity=1">
                </a>
                <span class="comm-label">推广</span>-->
                <!--广告位 右侧250x250_1 start-->
                <div style="width:248px;height:248px;line-height:248px;border:1px solid #ed4040;color:#ed4040;text-align:center;">
                    右侧广告位 250x250_1
                </div>
                <!--广告位 右侧250x250_1 end-->
            </div>

            <div id="pagelet-hotnews">
                <div class="head">
                    实时要闻
                </div>
                <div class="news">
                    <a href="" target="_blank" title="">123</a>
                </div>
            </div>

            <div id="pagelet-stock">
                <div class="stock_head">

                </div>
            </div>

            <div id="pagelet-company">
                <div class="company" id="toutiaoCompanyWrapper">
                    <span class="J-company-name">&#169; 2016 仿今日头条 http://a285.wangzhanyanshi.com/</span>
                    <a href="http://www.12377.cn/" target="_blank" ga_event="click_about">中国互联网举报中心</a>
                    <a href="http://www.miibeian.gov.cn/" target="_blank" ga_event="click_about">京公网安备
                        11010802020116号</a>
                    <a href="http://a285.wangzhanyanshi.com/license/" class="icp" target="_blank">网络文化经营许可证</a>
                    <a href="http://a285.wangzhanyanshi.com/chengnuoshu/" target="_blank">跟帖评论自律管理承诺书 </a>
                    <span>违法和不良信息举报:xxx@xxx.com</span>
                    <span style="display:none">统计代码填到这里 </span>

                </div>


            </div>
            <link type="text/css" rel="stylesheet" href="../../source/loginbox.css">
            <div id="bgDiv" style="display:none;"></div>

            <%--<script type="text/javascript">--%>
            <%--var IsMousedown, LEFT, TOP, lggood;--%>
            <%--document.getElementById("Mdown").onmousedown = function (e) {--%>

            <%--lggood = document.getElementById("lggoodBox");--%>
            <%--IsMousedown = true;--%>
            <%--e = e || event;--%>
            <%--LEFT = e.clientX - parseInt(lggood.style.left);--%>
            <%--TOP = e.clientY - parseInt(lggood.style.top);--%>
            <%--document.onmousemove = function (e) {--%>
            <%--e = e || event;--%>
            <%--if (IsMousedown) {--%>
            <%--lggood.style.left = e.clientX - LEFT + "px";--%>
            <%--lggood.style.top = e.clientY - TOP + "px";--%>
            <%--}--%>

            <%--}--%>
            <%--document.onmouseup = function () {--%>
            <%--IsMousedown = false;--%>
            <%--}--%>

            <%--}--%>
            <%--$(function () {--%>
            <%--$('#loginboxbtn').click(function () {--%>
            <%--$('#bgDiv,#lggoodBox').show();--%>
            <%--});--%>

            <%--})--%>
            <%--</script>--%>


        </div>
        <div id="pagelet-nfeedback">
            <ul>
                <li>
                    <a ga_event="click_feed_newsrefresh" class="refresh" href="javascript:;" data-node="refresh"></a>
                    <!--<a ga_event="gotop" class="btn" href="javascript:;" data-node="back">
                        <i class="icon icon-back"></i>
                    </a>-->
                </li>
                <!--<li>
                    <a ga_event="feedback" class="btn" href="javascript:;" data-node="feedback">
                        <i class="icon icon-comment"></i>
                    </a>
                </li>-->
            </ul>
        </div>
    </div>
</div>
<script>
    window.scrollTo(0, 0);

    window.gaqpush = function (ga_action, ga_label) {
        ga('send', 'event', '/', ga_action, ga_label);
    };

    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
        a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

    //    ga('create', 'UA-28423340-5', 'autoz');
    //    ga('send', 'pageview');


    $("body").on('click', '[ga_event]', function (e) {
        var $this = $(this);
        var ga_category = $this.attr('ga_category') || '/';
        var ga_action = $this.attr('ga_event');
        var ga_label = $this.attr('ga_label');
        var ga_value = $this.attr('ga_value') || 1;

        ga('send', 'event', ga_category, ga_action, ga_label, ga_value);
    });

</script>
<script>
    window.scrollTo(0, 0);
    $(document).scroll(function () {
        var scrolltop = $(document).scrollTop();
        if (scrolltop > 1200) {
            $('#pagelet-commbox').css({'position': 'fixed', 'top': '100px'});
        } else {
            $('#pagelet-commbox').css({'position': '', 'top': ''});
        }
        if (scrolltop > 30) {
            $('.topbarWrapper').css({'height': '0px'});
        } else {
            $('.topbarWrapper').css({'height': '34px'});
        }
    });
</script>
<script>
    function syncnews(typeId) {
        var ul = $("#newsbox");
        ul.attr("value", "");
        console.info(ul.html());

        var pageNum = $("#pageNum").val();
        var pageSize = $("#pageSize").val();
        var data = {
            pageNum: pageNum,
            pageSize: pageSize,
            typeId: typeId
        }
        $.ajax({
            url: "/news/getNews",
            type: "post",
            dataType: 'json',
            data: data,
            success: function (data) {
                console.info(data);
                var result = data.result;
                var pageNum = result.pageNum;
                var pageSize = result.pageSize;
                var results = result.results;
                var all = "";
                for(var i =0;i<results.length;i++) {
                    console.info(results[i]);
                    console.info(results[i].authorId)

                    var nhtml = create_news(results[i].id,results[i].title,results[i].content,results[i].picUrl);
                    all = all + nhtml;
//                    ul.append(html);
//                    console.info(html);

                }
                ul.html(all);
                console.info(pageNum);
                console.info(pageSize);
                console.info(results);
            }
        });
    }


    function create_news(news_id,title,content,picurl) {

        var newli ='<li class="item clearfix" data-node="item" rel="loaded">'
        +'<div class="item-inner">'
        +'<div class="lbox left">'
        +'<a href="/news/getNewsById?news_id='+ news_id +'" target="_blank">'
        +'<img class="feedimg" src="'+picurl+'"'
        +'onload="this.style.opacity=1;" style="opacity: 1;">'
        +'</a>'
        +'</div>'
        +'<div class="rbox"><!--hold-->'
        +'<div class="rbox-inner">'
        +'<div class="title-box">'
        +'<a ga_event="click_feed_newstitle" class="link title"'
        +'href="/news/getNewsById?news_id='+ news_id +'" target="_blank" data-node="title">'
        + title +'</a>'
        +'</div>'
        +'<div class="abstract">'
        +'<a ga_event="click_feed_newsabstract" class="link"'
        +'href="/news/getNewsById?news_id='+ news_id +'" target="_blank">'+content+'</a>'
        +'</div>'
        +'<div class="footer clearfix">'
        +'<div class="left lfooter">'
        +'<a class="lbtn source" href="javascript:;">&nbsp;</a>'
        +'<span class="lbtn comment"></span>'
        +'</div>'
        +'<div class="right rfooter">'
//        +'<span data-node="likeGroup" class="">'
//        +'<a class="rbtn bury" href="javascript:;" title="踩"'
//        +'onclick="makeRequest('/e/public/digg?classid=1&amp;id=2667&amp;dotop=1&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET','');"></a>'
//        +'<a class="rbtn digg" href="javascript:;" title="顶"'
//        +'onclick="makeRequest('/e/public/digg?classid=1&amp;id=2667&amp;dotop=0&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET','');"></a>'
//        +'</span>'
        +'</div>'
        +'</div>'
        +'</div>'
        +'</div>'
        +'</div>'
        +'</li>';
        return newli;
    }
</script>


<input type="hidden" id="pageNum" value="1"/>
<input type="hidden" id="pageSize" value="10"/>
</body>
</html>