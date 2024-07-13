<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加订单信息</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/plugins/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.css" rel="stylesheet">
</head>
<%
    String yonghuming = (String) session.getAttribute("userName");
    Integer yonghuid = (Integer) session.getAttribute("user_id");
    Integer juesea = (Integer) session.getAttribute("user_level");
    if(yonghuming == null || yonghuming == "" && juesea == null){
        out.print("<script>window.location.href='/login';</script>");
        out.close();
    }
%>
<c:set var="user_id" value="${sessionScope.user_id}"/>
<body id="mimin" class="dashboard">
<div class="form-element">
    <div class="panel form-element-padding">
        <div class="panel-heading">
            <h5>添加订单</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/orders/admin/add">
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户ID：</label>
                    <div class="col-sm-8">
                        <select name="userId" class="form-control">
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="users" items="${usersList}">
                                <c:if test="<%= juesea ==0%>">
                                    <option value="${users.id}">${users.username}</option>
                                </c:if>
                                <c:if test="<%= juesea ==2%>">
                                    <c:if test="${users.id == user_id}">
                                        <option value="${users.id}" selected>${users.username}</option>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">发货站：</label>
                    <div class="col-sm-8">
                        <select name="startSite" class="form-control">
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="sites" items="${sitesList}">
                                <option value="${sites.id}">${sites.region}-${sites.siteName}</option>
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
                                <option value="${sites.id}">${sites.region}-${sites.siteName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">寄件人电话：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="userPhone">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">寄件人地址：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="userAddress">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">运费：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="freight">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">重量/千克：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="weight">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">体积/立方厘米：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="volume">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">收件人：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="receiver">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">收件人电话：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="receiverPhone">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">收件人地址：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="receiverAddress">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">商品名：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="goodsName">
                    </div>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label class="col-sm-3 control-label">状态：</label>--%>
                    <%--<div class="col-sm-8">--%>
                        <%--<div class="radio radio-inline i-checks">--%>
                            <%--<label><input type="radio" name="state" checked value="0"/> <i></i>待收</label>--%>
                        <%--</div>--%>
                        <%--<div class="radio radio-inline i-checks">--%>
                            <%--<label><input type="radio" name="state" value="1"/> <i></i>已收</label>--%>
                        <%--</div>--%>
                        <%--<div class="radio radio-inline i-checks">--%>
                            <%--<label><input type="radio" name="state" value="2"/> <i></i>运输中</label>--%>
                        <%--</div>--%>
                        <%--<div class="radio radio-inline i-checks">--%>
                            <%--<label><input type="radio" name="state" value="3"/> <i></i>派送中</label>--%>
                        <%--</div>--%>
                        <%--<div class="radio radio-inline i-checks">--%>
                            <%--<label><input type="radio" name="state" value="4"/> <i></i>已签收</label>--%>
                        <%--</div>--%>
                        <%--<div class="radio radio-inline i-checks">--%>
                            <%--<label><input type="radio" name="state" value="5"/> <i></i>已退货</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
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
<!-- Peity -->
<script src="${ctx}/static/js/plugins/icheck.min.js"></script>
<!-- jQuery Validation plugin javascript-->
<script src="${ctx}/static/js/plugins/jquery.validate.min.js"></script>
<script src="${ctx}/static/js/plugins/laydate/laydate.js"></script>
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
