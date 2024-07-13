<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>快递列表</title>
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
        <div class="panel-body" style="padding-bottom:30px;">
            <h2 class="text-center" style="padding: 100px 0">快递运输管理系统</h2>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/jquery.ui.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
</body>
</html>
