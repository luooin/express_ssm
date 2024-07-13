<%@ page language="java" pageEncoding="UTF-8" %>
<%-- <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- <%@ include file="/WEB-INF/admin/common/taglibs.jsp"%> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>司机统计</title>
    <link href="${ctx}/static/css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${ctx}/static/js/html5shiv.min.js"></script>
    <script src="${ctx}/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body >
<div class="form-element panel admin-panel">
    <div class="panel-body">
        <div class="col-sm-12">
            <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <input type="hidden" id="ctx" value="${ctx}">
                        <input type="text" placeholder="开始时间" class="form-control" name="startDate" id="startDate">
                        <input type="text" placeholder="结束时间" class="form-control" name="endDate" id="endDate">
                        <button class="btn btn-danger" type="button" onclick="search2();">提 交</button>
                    </div>
                    <div class="ibox-content">
                        <div id="main" style="width: 90%;height:400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/plugins/echarts-all.js"></script>
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
        lay('#startDate, #endDate').each(function(){
            laydate.render({
                elem: this
                ,trigger: 'click'
            });
        });
    });
    function search2(){
        var myChart = echarts.init(document.getElementById('main'));
        var stime = $('#startDate').val();
        var etime = $('#endDate').val();
        var url =  $('#ctx').val() +"/sites/admin/achievement?startDate=" + stime + "&endDate=" + etime;
        $.ajax({
            type: "POST",
            async: false,
            url: url,
            contentType: "text/json; charset=utf-8",
            success: function (data) {
                myChart.setOption({
                    title: {
                        text: "区域业绩绩统计"
                    },
                    calculable: true,
                    xAxis: [
                        {
                            name: "日期",
                            type: 'category',
                            data: data.result.xx
                        }
                    ],
                    yAxis: [
                        {
                            name: "工作量",
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name:  "业绩统计",
                            type: 'line',
                            data: data.result.yy,
                            itemStyle: {
                                normal: {
                                    color:'#C1232B',
                                    label : {show: true}
                                }
                            }
                        }]
                });
            },
            error: function (data) {
                alert("提交失败");
            }
        });
    }
</script>
</body>
</html>
