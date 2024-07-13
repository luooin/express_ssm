<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加司机信息</title>
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
            <h5>添加司机信息</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/drivers/admin/add">
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户名：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="loginname">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">性别：</label>
                    <div class="col-sm-8">
                        <label><input type="radio" name="sex" value="0"/> 男</label>
                        <label><input type="radio" name="sex" value="1"/> 女</label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">年龄：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="age">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">电话：</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="phone">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">入职日期：</label>
                    <div class="col-sm-8">
                        <input type="text" placeholder="入职日期" class="form-control" name="entryDay" id="entryDay">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">驾驶证级别：</label>
                    <div class="col-sm-8">
                        <select name="drivinglicense" class="form-control">
                            <option>请选择</option>
                            <option value="1">A1</option>
                            <option value="2">A2</option>
                            <option value="3">A3</option>
                            <option value="4">B1</option>
                            <option value="5">B2</option>
                            <option value="6">C1</option>
                            <option value="7">C2</option>
                            <option value="8">C3</option>
                            <option value="9">C4</option>
                            <option value="10">D</option>
                            <option value="11">E</option>
                            <option value="12">F</option>
                            <option value="13">M</option>
                            <option value="14">N</option>
                            <option value="15">P</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-12 text-center">
                    <button class="btn btn-danger" onclick="update('drivers')">提 交</button>
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
<script src="${ctx}/static/js/plugins/laydate/laydate.js"></script>
<!-- custom -->
<script src="${ctx}/static/js/main.js"></script>
<!-- end: Javascript -->
<script>
    $("#left-menu-2").click();
    $(function () {
        laydate.render({
            elem: '#entryDay' //指定元素
        });
    });
</script>
</body>
</html>
