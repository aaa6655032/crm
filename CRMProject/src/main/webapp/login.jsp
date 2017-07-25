<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目展示：welcome</title>
    <link rel="stylesheet" href="/css/style.css">
    <%@include file="/WEB-INF/views/common.jsp"%>
    <script type="text/javascript">
        // 提交登录账号和密码:把账号和密码传递到后台
        function submitForm() {
            console.log($("form").serialize());
            $.ajax({
                type: "POST",
                url: "/login",
                dataType: "json",
                data: $("form").serialize(),
                success: function(data){
                   if(data.success){
                        window.location.href="/index";
                   }else{
                       $.messager.alert("温馨提示",data.msg,"warning");
                   }
                }
            });
        }
        // 清除账号和密码
        function resetForm() {
            $("form").form("clear");
        }
        
    </script>
</head>
<body>

<div id="con">
    <div class="left">
    <form method="post">
        <div class="right">
            <input type="text" name="username" placeholder="请输入用户名">
            <input type="password" name="password" placeholder="请输入密码">
            <input type="button" value='登录' onclick="submitForm();">
        </div>
    </form>
</div>

</body>
</html>