<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑车源信息</title>
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
            <h5>修改车源</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/cars/admin/edit">
                <input type="hidden" name="id" value="${cars.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label">车牌号：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='carNumber' value='${cars.carNumber}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">司机：</label>
                    <div class="col-sm-8">
                        <select name='drivers' class='form-control'>
                            <option>请选择</option>
                            <c:forEach varStatus="status" var="drivers" items="${driversList}">
                                <option value="${drivers.id}" <c:if test="${cars.drivers == drivers.id}">selected</c:if>>${drivers.username}</option>
                            </c:forEach>
                        </select>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">车身颜色：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='colour' value='${cars.colour}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">状态：</label>
                    <div class="col-sm-8">
                        <label><input type='radio' name='state' value='0' <c:if
                                test="${cars.state == 0}"> checked</c:if>/> 空闲</label>
                        <label><input type='radio' name='state' value='1' <c:if
                                test="${cars.state == 1}"> checked</c:if>/> 使用</label>
                        <label><input type='radio' name='state' value='3' <c:if
                                test="${cars.state == 3}"> checked</c:if>/> 报修</label>
                        <label><input type='radio' name='state' value='4' <c:if
                                test="${cars.state == 4}"> checked</c:if>/> 维修中</label>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">车载重量/千克：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='loadCap' value='${cars.loadCap}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-8">
                        <button class="btn btn-sm btn-info" onclick="update('cars')">提 交</button>
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
