<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>发货单信息列表</title>
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
            <h5>发货单列表</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form method="post" action="${ctx}/invoice/admin/query" id="ajaxForm">
                <table class="table table-bordered table-hover dataTables">
                    <thead>
                    <tr>
                        <th width="50">序号</th>
                        <th>车源</th>
                        <th>司机</th>
                        <th>发货日期</th>
                        <th>完成日期</th>
                        <th>发货站</th>
                        <th>目的站</th>
                        <th>状态</th>
                        <th width="180">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach varStatus="status" var="invoice" items="${invoiceList}">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>
                                <c:forEach varStatus="status" var="cars" items="${carsList}">
                                    <c:if test="${invoice.car == cars.id}">${cars.carNumber}</c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach varStatus="status" var="drivers" items="${driversList}">
                                    <c:if test="${invoice.driver == drivers.id}">${drivers.username}</c:if>
                                </c:forEach>
                            </td>
                            <td><fmt:formatDate value="${invoice.sendTime}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${invoice.endTime}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                    <c:if test="${invoice.startSite == sites.id}">${sites.region}-${sites.siteName}</c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                    <c:if test="${invoice.endSite == sites.id}">${sites.region}-${sites.siteName}</c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <div align='center'>
                                    <c:if test="${invoice.state == 0}">
                                        派送中
                                    </c:if>
                                    <c:if test="${invoice.state == 1}">
                                        完成
                                    </c:if>
                                </div>
                            </td>
                            <td>
                                <c:if test="${invoice.state == 0}">
                                <a class="btn btn-info" href="${ctx}/invoice/admin/page/edit/${invoice.id}">编辑</a>
                                </c:if>
                                <a class="btn btn-danger" href="javascript:;" onclick="delObj(${invoice.id},'invoice')">删除</a>
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
