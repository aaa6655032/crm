<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common.jsp" %>
    <link rel="stylesheet" href="/css/public.css">
    <script type="text/javascript" src="/js/views/index.js"></script>
    <script type="text/javascript" src="/js/views/welcome.js"></script>
    <style type="text/css">
        .btn-logout {
            margin-left: 10px;
            background: #ff1312 none repeat scroll 0 0;
            border-radius: 6px;
            color: #fefefe;
            display: inline;
            padding: 6px;
            text-decoration: none;
        }

        a:hover {
            margin-left: 10px;
            background: #08b72a none repeat scroll 0 0;
            border-radius: 6px;
            color: #3bd7ff;
            display: inline;
            padding: 6px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div id="cc" class="easyui-layout" fit="true" style="width:600px;height:400px;">
    <div data-options="region:'north'"
         style="height:50px;background: #d8BFd8;">
        <h1 style="text-align:center">十分感谢您能百忙中抽出时间审阅我的项目</h1>
        <div id="top">
            <div id="top_links">
                <div style="float: right;width: 200px;height:40px;">
                    <p>
                        <font style="font-size: 15px;margin-right: 10px">当前用户:${username}</font>
                        <a href="/login.jsp" class="btn-logout">安全退出</a>
                    </p>
                </div>

            </div>
        </div>
    </div>
    <div data-options="region:'west'" style="width:180px;">
        <!-- 手风琴+菜单 -->
        <div class="easyui-accordion" fit="true">
            <div title="菜单">
                <!-- 使用树组件来定义菜单 -->
                <ul id="menuTree"></ul>
            </div>
       <!--      <div title="帮助"></div> -->
            <div title="简介">
            <p style="line-height:17px;padding:10px 0">软件环境：<br>&nbsp;&nbsp;&nbsp;&nbsp;Springmvc+spring+mybaits+mysql+jQuery EasyUI</p>
            <p style="line-height:17px;padding:10px 0">项目描述：<br>&nbsp;&nbsp;&nbsp;&nbsp;根据提供的开发文档，依次实现具体功能。又结合了之前所学，将能添置的功能都填上了</p>
            <p style="line-height:17px;padding:10px 0">项目收获：<br>&nbsp;&nbsp;&nbsp;&nbsp;从了解技术到应用技术，从技术概念到实际细节，这是一个痛苦而又兴奋的过程。<br>&nbsp;&nbsp;&nbsp;&nbsp;痛苦的是说起来简单做起来难。兴奋的是不断的将知识转化为自己的技能、不断的对编程有更深入的认识，这是很舒爽的一个过程。</p>
            </div>
        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        <!-- 正文内容 -->
        <div id="myTabs" class="easyui-tabs" fit="true">
            <div title="欢迎页" closable="true">
                <%--<center><h1>欢迎登陆系统</h1></center>
--%>
                <div id="pp">
                    <div style="width:20%"></div>
                    <div style="width:55%"></div>
                    <div style="width:25%"></div>
                </div>


            </div>
        </div>
    </div>
   
</div>
</body>
</html>
