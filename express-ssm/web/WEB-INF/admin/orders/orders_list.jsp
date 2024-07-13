<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>订单信息列表</title>
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
            <h5>订单列表</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form method="post" action="${ctx}/orders/admin/query" id="ajaxForm">
                <div class="row filter">
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单编号：<input type="text"  name="orderNum"></label>
                    <input type="submit" value="搜索" id="search" class="btn btn-primary">
                </div>
            </form>
                <table class="table table-bordered table-hover dataTables">
                    <thead>
                    <tr>
                        <th width="50">序号</th>
                        <th>订单编号</th>
                        <th>寄件人</th>
                        <th>寄件人电话</th>
                        <th>寄件人地址</th>
                        <th>运费</th>
                        <th>体积</th>
                        <th>重量</th>
                        <th>下单时间</th>
                        <th>收件人</th>
                        <th>收件人电话</th>
                        <th>收件人地址</th>
                        <th>商品名</th>
                        <th>发货站</th>
                        <th>目的站</th>
                        <th>状态</th>
                        <th width="180">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach varStatus="status" var="orders" items="${ordersList}">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${orders.orderNum}</td>
                            <td>${orders.userName}</td>
                            <td>${orders.userPhone}</td>
                            <td>${orders.userAddress}</td>
                            <td>${orders.freight}</td>
                            <td>${orders.volume}</td>
                            <td>${orders.weight}</td>
                            <td><fmt:formatDate value="${orders.orderTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                            <td>${orders.receiver}</td>
                            <td>${orders.receiverPhone}</td>
                            <td>${orders.receiverAddress}</td>
                            <td>${orders.goodsName}</td>
                            <td>
                                <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                    <c:if test="${orders.startSite == sites.id}">${sites.region}-${sites.siteName}</c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                    <c:if test="${orders.endSite == sites.id}">${sites.region}-${sites.siteName}</c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <div align='center'>
                                    <c:if test="${orders.state == 10}">
                                        待付款
                                    </c:if>
                                    <c:if test="${orders.state == 0}">
                                        待收
                                    </c:if>
                                    <c:if test="${orders.state == 1}">
                                        已收
                                    </c:if>
                                    <c:if test="${orders.state == 2}">
                                        运输中
                                    </c:if>
                                    <c:if test="${orders.state == 3}">
                                        派送中
                                    </c:if>
                                    <c:if test="${orders.state == 4}">
                                        已签收
                                    </c:if>
                                    <c:if test="${orders.state == 5}">
                                        已退货
                                    </c:if>
                                </div>
                            </td>
                            <td>
                                <c:if test="${orders.state == 10}">
                                    <a class="btn btn-info" href="${ctx}/orders/admin/page/pay/${orders.id}">支付</a>
                                </c:if>
                                <c:if test="${orders.state != 10}">
                                    <a class="btn btn-info" href="${ctx}/orders/admin/page/edit/${orders.id}">编辑</a>
                                </c:if>
                                <a class="btn btn-danger" href="javascript:;"
                                   onclick="delObj(${orders.id},'orders')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
<script src="${ctx}/static/js/page.js"></script>
<!-- end: Javascript -->
<script>
    $("#left-menu-2").click();
</script>
</body>
</html>
