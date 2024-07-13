<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑订单信息</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.css" rel="stylesheet">
</head>
<body id="mimin" class="dashboard">
<div class="form-element">
    <div class="panel form-element-padding">
        <div class="panel-heading">
            <h5>编辑订单</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/orders/admin/edit">
                <input type="hidden" name="id" value="${orders.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户ID：</label>
                    <div class="col-sm-8">
                        <select name="userId" class="form-control" readonly>
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="users" items="${usersList}">
                                <c:if test="${orders.userId == users.id}">
                                    <option value="${users.id}" selected>${users.username}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">订单编号：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='orderNum' value='${orders.orderNum}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">发货站：</label>
                    <div class="col-sm-8">
                        <select name="startSite" class="form-control">
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                <option value="${sites.id}" <c:if test="${orders.startSite == sites.id}">selected</c:if>>${sites.region}-${sites.siteName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">目的站：</label>
                    <div class="col-sm-8">
                        <select name="endSite" class="form-control">
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                <option value="${sites.id}" <c:if test="${orders.endSite == sites.id}">selected</c:if>>${sites.region}-${sites.siteName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">寄件人电话：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='userPhone' value='${orders.userPhone}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">寄件人地址：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='userAddress'
                               value='${orders.userAddress}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">运费：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='freight' value='${orders.freight}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">重量：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='weight' value='${orders.weight}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">体积：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='volume' value='${orders.volume}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">收件人：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='receiver' value='${orders.receiver}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">收件人电话：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='receiverPhone'
                               value='${orders.receiverPhone}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">收件人地址：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='receiverAddress'
                               value='${orders.receiverAddress}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">商品名：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='goodsName' value='${orders.goodsName}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">状态：</label>
                    <div class="col-sm-8">
                        <div class="radio radio-inline i-checks">
                            <label><input type='radio' name='state' value='0' <c:if
                                    test="${orders.state == 0}"> checked</c:if>/> <i></i> 待收</label>
                        </div>
                        <div class="radio radio-inline i-checks">
                            <label><input type='radio' name='state' value='1' <c:if
                                    test="${orders.state == 1}"> checked</c:if>/> <i></i> 已收</label>
                        </div>
                        <div class="radio radio-inline i-checks">
                            <label><input type='radio' name='state' value='2' <c:if
                                    test="${orders.state == 2}"> checked</c:if>/> <i></i> 运输中</label>
                        </div>
                        <div class="radio radio-inline i-checks">
                            <label><input type='radio' name='state' value='3' <c:if
                                    test="${orders.state == 3}"> checked</c:if>/> <i></i> 派送中</label>
                        </div>
                        <div class="radio radio-inline i-checks">
                            <label><input type='radio' name='state' value='4' <c:if
                                    test="${orders.state == 4}"> checked</c:if>/> <i></i> 已签收</label>
                        </div>
                        <div class="radio radio-inline i-checks">
                            <label><input type='radio' name='state' value='5' <c:if
                                    test="${orders.state == 5}"> checked</c:if>/> <i></i> 已退货</label>
                        </div>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-8">
                        <button class="btn btn-sm btn-info" onclick="update('orders')">提 交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>
</html>
