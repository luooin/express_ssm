<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>编辑司机信息</title>
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
            <h5>修改司机</h5>
        </div>
        <div class="panel-body" style="padding-bottom:30px;">
            <form class="form-horizontal" method="post" id="commentForm" enctype="multipart/form-data"
                  action="${ctx}/drivers/admin/edit">
                <input type="hidden" name="id" value="${drivers.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户名：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='loginname' value='${drivers.loginname}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='password' value='${drivers.password}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='username' value='${drivers.username}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">性别：</label>
                    <div class="col-sm-8">
                        <label><input type='radio' name='sex' value='0' <c:if
                                test="${drivers.sex == 0}"> checked</c:if>/> 男</label>
                        <label><input type='radio' name='sex' value='1' <c:if
                                test="${drivers.sex == 1}"> checked</c:if>/> 女</label>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">年龄：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='age' value='${drivers.age}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">电话：</label>
                    <div class="col-sm-8">
                        <input type='text' class='form-control' name='phone' value='${drivers.phone}'>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">入职日期：</label>
                    <div class="col-sm-8">
                        <input type="text" placeholder="入职日期"
                               value='<fmt:formatDate value="${drivers.entryDay}" pattern="yyyy-MM-dd"/>'
                               class="form-control" name="entryDay" id="entryDay">
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">驾驶证级别：</label>
                    <div class="col-sm-8">
                        <select name="drivinglicense" class="form-control">
                            <option>请选择</option>
                            <option value="1" <c:if test="${drivers.drivinglicense == 1}"> selected</c:if>>A1</option>
                            <option value="2" <c:if test="${drivers.drivinglicense == 2}"> selected</c:if>>A2</option>
                            <option value="3" <c:if test="${drivers.drivinglicense == 3}"> selected</c:if>>A3</option>
                            <option value="4" <c:if test="${drivers.drivinglicense == 4}"> selected</c:if>>B1</option>
                            <option value="5" <c:if test="${drivers.drivinglicense == 5}"> selected</c:if>>B2</option>
                            <option value="6" <c:if test="${drivers.drivinglicense == 6}"> selected</c:if>>C1</option>
                            <option value="7" <c:if test="${drivers.drivinglicense == 7}"> selected</c:if>>C2</option>
                            <option value="8" <c:if test="${drivers.drivinglicense == 8}"> selected</c:if>>C3</option>
                            <option value="9" <c:if test="${drivers.drivinglicense == 9}"> selected</c:if>>C4</option>
                            <option value="10" <c:if test="${drivers.drivinglicense == 10}"> selected</c:if>>D</option>
                            <option value="11" <c:if test="${drivers.drivinglicense == 11}"> selected</c:if>>E</option>
                            <option value="12" <c:if test="${drivers.drivinglicense == 12}"> selected</c:if>>F</option>
                            <option value="13" <c:if test="${drivers.drivinglicense == 13}"> selected</c:if>>M</option>
                            <option value="14" <c:if test="${drivers.drivinglicense == 14}"> selected</c:if>>N</option>
                            <option value="15" <c:if test="${drivers.drivinglicense == 15}"> selected</c:if>>P</option>
                        </select>
                        <div class='tip1'></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-8">
                        <button class="btn btn-sm btn-info" onclick="update('drivers')">提 交</button>
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
