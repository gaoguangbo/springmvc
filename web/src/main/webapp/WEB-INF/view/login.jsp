<%--
  Created by IntelliJ IDEA.
  User: MiaoJinlong
  Date: 2017/5/13
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
</head>
<body>
<div class="login_container">
    <div class="wrapper">
        <div class="login_header">
            <span class = "title">登录</span>
        </div>
        <div class="section">
            <div class="section_header">
                <a href="regist.jsp">去注册<<</a>
            </div>
            <div class="section_login">
                <form action = "/regist/login", method = "post">
                    <input type="hidden" value = "${msg}"/>
                    <input type="text" name="username" class = "input_ctrl" placeholder="用户名">
                    <input type="text" name="password" class = "input_ctrl" placeholder="密码">
                    <input type="submit" name="" class = "input_sub" value = "登录">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html></html>
