<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>快递系统</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/plugins/fullcalendar.min.css"/>
    <link href="${ctx}/static/css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${ctx}/static/js/html5shiv.min.js"></script>
    <script src="${ctx}/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body id="mimin" class="dashboard form-signin-wrapper">
<div class="container">
    <form class="form-signin" id="reg" method="post">
        <div class="panel periodic-login">
            <div class="panel-body text-center">
                <p class="atomic-mass">快递运输用户注册</p>
                <i class="icons icon-arrow-down"></i>
                <div class="form-group form-animate-text" style="margin-top:40px;">
                    <input type="text" class="form-text" name="loginname">
                    <span class="bar"></span>
                    <label>账号</label>
                </div>
                <div class="form-group form-animate-text" style="margin-top:40px;">
                    <input type="password" class="form-text" name="password">
                    <span class="bar"></span>
                    <label>密码</label>
                </div>
                <div class="form-group form-animate-text" style="margin-top:40px;">
                    <input type="text" class="form-text" name="username">
                    <span class="bar"></span>
                    <label>姓名</label>
                </div>
                <div class="form-group form-animate-text" style="margin-top:40px;">
                    <input type="text" class="form-text" name="phone">
                    <span class="bar"></span>
                    <label>电话</label>
                </div>
                <a href="${ctx}/admin/login">去登录</a>
                <input type="button" class="btn col-md-12" value="注  册" onclick="reg()"/>
            </div>
        </div>
    </form>
</div>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/jquery.ui.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<!-- plugins -->
<script src="${ctx}/static/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${ctx}/static/js/main.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<script>
    function reg() {
        $.ajax({
            url: projectName + "/user/reg",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: $('#reg').serialize(),
            success: function (data) {
                if (data.code == 'success') {
                    alert(data.msg);
                    window.location.href = projectName + "/index";
                } else {
                    alert(data.msg);
                }
            },
            error: function () {
                alert("请求失败，请稍后再试！");
            }
        });
    };
</script>
</body>
</html>
