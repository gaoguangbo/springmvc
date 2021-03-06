<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui">
    <link rel="stylesheet" type="text/css" href="../../style/login/common.css">
    <title>增加信息</title>
    <link rel="stylesheet" type="text/css" href="../../css/wangEditor.min.css">
    <style type="text/css">
        /*富文本开始*/
        #content {
            height: 400px;
            /*max-height: 500px;*/
        }
        .container {
            width: 100%;
            margin: 0 auto;
            position: relative;
        }
        /*富文本结束*/
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
<script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>
<script src="../../data/html/setday.js"></script>
<script src="../../js/ajaxfileupload.js"></script>
<script>
    function bs() {
        var f = document.add
        if (f.title.value.length == 0) {
            alert("标题还没写");
            f.title.focus();
            return false;
        }
        if (f.classid.value == 0) {
            alert("请选择栏目");
            f.classid.focus();
            return false;
        }
    }
    function foreColor() {
        if (!Error())    return;
        var arr = showModalDialog("./data/html/selcolor.html", "", "dialogWidth:18.5em; dialogHeight:17.5em; status:0");
        if (arr != null) document.add.titlecolor.value = arr;
        else document.add.titlecolor.focus();
    }
    function FieldChangeColor(obj) {
        if (!Error())    return;
        var arr = showModalDialog("./data/html/selcolor.html", "", "dialogWidth:18.5em; dialogHeight:17.5em; status:0");
        if (arr != null) obj.value = arr;
        else obj.focus();
    }
    window.onload = function () {
    }
</script>
<script src="../../data/html/postinfo.js"></script>
<body class="body_index">
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
            <a class="shead_logo" href="/admin">媒体号</a>
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
                            <li class="authors_list top"><a href="./e/space/?userid=12" target="_blank"
                                                            title="lili的个人主页">${user.username}</a>
                            </li>
                            <li class="new_logout">
                                <i class=""></i>
                                <a href="../../e/member/doaction.php?enews=exit" onclick="return confirm('确认要退出?');">退出</a>
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
                <a href="/index" class="menu_h1 selected menu_main alone"><i></i>主页</a>
            </div>
            <div class="menu_block">
                <a class="menu_h1 menu_article"><i></i>文章管理</a>
                <a href="./e/DoInfo/ListInfo.php?mid=1" class="menu_h2"><i></i>管理文章</a>
                <a href="./e/DoInfo/ChangeClass.php?mid=1" class="menu_h2">发布文章</a>
                <!--<a href="#" class="menu_h2">管理图集</a> -->
            </div>
            <!--<div class="menu_block">
            <a class="menu_h1 menu_info"><i></i>会员空间</a>
            <a href="/e/space/?userid=12" target="_blank" class="menu_h2 ">预览空间</a>
            <a href="/e/member/mspace/SetSpace.php" class="menu_h2 ">设置空间</a>
            <a href="/e/member/mspace/gbook.php" class="menu_h2 ">管理留言</a>
            </div>
            <div class="menu_block alone">
            <a href="/e/member/msg/" class="menu_h1 menu_notice alone"><i></i>通知<em class="new-messages-num" style=""></em></a>
            </div>-->
            <div class="menu_block">
                <a class="menu_h1 menu_settings"><i></i>设置</a>
                <a href="../../e/member/EditInfo" class="menu_h2 menu_account"><i></i>修改资料</a>
                <a href="../../e/member/EditInfo/EditSafeInfo.php" class="menu_h2 "><i></i>修改密码</a>
                <a href="../../e/member/my" class="menu_h2 "><i></i>账号状态</a>
                <a href="../../e/member/friend" class="menu_h2 "><i></i>好友列表</a>
                <a href="./e/memberconnect/ListBind.php" class="menu_h2 "><i></i>绑定外部登录</a>
            </div>
        </div>
        <div class="stage formbox">
            <form name="add" method="POST" id="form1" action="/news/publish" >
                <div class="">
                    <div class="page_tabs sclearfix" style="border:none;border-bottom: 1px solid #d8dce4;">
                        <div class="page_tab selected"
                             style="border:none;border-bottom: 2px solid #FF5F63;bottom:-1px;top:0;">增加信息
                        </div>
                    </div>
                    <div class="page_content indexpage_content" id="pagelet-write">
                        <input name="id" type="hidden" id="id" value="${news.id}">
                        <div class="edit-cell">
                            <div class="edit-main front-cover">
                                <label class="edit-label">网络新闻url</label>
                                <div class="edit-input">
                                    <div class="front-cover-type">
                                        <div class="front-cover-item">
                                            <input type="text" id ="newsurl" name="newsurl" >
                                            <input type="button" onclick="huoqu()" value="获取">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="edit-cell">
                            <div class="edit-main front-cover">
                                <label class="edit-label">提交者</label>
                                <div class="edit-input">
                                    <div class="front-cover-type">
                                        <div class="front-cover-item">
                                            <input type="text" id ="authorId" name="authorId" value="${news.authorId}" >
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="edit-cell">
                            <div class="edit-main front-cover">
                                <label class="edit-label">栏目</label>
                                <div class="edit-input">
                                    <div class="front-cover-type">
                                        <div class="front-cover-item">
                                            <select id ="typeId" name="typeId">
                                                <c:forEach items="${types}" var="item" varStatus="status">
                                                    <option value="${item.id}" <c:if test="${news.typeId == item.id}" >selected</c:if>> ${item.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="edit-main front-cover">
                            <label class="edit-label">标题</label>
                            <div class="edit-input">
                                <div class="front-cover-type">
                                    <div class="front-cover-item">
                                        <input type="text" id = "title" name="title"  size="42" value="${news.title}">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="edit-main front-cover">
                            <label class="edit-label">缩略图</label>
                            <div class="edit-input">
                                <div class="front-cover-type">
                                    <div class="front-cover-item">
                                        <form action="/upload" id="uploadForm" method="post" enctype="multipart/form-data">
                                            <input type="file" id="file" name="file" size="45" />
                                            <input type="button" onclick="upload_file()" value="确定" /></form>
                                        <input type="text" id="picUrl" name="picUrl" value="${news.picUrl}">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="">
                            <label class="edit-label">新闻正文</label>
                            <div class="">
                                <div class="front-cover-type">
                                    <div class="front-cover-item" class="container" style="width:100%">
                                        <textarea id="content" name="content" cols="60" rows="10" style="display:none;" >${news.content}</textarea>
                                        <p><br></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="modify" id="modify" value="<c:if test='${not empty news.id}'>true</c:if>">
                    <input  class="signform_btn signbasic_submit" type="submit" value="提交">
                </div>
            </form>
        </div>
    </div>
</div>
<div class="sfoot_p">
    <div class="sfoot">
        <div>
            <a href="mailto:mp@toutiao.com" class="sfoot_email">客服邮箱：xxx@xxx.com</a>|
            <a target="_blank" href="#" class="sfoot_selfservice">常见问题</a>
        </div>
        <div>
            <a target="_blank" class="sfoot_about" href="#">关于仿今日头条</a>|
            <a target="_blank" href="#" class="sfoot_agreement">用户协议</a>|
            <a target="_blank" href="#" class="sfoot_agreement">侵权投诉</a>|
            <a target="_blank" href="#" class="sfoot_contact">联系我们</a>
            &copy; 2016 仿今日头条 http://a285.wangzhanyanshi.com/
        </div>
    </div>
</div>
<div id="wx-feedback"></div>
<div id="backtop"></div>



<script type="text/javascript" src="../../js/wangEditor.js"></script>
<!--<script type="text/javascript" src="../dist/js/wangEditor.min.js"></script>-->
<script type="text/javascript">
    // 阻止输出log
    // wangEditor.config.printLog = false;

    var editor = new wangEditor('content');

    // 上传图片
    editor.config.uploadImgUrl = 'upload';
    editor.config.uploadParams = {
        // token1: 'abcde',
        // token2: '12345'
    };
    editor.config.uploadHeaders = {
        // 'Accept' : 'text/x-json'
    }
    editor.config.uploadImgFileName = 'file';

    // 隐藏网络图片
    // editor.config.hideLinkImg = true;

    // 表情显示项
    editor.config.emotionsShow = 'value';
    editor.config.emotions = {
        'default': {
            title: '默认',
            data: './emotions.data'
        },
        'weibo': {
            title: '微博表情',
            data: [
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7a/shenshou_thumb.gif',
                    value: '[草泥马]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif',
                    value: '[神马]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/fuyun_thumb.gif',
                    value: '[浮云]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif',
                    value: '[给力]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif',
                    value: '[围观]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/vw_thumb.gif',
                    value: '[威武]'
                }
            ]
        }
    };

    // 插入代码时的默认语言
    // editor.config.codeDefaultLang = 'html'

    // 只粘贴纯文本
    // editor.config.pasteText = true;

    // 跨域上传
    // editor.config.uploadImgUrl = 'http://localhost:8012/upload';

    // 第三方上传
    // editor.config.customUpload = true;

    // 普通菜单配置
    // editor.config.menus = [
    //     'img',
    //     'insertcode',
    //     'eraser',
    //     'fullscreen'
    // ];
    // 只排除某几个菜单（兼容IE低版本，不支持ES5的浏览器），支持ES5的浏览器可直接用 [].map 方法
    // editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
    //     if (item === 'insertcode') {
    //         return null;
    //     }
    //     if (item === 'fullscreen') {
    //         return null;
    //     }
    //     return item;
    // });

    // onchange 事件
    editor.onchange = function () {
        console.log(this.$txt.html());
    };

    editor.create();

</script>
<script>
    function upload_file() {
        var file = $("#file").val();
        if(file == null || file =="") {
            alert("请选择文件");
            return;
        }
        var formData = new FormData($("#uploadForm")[0]);
        $.ajaxFileUpload({
            url:"/upload",
            secureuri:false,
            fileElementId:'file',           //文件选择框的id属性
            dataType:'text',
//            data:formData,
//            asyn:false,
//            cache:false,
//            processData:false,
            success:function (data,status) {
                if(data) {
                    alert("成功");
                    $("#picUrl").attr("value",data);
                    alert($("#picUrl").val());
                }

            }
        });

    };

    function huoqu() {
        var url = $("#newsurl").val();
        var data={
            newsUrl:url
        }
        $.ajax({
            url: "/news/getByUrl",
            type: "post",
            dataType: 'json',
            data: data,
            success: function (data) {
                console.info(data);
                var type = data.type;
                var content = data.content;
                $("#content").html(content);
                editor.$txt.html(content);
                $("#gettype").val(type);
//                alert(data);
            }
        });

    }
</script>
</body>
</html>