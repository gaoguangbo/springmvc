<%--
  Created by IntelliJ IDEA.
  User: MiaoJinlong
  Date: 2017/5/13
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>注册</title>
    <meta name="baidu-site-verification" content="NMsByWYkwt">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta property="wb:webmaster" content="1cdd3f856f5473a5">
    <link rel="shortcut icon" href="http://www.qyer.com/favicon.ico">

    <script type="text/javascript"  src="../../js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        var flag1 = true;
        var flag2 = true;
        var flag3 = true;
        var flag4 = true;
//        window.onload = function(){
        function checkEmail(){
            var email=$("#email").val();
            if(email!=""){
                var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
                isok=reg.test(email);
            }
            if (!isok) {
                $(".message-box-email").html("");
                $(".message-box-email").text("邮箱格式不正确！");
                $(".message-box-email").style.color = 'red';
                flag1 = false;
                return false;
            }

            $.ajax({
                type: "post",
                url: "/regist/checkEmail",
                data: {email:email},
                dataType: "text",
                success: function(data){
                    var textColor = "";
                    if(data == "该邮箱已经注册过"){
                        textColor = "red";
                        flag1 = false;
                    }
                    if(data == "该邮箱可用") {
                        textColor = "green";
                        flag1 = true ;
                    }
                    $(".message-box-email").css({ color: textColor });
                    $(".message-box-email").html("");
                    $(".message-box-email").text(data);
                }
            });
        }
        function checkUserName(){
            var userName=$("#username").val();
            $.ajax({
                type: "post",
                url: "/regist/checkUserName",
                data: {userName:userName},
                dataType: "text",
                success: function(data){
                    var textColor = "";
                    if(data == "该用户名已经存在"){
                        textColor = "red";
                        flag2 = false;
                    }
                    if(data == "该用户名可用") {
                        textColor = "green";
                        flag2 = true;
                    }
                    $(".message-box-username").css({ color: textColor });
                    $(".message-box-username").html("");
                    $(".message-box-username").text(data);
                }
            });
        }
        function checkPassWord(){
            var password=$("#password").val();
            var textColor = "";
            if(password.length < 6) {
                warnMsg = "密码太短，请设置长密码！！";
                flag3 = false;
               textColor = "red";
            }
            if(password.length >= 6) {
                warnMsg = "密码可用";
               textColor = "green";
                flag3 = true;
            }
            $(".message-box-password").html("");
            $(".message-box-password").text(warnMsg);
            $(".message-box-password").css({ color: textColor});
        }
        function checkCurPassword(){
            var curpassword=$("#curpassword").val();
            var password = $("#password").val();
            var warnMsg = "";
            var textColor = "";
            if(curpassword == password){
                warnMsg = "两次密码一致";
                textColor = "green";
                flag4 = true;
            }
            if(curpassword != password) {
                warnMsg = "两次密码不同，请重新输入";
                flag4 = "false";
                textColor = "red";
            }
            $(".message-box-curpassword").css({ color:textColor });
            $(".message-box-curpassword").html("");
            $(".message-box-curpassword").text(warnMsg);

        }
        function  check() {
            if(flag1 && flag2 && flag3 && flag4) {
                $("#registerForm").submit();
            }
        }
    </script>

    <link rel="stylesheet" href="../../regist_files/fe_frame_c9d3c38d17bac43a47d25114f17d1666.css">

    <link rel="stylesheet" href="../../regist_files/headfoot.css">
    <link rel="stylesheet" href="../../regist_files/register_447d86ef039c09fa092c4465c254b7c0.css">
    <style type="text/css">.qui-loginFeedback { position:fixed; _position:absolute; z-index:99; top:120px; right:-248px; display:none;}.qui-loginFeedback .icon { position: relative; float:left; margin-right: -1px; width:40px; height:166px; background:url(//static.qyer.com/models/common/component/loginFeedback/icons_feedback.png) 0 0 no-repeat; cursor:pointer;}@media screen and (-webkit-min-device-pixel-ratio: 2), screen and ( max-moz-device-pixel-ratio: 2) {.qui-loginFeedback .icon {background:url(//static.qyer.com/models/common/component/loginFeedback/icons_feedback@2x.png) 0 0 no-repeat; background-size: 80px 166px;}}.qui-loginFeedback.js-current > .icon { background-position: -40px 0;}.qui-loginFeedback .cnt { float:left; width:246px; height:280px; border: 1px solid #ccc; border-radius: 0 4px 4px 4px; background-color:#FFF;}.qui-loginFeedback .cnt form { padding:10px; font-size:0;}.qui-loginFeedback .cnt textarea { width:214px; height:128px; padding:2px 5px; border:1px solid #ccc; font-size:12px;}.qui-loginFeedback .cnt .txt { padding:2px 5px; border:1px solid #ccc; font-size:12px; width: 214px; height: 24px;}.qui-loginFeedback .cnt .btn { float:right; margin-top:10px;}.qui-loginFeedback .label { margin-top: 6px; padding: 2px 0; line-height: 24px; font-size: 12px;}.qui-loginFeedback .help { position:relative; top:-1px; border:1px solid #ccc; border-top:none; background:#dcffe2; height:24px; line-height:26px; text-align:center;font-size:12px;}.qui-loginFeedback .help a { color: #3f9f5f;}</style><style type="text/css">.qui-select{position:relative;display:inline-block;width:75pt;height:30px;overflow:visible}.qui-select-disable>.titles{background-color:#eee!important;cursor:default!important}.qui-select .contents ul li,.qui-select .titles{font-size:14px;cursor:pointer;text-overflow:ellipsis}.qui-select .titles{background:url(http://fed.static.qyer.com/core/web/common/resource/ui/oldselect/icons.png) center right no-repeat #fff;border:1px solid silver;color:#636363;display:block;line-height:30px;padding:0 10px 0 5px;width:100%;height:100%;overflow:hidden}.qui-select .titles .title-text{background-position:0 -4px;margin-left:5px;white-space:nowrap}.qui-select .contents{background-color:#FFF;border:1px solid silver;box-shadow:0 1px 2px rgba(0,0,0,.1);display:none;line-height:38px;position:absolute;top:31px;width:180px;max-height:235px;overflow:auto;z-index:10}.qui-select .contents ul li:first-child{border-top:0 none}.qui-select .contents ul li{border-top:1px solid #EBEBEB;line-height:38px;white-space:nowrap;overflow:hidden}.qui-select .contents ul li:hover{background-color:#d9eed7}.qui-select .contents ul li a{padding-left:10px;color:#636363;text-decoration:none}.qui-tip{position:fixed;top:75pt;left:0;width:100%;text-align:center;display:none;z-index:1100}.qui-tip-box{display:inline-block;min-width:90pt;max-width:390px;padding:20px 30px;background-color:#fff;box-shadow:0 2px 7px rgba(0,0,0,.25);border:1px solid silver;text-align:left;font-size:18px;line-height:2pc}.qui-tip-text{display:block;position:relative;padding-left:34px}.qui-tip-text:before{content:'';position:absolute;left:0;top:4px;width:24px;height:24px;background:url(http://fed.static.qyer.com/core/web/common/resource/ui/oldtip/icons2.png) no-repeat #fff}.qui-tip-box-error .qui-tip-text:before{background-position:0 -5pc}.qui-tip-box-warning .qui-tip-text:before{background-position:0 -40px}</style></head>
<body>

<div class="login-container">
    <div class="wrapper">
        <div class="section">
            <div class="qui-login-section section-register" style="display: block;">
                <div class="qui-login-tabs">
                    <a style=" margin-left:80px;"><p >注册</p></a>
                </div>
                <div class="qui-login-form" style="display: block;">
                    <form id="registerForm" action="/regist/insertUserInfo" method="post">
                        <input type="password" style="height: 0;padding: 0;position: absolute;border: 0 none;">
                        <div class="qui-login-input input-control input-control-register-mail" style="display: block;">
                            <a href="javascript:;" class="icon-clear"></a>
                            <input type="text" id="email" class="ui3_input field_valid" name="email" title="邮箱" tabindex="1" placeholder="输入用于激活邮箱地址" onchange="checkEmail()">
                            <div class="message-box-email"></div>
                        </div>
                        <div class="qui-login-input">
                            <input type="text" id="username" class="ui3_input field_valid" name="username" maxlength="15" title="用户名" tabindex="3" placeholder="起一个具有辨识度的用户名" onchange="checkUserName()">
                            <div class="message-box-username"></div>
                        </div>
                        <div class="qui-login-input">
                            <input type="password" id="password" class="ui3_input field_valid" name="password" maxlength="16" title="密码" tabindex="4" placeholder="输入至少6位密码" onchange="checkPassWord()">
                            <div class="message-box-password"></div>
                        </div>
                        <div class="qui-login-input">
                            <input type="password" id="curpassword" class="ui3_input field_valid" name="curpassword" maxlength="16" title="重输密码" tabindex="4" placeholder="重新输入密码" onchange="checkCurPassword()">
                            <div class="message-box-curpassword"></div>
                        </div>
                        <div class="qui-login-input qui-login-btn">
                            <input type="button" id = "regist1" onclick = "check()" class="ui_button btn_submit" value="注册" data-value="注册">
                            <div class="message-box">
                                <span class="fl">已有问游账号？ <a class="change-login-type" href="/wel/login" data-page="login" data-type="account" data-bn-ipg="web-register-layer-login">登录</a></span>
                                <span class="fr">同意<a href="http://www.qyer.com/htmlpages/member.html" target="_blank" data-bn-ipg="web-register-layer-clause">会员条款</a>和<a href="http://www.qyer.com/htmlpages/exemption.html" target="_blank" data-bn-ipg="web-register-layer-statement">免责声明</a></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="section-message-box"></div>
            </div>
        </div>
    </div>
</div>
<div class="phpreferer" style="display: none;">http://www.qyer.com/</div>
<div class="qyer_footer">
    <div class="qyer_footerBox">
        <ul class="qyer_footer_about">
            <li>
                <dl>
                    <dt>关于我们</dt>
                    <dd><a href="http://www.qyer.com/htmlpages/about.html" target="_blank" rel="nofollow" data-bn-ipg="foot-about-1">穷游简介</a></dd>
                    <dd><a href="http://www.qyer.com/htmlpages/contact.html" target="_blank" rel="nofollow" data-bn-ipg="foot-about-2">联系我们</a></dd>
                    <dd><a href="http://www.qyer.com/partner/" target="_blank" rel="nofollow" data-bn-ipg="foot-about-3">合作伙伴</a></dd>
                </dl>
            </li>
            <li>
                <dl>
                    <dt>加入问游</dt>
                    <dd><a href="http://www.qyer.com/job/" target="_blank" rel="nofollow" data-bn-ipg="foot-join-1">招聘职位</a></dd>
                </dl>
            </li>
            <li>
                <dl>
                    <dt>网站条款</dt>
                    <dd><a href="http://www.qyer.com/htmlpages/member.html" target="_blank" rel="nofollow" data-bn-ipg="foot-clause-1">会员条款</a></dd>
                    <dd><a href="http://www.qyer.com/htmlpages/bbsguide.html" target="_blank" rel="nofollow" data-bn-ipg="foot-clause-2">社区指南</a></dd>
                    <dd><a href="http://www.qyer.com/htmlpages/copyright.html" target="_blank" rel="nofollow" data-bn-ipg="foot-clause-3">版权声明</a></dd>
                    <dd><a href="http://www.qyer.com/htmlpages/exemption.html" target="_blank" rel="nofollow" data-bn-ipg="foot-clause-4">免责声明</a></dd>
                </dl>
            </li>
            <li>
                <dl>
                    <dt>帮助中心</dt>
                    <dd><a href="http://site.qyer.com/tyro/" target="_blank" rel="nofollow" data-bn-ipg="foot-help-1">新手上路</a></dd>
                    <dd><a href="http://bbs.qyer.com/forum-10-1.html" target="_blank" rel="nofollow" data-bn-ipg="foot-help-2">使用帮助</a></dd>
                    <dd><a href="http://www.qyer.com/sitemap.html" target="_blank" data-bn-ipg="foot-help-4">网站地图</a></dd>
                </dl>
            </li>
            <li>
                <dl class="qyer_footer_attention">
                    <dt>关注我们</dt>
                    <dd><a href="http://weibo.com/go2eu" target="_blank" title="问游网@新浪微博" rel="nofollow" data-bn-ipg="foot-concern-1" class="weibo">问游网@新浪微博</a></dd>
                    <dd><a href="http://www.flickr.com/photos/go2eu" target="_blank" title="问游网@flickr" rel="nofollow" data-bn-ipg="foot-concern-2" class="flickr">问游网@flickr</a></dd>
                    <dd><a href="http://page.renren.com/600986584" target="_blank" title="问游网@人人" rel="nofollow" data-bn-ipg="foot-concern-3" class="renren">问游网@人人</a></dd>
                    <dd><a href="http://site.douban.com/go2eu" target="_blank" title="问游网@豆瓣" rel="nofollow" data-bn-ipg="foot-concern-4" class="douban">问游网@豆瓣</a></dd>
                    <dd><a href="http://instagram.com/qyer" target="_blank" title="问游网@instagram" rel="nofollow" data-bn-ipg="foot-concern-7" class="instagram">问游网@instagram</a></dd>
                    <dd><a href="http://plus.weico.com/134522585376811014" target="_blank" title="问游网@微可拍" rel="nofollow" data-bn-ipg="foot-concern-8" class="weico">问游网@微可拍</a></dd>
                </dl>
            </li>
        </ul>
        <div class="qyer_footer_appStore"><a class="qyer_hf_bg btn_appstore" href="http://itunes.apple.com/cn/artist/qyer/id492202235" target="_blank" rel="nofollow" data-bn-ipg="foot-appstore" alt="问游网@App Store" title="问游网@App Store"></a></div>
        <div class="qyer_footer_copyright"><a class="qyer_hf_bg btn_copyright" href="http://www.qyer.com/" rel="nofollow" data-bn-ipg="foot-logo" alt="问游网"></a>
            <p>2004-2017 © 问游网™ qyer.com All rights reserved.&nbsp;&nbsp;<a href="http://www.miibeian.gov.cn/" target="_blank" rel="nofollow">京ICP备12003524号</a>&nbsp;&nbsp;京公网安备11010502023470</p>
            <p><a href="http://www.qyer.com/">问游网</a>为<a href="http://www.qyer.com/">旅行</a>者提供原创实用的<a href="http://www.qyer.com/">出境游</a><a href="http://place.qyer.com/">旅行指南</a>和<a href="http://place.qyer.com/">旅游攻略</a>、<a href="http://bbs.qyer.com/">旅行社区</a>和<a href="http://ask.qyer.com/">问答</a>交流平台，并提供<a href="http://qyer.ailvxing.com/">签证</a>、<a href="http://bx.qyer.com/">保险</a>、<a href="http://flight.qyer.com/">机票</a>、<a href="http://hotel.qyer.com/">酒店预订</a>、<a href="http://car.qyer.com/">租车</a>等服务。</p>
        </div>
        <!--友情链接模块-->
    </div>
</div>

<div class="qui-tip" style="display:none;"><div class="qui-tip-box"><span class="qui-tip-text fontYaHei">这里是提示文本</span></div></div><div class="qui-loginFeedback" style="display: block; right: -248px;"><div class="icon js-btn" title="登录意见反馈"></div><div class="cnt"><form method="post"><textarea class="js-feedback-cnt" cols="50" tabindex="10" rows="10" placeholder="有任何意见或建议请告诉我们"></textarea><p class="help">使用遇到问题？请先进入<a href="http://bbs.qyer.com/forum-10-1.html" target="_blank">帮助中心</a></p><p class="label">联系方式</p><input class="txt js-feedback-contact" tabindex="11" type="text" placeholder="请将您的邮箱或手机号码告诉我们"><input class="btn ui_button js-submitBtn" tabindex="12" type="button" value="提交"></form></div></div></body></html>