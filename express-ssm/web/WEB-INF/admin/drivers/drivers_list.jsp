<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>司机信息列表</title>
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
<div class="form-element">
    <div class="panel form-element-padding">
        <div class="panel-heading">
            <h5>司机列表</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form method="post" action="${ctx}/drivers/admin/query" id="ajaxForm">
                <table class="table table-bordered table-hover dataTables">
                    <thead>
                    <tr>
                        <th width="50">序号</th>
                        <th>姓名</th>
                        <th>登录名</th>
                        <th>密码</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>入职日期</th>
                        <th>驾驶证级别</th>
                        <th width="180">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach varStatus="status" var="drivers" items="${driversList}">
                        <tr>
                            <td>${status.index+1}</td>
                            <td title="年龄：${drivers.age}岁，入职日期：<fmt:formatDate value="${drivers.entryDay}" pattern="yyyy-MM-dd"/>">${drivers.username}</td>
                            <td>${drivers.loginname}</td>
                            <td>${drivers.password}</td>
                            <td>${drivers.age}</td>
                            <td>
                                <div align='center'>
                                    <c:if test="${drivers.sex == 0}">
                                        男
                                    </c:if>
                                    <c:if test="${drivers.sex == 1}">
                                        女
                                    </c:if>
                                </div>
                            </td>
                            <td>${drivers.phone}</td>
                            <td><fmt:formatDate value="${drivers.entryDay}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <c:if test="${drivers.drivinglicense == 1}">A1</c:if>
                                <c:if test="${drivers.drivinglicense == 2}">A2</c:if>
                                <c:if test="${drivers.drivinglicense == 3}">A3</c:if>
                                <c:if test="${drivers.drivinglicense == 4}">B1</c:if>
                                <c:if test="${drivers.drivinglicense == 5}">B2</c:if>
                                <c:if test="${drivers.drivinglicense == 6}">C1</c:if>
                                <c:if test="${drivers.drivinglicense == 7}">C2</c:if>
                                <c:if test="${drivers.drivinglicense == 8}">C3</c:if>
                                <c:if test="${drivers.drivinglicense == 9}">C4</c:if>
                                <c:if test="${drivers.drivinglicense == 10}">D</c:if>
                                <c:if test="${drivers.drivinglicense == 11}">E</c:if>
                                <c:if test="${drivers.drivinglicense == 12}">F</c:if>
                                <c:if test="${drivers.drivinglicense == 13}">M</c:if>
                                <c:if test="${drivers.drivinglicense == 14}">N</c:if>
                                <c:if test="${drivers.drivinglicense == 15}">P</c:if>
                            </td>
                            <td>
                                <a class="btn btn-info" href="${ctx}/drivers/admin/page/edit/${drivers.id}">编辑</a>
                                <a class="btn btn-danger" href="javascript:;" onclick="delObj(${drivers.id},'drivers')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/jquery.ui.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<!-- plugins -->
<script src="${ctx}/static/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${ctx}/static/js/main.js"></script>
<!-- end: Javascript -->
<script>
    $("#left-menu-2").click();
</script>
</body>
</html>
