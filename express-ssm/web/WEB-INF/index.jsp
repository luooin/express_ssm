<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>管理系统</title>
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
<body id="mimin" class="dashboard">
<%
    String yonghuming = (String) session.getAttribute("userName");
    Integer yonghuid = (Integer) session.getAttribute("user_id");
    Integer juesea = (Integer) session.getAttribute("user_level");
    if(yonghuming == null || yonghuming == "" && juesea == null){
    out.print("<script>window.location.href='/login';</script>");
    out.close();
}
%>
<div id="wrapper">
    <!--header 开始-->
    <nav class="navbar navbar-default header navbar-fixed-top">
        <div class="col-md-12 nav-wrapper">
            <div class="navbar-header" style="width:100%;">
                <a href="index.html" class="navbar-brand"> <b>快递管理系统</b> </a>
                <ul class="nav navbar-nav navbar-right user-nav">
                    <li class="user-name"><span></span></li>
                    <li class="dropdown avatar-dropdown"> <img src="static/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                        <ul class="dropdown-menu user-dropdown">
                            <li><a href="/express-ssm/loginout"><span class="fa fa-power-off"></span> 退出登录</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- header 结束 -->
    <!--左侧导航开始-->
    <div class="container-fluid mimin-wrapper">
        <!-- start:Left Menu -->
        <div id="left-menu">
            <div class="sub-left-menu scroll">
                <ul class="nav nav-list">
                    <li>
                        <div class="left-bg"></div>
                    </li>
<c:if test="<%= juesea ==0%>">
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-1">
                            <span class="fa-diamond fa"></span>管理员管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/admin/admin/query">管理员管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/admin/admin/page/add">添加管理员</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-2">
                            <span class="fa-diamond fa"></span>车源管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/cars/admin/query">车源管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/cars/admin/page/add">添加车源</a></li>
                        </ul>
                    </li>
</c:if>
<c:if test="<%= juesea ==0 || juesea ==2%>">
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-3">
                            <span class="fa-diamond fa"></span>投诉管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/complaint/admin/query">投诉管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/complaint/admin/page/add">添加投诉</a></li>
                        </ul>
                    </li>
</c:if>
<c:if test="<%= juesea ==0%>">
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-4">
                            <span class="fa-diamond fa"></span>司机管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/drivers/admin/query">司机管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/drivers/admin/page/add">添加司机</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-5">
                            <span class="fa-diamond fa"></span>发货单管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/invoice/admin/query">发货单管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/invoice/admin/page/add">添加发货单</a></li>
                        </ul>
                    </li>
</c:if>
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-6">
                            <span class="fa-diamond fa"></span>订单管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/orders/admin/query">订单管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/orders/admin/page/add">添加订单</a></li>
                        </ul>
                    </li>
<c:if test="<%= juesea ==0 || juesea ==1%>">
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-7">
                            <span class="fa-diamond fa"></span>报修管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/repair/admin/query">报修管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/repair/admin/page/add">添加报修</a></li>
                        </ul>
                    </li>
</c:if>
                    <c:if test="<%= juesea ==0%>">
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-8">
                            <span class="fa-diamond fa"></span>站点管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/sites/admin/query">站点管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/sites/admin/page/add">添加站点</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-9">
                            <span class="fa-diamond fa"></span>用户管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <li><a class="J_menuItem" href="${ctx}/users/admin/query">用户管理</a></li>
                            <li><a class="J_menuItem" href="${ctx}/users/admin/page/add">添加用户</a></li>
                        </ul>
                    </li>
                    <li class="ripple">
                        <a class="tree-toggle nav-header"  id="left-menu-10">
                            <span class="fa-diamond fa"></span>统计管理<span class="fa-angle-right fa right-arrow text-right"></span>
                        </a>
                        <ul class="nav nav-list tree" >
                            <%--<li><a class="J_menuItem" href="${ctx}/sites/admin/page/statistics">站点繁忙度</a></li>--%>
                            <li><a class="J_menuItem" href="${ctx}/sites/admin/page/achievement">区域业绩</a></li>
                            <li><a class="J_menuItem" href="${ctx}/drivers/admin/page/statistics">司机业绩</a></li>
                        </ul>
                    </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="content">
        <div class="J_mainContent" id="content-main" style="height:100%">
            <iframe id="J_iframe" width="100%" height="100%" frameborder="0"></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/jquery.ui.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<!-- plugins -->
<script src="${ctx}/static/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${ctx}/static/js/index.js"></script>
<script src="${ctx}/static/js/main.js"></script>
<!-- end: Javascript -->
<script>
    $("#left-menu-1").click() ;
</script>
</body>
</html>
