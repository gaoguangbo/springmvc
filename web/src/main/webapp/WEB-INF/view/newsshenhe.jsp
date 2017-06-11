<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- saved from url=(0058)http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1 -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui">
    <link rel="stylesheet" type="text/css" href="../../css/common.css">
    <link rel="stylesheet" type="text/css" href="../../source/core_b666bd6.css">
    <link rel="stylesheet" type="text/css" href="../../source/newindex_b0deca1.css">
    <link type="text/css" rel="stylesheet" href="../../source/nbase_cf47e58.css">
    <script type="text/javascript" src="../../js/jquery-1.4.4.min.js"></script>
    <title>管理信息</title>
    <style type="text/css">
        #browser_err {
            display: none;
            background: #FFFF88;
            text-align: center;
            font-size: 20px;
            line-height: 1.8;
            border-bottom: 1px solid #808080;
            padding: 10px 0;
        }

        #browser_err a {
            color: #4D7CD9;
        }
    </style>
</head>

<body class="body_index" youdao="bind">
<style type="text/css">
    #browser_err {
        display: none;
        background: #FFFF88;
        text-align: center;
        font-size: 20px;
        line-height: 1.8;
        border-bottom: 1px solid #808080;
        padding: 10px 0;
    }

    #browser_err a {
        color: #4D7CD9;
    }
</style>
<div id="browser_err"></div>
<div id="pagelet-header">
    <div class="shead">
        <div class="shead_wrap">
            <a class="shead_logo" href="http://a285.wangzhanyanshi.com/">媒体号</a>
            <div class="shead_status">

                <span></span>

            </div>

            <div class="shead_right">

                <div class="sys-msg">
                    <!--<div class="sys-msg-entity" ga="消息" data-node='sys_msg_entity'>
                        <i class="sys-msg-sum" data-node="sys_msg_sum"></i>
                        <i class="sys-msg-dot" data-node="sys_msg_dot"></i>
                    </div>-->
                    <div class="sys-msg-outer" data-node="sys_msg_wrapper">
                        <div class="sys-msg-transparent"></div>

                    </div>
                    <div class="sys-msg-important" data-node="sys_msg_important_inform">
                        <div class="sys-msg-important-inner">
                            <ul class="sys-msg-impor-con" data-node="sys_msg_impor_con"></ul>
                            <i class="sys-msg-close" data-node="sys_msg_close"></i>
                        </div>
                    </div>
                </div>

                <div class="user-panel">

                    <div class="information">
                        <a href="javascript:;" target="_blank" title="全部文章">
                            <div class="new_user_avatar">
                                <img src="${user.icon}">
                            </div>
                            <div class="new_user_info">
                                <div class="new_user_type">
                                    <span class="user_type">普通会员</span>
                                </div>
                                <div class="new_user_name"><span>${user.username}</span></div>
                            </div>
                        </a>
                    </div>
                    <div class="author_dashbord">
                        <ul>
                            <li class="">
                                <i class=""></i>
                                <span class="new_author">作者</span>
                            </li>
                            <li class="authors_list top"><a href="http://a285.wangzhanyanshi.com/e/space/?userid=12"
                                                            target="_blank" title="lili的个人主页">lili</a>
                            </li>
                            <li class="new_logout">
                                <i class=""></i>
                                <a href="http://a285.wangzhanyanshi.com/e/member/doaction.php?enews=exit"
                                   onclick="return confirm('确认要退出?');">退出</a>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<div id="scontent">

    <div class="wrap1 sclearfix">
        <div class="menu">
            <div class="menu_block">
                <a href="http://a285.wangzhanyanshi.com/e/member/cp/" class="menu_h1  selected  menu_main alone"><i></i>主页</a>
            </div>

            <div class="menu_block">
                <a class="menu_h1 menu_settings"><i></i>设置</a>

                <a href="http://a285.wangzhanyanshi.com/e/member/EditInfo/"
                   class="menu_h2  menu_account"><i></i>修改资料</a>
                <a href="http://a285.wangzhanyanshi.com/e/member/EditInfo/EditSafeInfo.php" class="menu_h2 "><i></i>修改密码</a>
                <a href="http://a285.wangzhanyanshi.com/e/member/my/" class="menu_h2 "><i></i>账号状态</a>
                <a href="http://a285.wangzhanyanshi.com/e/member/friend/" class="menu_h2 "><i></i>好友列表</a>
                <a href="http://a285.wangzhanyanshi.com/e/memberconnect/ListBind.php" class="menu_h2 "><i></i>绑定外部登录</a>

            </div>
        </div>
        <div class="stage">

            <div class="indexpage">
                <div class="page_tabs sclearfix" style="border:none;border-bottom: 1px solid #d8dce4;">
                    <div class="page_tab selected"
                         style="border:none;border-bottom: 2px solid #FF5F63;top:0;bottom:-1px;">管理文章
                    </div>

                    <div class="page_tab  selected" style="border:none;"><a
                            href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1"
                            style="font-size:16px;position:relative;top: 7px;">已发布</a></div>
                    <div class="page_tab " style="border:none;"><a
                            href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1&amp;ecmscheck=1"
                            style="font-size:16px;position:relative;top: 7px;">待审核</a></div>
                    <div class="page_tab " style="border:none;"><select id="newstype" name="newstype">
                        <option value="0" selected>全部</option>
                        <c:forEach items="types" var="item">
                            <%--<option value="${item.id}" >${item.name}</option>--%>
                        </c:forEach>
                    </select></div>
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"
                           style="float:right;width:450px;margin-top:10px;">
                        <form name="searchinfo" method="GET"
                              action="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php"></form>
                        <tbody>
                        <tr>

                            <td width="75%">
                                <div align="right">&nbsp;搜索：
                                    <input name="keyboard" type="text" id="keyboard" value="">
                                    <select name="show">
                                        <option value="0" selected="">标题</option>
                                    </select>
                                    <input type="submit" name="Submit2" value="搜索">
                                    <input name="sear" type="hidden" id="sear" value="1">
                                    <input name="mid" type="hidden" value="1">
                                    <input name="ecmscheck" type="hidden" id="ecmscheck" value="0">
                                </div>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                <div class="page_content indexpage_content" style="padding: 22px 0;margin-top: 0px;">
                    <div class="indexpage_item">
                        <i class="sn" style="left:0;">标题</i>
                        <i class="sn" style="left:300px;">发布时间</i>
                        <i class="sn" style="right:200px;">点击数</i>
                        <i class="sn" style="right:200px;">审核建议</i>
                        <i class="sn" style="right:100px;">审核</i>
                        <i class="sn">操作</i>
                    </div>
                </div>
                <c:forEach items="${articles}" var="item" varStatus="status">
                    <div class="page_content indexpage_content">
                        <div class="indexpage_item">
                            <a href="" target="_blank">${item.title}</a>
                            <i class="sn" style="right:300px;">${item.createTime}</i>
                            <i class="sn" style="right:200px;">${item.clicktimes}</i>
                            <i class="sn" style="right:200px;"><input type="text" value="审核建议"></i>

                                <%--<i class="sn"><a href="/news/getNewsById?modify=true&news_id=${item.id}">修改</a> | <a href="" onclick="return confirm('确认要删除');">删除</a></i>--%>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
    <div class="dialog feedback_dialog on"
         style="position: absolute;top: 200px;right: 350px;width: 450px;height: 300px;" id="C_shenhe">
        <div class="dialog-header">
            <h3>意见反馈</h3>
        </div>
        <div class="dialog-inner" data-node="inner" >
            <div class="feedback_panel">
                <form>
                    <ul>
                        <li>您的审核意见</p>
                            <div class="input-group">
                                <textarea style="height:200px;width: 400px" name="lytext" class="content"
                                          maxlength="140" placeholder="请填写您的审核意见"></textarea>
                            </div>
                        </li>
                        <li>
                            <div class="input-group">
                                <input type="button" name="Submit" class="submit-btn" onclick="show_hide('C_shenhe',false)" value="确定">
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>

</div>
<div class="sfoot_p">
    <div class="sfoot">
        <div>
            <a href="mailto:mp@toutiao.com" class="sfoot_email">客服邮箱：xxx@xxx.com</a>|
            <a target="_blank" href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1#"
               class="sfoot_selfservice">常见问题</a>
        </div>
        <div>
            <a target="_blank" class="sfoot_about" href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1#">关于仿今日头条</a>|
            <a target="_blank" href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1#"
               class="sfoot_agreement">用户协议</a>|

            <a target="_blank" href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1#"
               class="sfoot_agreement">侵权投诉</a>|

            <a target="_blank" href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1#" class="sfoot_contact">联系我们</a>
            &#169; 2016 仿今日头条 http://a285.wangzhanyanshi.com/
        </div>
    </div>
</div>

<div id="wx-feedback"></div>
<div id="backtop" onclick="backtop();">返回顶部</div>
<!--  -->
<script type="text/javascript">
    function show_hide(target, flag) {
        if (flag) {
            $("#"+target).show();
        } else {
            $("#"+target).hide();
        }
    }

</script>

<!--[if lt IE 8 ]>
<script type="text/javascript">
    $(function () {
        setTimeout(function () {
            var err = [
                '抱歉，平台部分功能无法支持你的浏览器。为保证平台体验，请下载使用<a target="_blank" href="http://www.baidu.com/s?ie=utf-8&wd=%E8%B0%B7%E6%AD%8C%E6%B5%8F%E8%A7%88%E5%99%A8">谷歌浏览器</a>。 ',
                '如果是双核浏览器，请切换到高速 / 极速 / 神速核心。'
            ];
            var ele = document.getElementById('browser_err');
            ele.innerHTML = '<div>' + err.join('<br/>') + '</div>';
            ele.style.display = 'block';
        }, 20);
    });
</script>
<![endif]-->

</body>
</html>