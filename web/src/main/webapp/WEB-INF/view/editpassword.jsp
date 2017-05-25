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
                <a class="menu_h1 menu_article"><i></i>文章管理</a>
                <a href="http://a285.wangzhanyanshi.com/e/DoInfo/ListInfo.php?mid=1" class="menu_h2"><i></i>管理文章</a>
                <a href="http://a285.wangzhanyanshi.com/e/DoInfo/ChangeClass.php?mid=1" class="menu_h2">发布文章</a>
                <!--<a href="#" class="menu_h2">管理图集</a> -->
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
                <div class="stage formbox">
                    <form name=userinfoform method=post enctype="multipart/form-data" action="/regist/editpass">
                        <div class="">
                            <div class="page_tabs sclearfix" style="border:none;border-bottom: 1px solid #d8dce4;">
                                <div class="page_tab selected" style="border:none;border-bottom: 2px solid #FF5F63;bottom:-1px;top:0;"></div>
                            </div>
                            <div class="page_content indexpage_content" id="pagelet-write">
                                <input type="hidden" name="enews" value="EditSafeInfo">
                                <div class="edit-cell">
                                    <div class="edit-main front-cover">
                                        <label class="edit-label">密码安全修改</label>
                                        <div class="edit-input">
                                            <div class="front-cover-type">
                                                <div class="front-cover-item">lili</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <style>
                                    #pagelet-write img{display: block;max-width: 128px;max-height: 128px;margin-bottom:6px;}
                                </style>
                                <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" class="tableborder">
                                    <tbody><tr>
                                        <td width="21%" height="25" bgcolor="#FFFFFF"> <div align="left">用户名 </div></td>
                                        <td width="79%" height="25" bgcolor="#FFFFFF">${user.username}</td>
                                    </tr>
                                    <tr>
                                        <td height="25" bgcolor="#FFFFFF"> <div align="left">原密码</div></td>
                                        <td height="25" bgcolor="#FFFFFF"> <input name="oldpassword" type="password" id="oldpassword" size="38" maxlength="20"></td>
                                    </tr>
                                    <tr>
                                        <td height="25" bgcolor="#FFFFFF"> <div align="left">新密码</div></td>
                                        <td height="25" bgcolor="#FFFFFF"> <input name="password" type="password" id="password" size="38" maxlength="20"></td>
                                    </tr>
                                    <tr>
                                        <td height="25" bgcolor="#FFFFFF"> <div align="left">确认新密码</div></td>
                                        <td height="25" bgcolor="#FFFFFF"> <input name="repassword" type="password" id="repassword" size="38" maxlength="20">
                                            (不想修改请留空)</td>
                                    </tr>
                                    </tbody></table>
                            </div>
                            <input class="signform_btn signbasic_submit" type="submit" value="提交">
                        </div>
                    </form>
                </div>

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