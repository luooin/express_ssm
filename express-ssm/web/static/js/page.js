var positive = false;
var negative = false;
var maxValue = 999999999;
var minValue = -999999999;
var dft = 0;
function isEmpty(input) {
    return (input == null || input.length == 0)
}
function isInt(input) {
    if (isEmpty(input) || (isNaN(input))) {
        return false;
    }
    return (!isNaN(parseInt(input, 10)));
}
function toInt(input) {
    return (isInt(input)) ? parseInt(input, 10) : dft;
}
function doBlur(element) {
    var tmp = toInt(element.value);
    if (element.positive == 'true') {
        tmp = Math.abs(tmp);
        if (element.maxValue != null) {
            var tmpMax = toInt(element.maxValue);
            if (tmp > tmpMax) {
                tmp = tmpMax;
            }
        }
        element.value = Math.abs(tmp);
        return;
    }
    if (element.negative == 'true') {
        tmp = Math.abs(tmp) * -1;
        if (element.minValue != null) {
            var tmpMin = toInt(element.minValue);
            if (tmp < tmpMin) {
                tmp = tmpMin;
            }
        }
        element.value = Math.abs(tmp) * -1;
        return;
    }
    if (element.maxValue != null) {
        var tmpMax = toInt(element.maxValue);
        if (tmp > tmpMax) {
            tmp = tmpMax;
        }
    }
    if (element.minValue != null) {
        var tmpMin = toInt(element.minValue);
        if (tmp < tmpMin) {
            tmp = tmpMin;
        }
    }
    element.value = toInt(tmp);
    return;
}
function go(num, obj) {
    if (num == null || num == '') {
        alert('请输入页码！');
        return;
    }
    var pageform = window.document.getElementById('ajaxForm');
    var pageSize = window.document.getElementById('pageSize');
    if(pageSize.value > 0 && pageSize.value <= 50){
        pageSize = pageSize.value;
        pageform.action = pageform.action + '?pageNum=' + num + '&pageSize=' + pageSize;
    } else {
        pageform.action = pageform.action + '?pageNum=' + num
    }
    pageform.submit();
    $('#loading').show();
    for (var i = 0; i < pageform.length; i++) {
        pageform[i].disabled = true;
    }
}
function goto(thisPage, totalPage, obj) {
    var gotoPageObject = window.document.getElementById('gotoPage');
    var gotoPage = gotoPageObject.value;
    var reg = /^[0-9]*$/;
    if (!reg.test(gotoPage)) {
        gotoPageObject.focus();
        alert('你输入的页码有误请重新输入!');
        gotoPageObject.value = 1;
        return;
    }
    else if (gotoPage > totalPage) {
        alert('你输入的页码大于最大页，请重新输入！');
        return;
    }
    go(gotoPage, obj);
}
