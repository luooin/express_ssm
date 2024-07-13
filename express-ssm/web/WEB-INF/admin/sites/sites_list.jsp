<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>站点信息列表</title>
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
            <h5>站点列表</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form method="post" action="${ctx}/sites/admin/query" id="ajaxForm">
                <table class="table table-bordered table-hover dataTables">
                    <thead>
                    <tr>
                        <th width="50">序号</th>
                        <th>站点编号</th>
                        <th>站点名称</th>
                        <th>承载量/件</th>
                        <th width="180">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach varStatus="status" var="sites" items="${sitesList}">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${sites.region}</td>
                            <td>${sites.siteName}</td>
                            <td>${sites.capacity}</td>
                            <td>
                                <a class="btn btn-info" href="${ctx}/sites/admin/page/edit/${sites.id}">编辑</a>
                                <a class="btn btn-danger" href="javascript:;"
                                   onclick="delObj(${sites.id},'sites')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
            <div class='pagelist'>${page}</div>
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
