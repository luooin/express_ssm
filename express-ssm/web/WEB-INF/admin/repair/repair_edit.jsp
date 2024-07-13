<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑报修信息</title>
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
            <h5>修改报修</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/repair/admin/edit">
                <input type="hidden" name="id" value="${repair.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label">车牌号：</label>
                    <div class="col-sm-8">
                        <select name='carId' class='form-control'>
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="cars" items="${carsList}">
                                <option value="${cars.id}" <c:if test="${repair.carId == cars.id}"> selected</c:if>>${cars.carNumber}</option>
                            </c:forEach>
                        </select>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">状态：</label>
                    <div class="col-sm-8">
                        <label><input type='radio' name='state' value='0' <c:if
                                test="${repair.state == 0}"> checked</c:if>/> 待维修</label>
                        <label><input type='radio' name='state' value='1' <c:if
                                test="${repair.state == 1}"> checked</c:if>/> 维修中</label>
                        <label><input type='radio' name='state' value='2' <c:if
                                test="${repair.state == 2}"> checked</c:if>/> 维修完成</label>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">维修原因：</label>
                    <div class="col-sm-8">
                        <textarea name='reason' id='reason' class='form-control'>${repair.reason}</textarea>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-8">
                        <button class="btn btn-sm btn-info" onclick="update('repair')">提 交</button>
                    </div>
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
