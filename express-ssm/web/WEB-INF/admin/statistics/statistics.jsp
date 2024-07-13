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
    <title>销售统计</title>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-body">
        <form method="post" class="form-x layui-form" id="ajaxForm">
        <div class="col-sm-12">
            <div class="row">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div id="main" style="width: 90%;height:400px;"></div>
                        <input type="hidden" id="ctx" value="${ctx}">
                        <input type="hidden" id="userId" value="${id}">
                        <input type="hidden" id="countType" value="${type}">
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/js/plugins/echarts-all.js"></script>
<script>
    $(document).ready(function () {
        var myChart = echarts.init(document.getElementById('main'));
        var url =  $('#ctx').val() +"/sites/admin/statistics";
        $.ajax({
            type: "POST",
            async: false,
            url: url,
            contentType: "text/json; charset=utf-8",
            success: function (data) {
                myChart.setOption({
                    title: {
                        text: "站点繁忙度统计（为1时，为饱满状态）"
                    },
                    calculable: true,
                    xAxis: [
                        {
                            name: "站点名称",
                            type: 'category',
                            data: data.result.xx
                        }
                    ],
                    yAxis: [
                        {
                            name: "繁忙度",
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name:  "繁忙度",
                            type: 'bar',
                            data: data.result.yy,
                            itemStyle: {
                                normal: {
                                    color:'#C1232B'
                                }
                            }
                        }]
                });
            },
            error: function (data) {
                alert("提交失败");
            }
        });
    });
</script>
</body>
</html>
