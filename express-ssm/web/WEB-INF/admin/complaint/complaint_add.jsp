<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加投诉信息</title>
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
            <h5>添加投诉信息</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/complaint/admin/add">
                <div class="form-group">
                    <label class="col-sm-3 control-label">订单ID：</label>
                    <div class="col-sm-8">
                        <select name="orderId" class="form-control">
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="orders" items="${orderList}">
                                <option value="${orders.id}">${orders.orderNum}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">投诉内容：</label>
                    <div class="col-sm-8">
                        <textarea name="content" class='form-control'></textarea>
                    </div>
                </div>
                <div class="col-md-12 text-center">
                    <button class="btn btn-danger" onclick="update('complaint')">提 交</button>
                </div>
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
