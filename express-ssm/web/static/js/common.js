var projectName = "/express-ssm";
/*删除*/
function delObj(id, name) {
    var url = projectName +"/" + name + "/admin/del/" + id;
    var msgConfirm = confirm("确定要删除吗？");
    if(msgConfirm == true){
        $.ajax({
            url: url,
            contentType: "application/json", /*必须有*/
            dataType: "json", /*表示返回值类型，不必须*/
            success: function (data) {
                alert(data.msg);
                if (data.code == 'success') {
                    window.location.href = projectName +"/" + name + "/admin/query";
                }
            },
            error: function () {
                alert("删除失败请重试！");
            }
        });
    }
};
/*登录*/
function login() {
    var url = projectName + "/admin/login";
    $.ajax({
        url: url,
        contentType: "application/json", /*必须有*/
        dataType: "json", /*表示返回值类型，不必须*/
        data: $('#ajaxForm').serialize(),
        success: function (data) {
            if (data.code == 'success') {
                window.location.href = projectName + "/admin/index";
            }else {
                alert(data.msg);
            }
        },
        error: function () {
            alert("请求失败，请稍后再试！");
        }
    });
};
/*添加和编辑*/
function update(name) {
    /*表单提交*/
    $("#commentForm").unbind('submit').submit(function (envent) {
        envent.preventDefault();//阻止页面刷新
        var form = $(this);
        $.ajax({
            url: form.attr("action"),
            type: form.attr("method"),
            data: form.serialize(),
            contentType: "application/x-www-form-urlencoded;charset=utf-8", /*必须有*/
            dataType: "json",
            beforeSend: function () {
                $("#ajax-loader").show();
            },
            error: function () {
                alert("操作失败请重试！");
            },
            complete: function () {
                $("#ajax-loader").hide();
            },
            success: function (data) {
                alert(data.msg);
                if (data.code == 'success') {
                    window.location.href = projectName + "/" + name + "/admin/query";
                }
            }
        });
    });
}
