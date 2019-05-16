<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <%--<div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label" style="margin: 0 0;padding: 0 0">ID</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="id" name="id" placeholder="id" >
        </div>
    </div>--%>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name" class="col-md-4 control-label">姓名：</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
                    </div>
                </div>
            </div>
            <div class="col-md-6"><%--就是说屏幕小于<768px的时候会应用sm   大于992px就会应用md--%>
                <div class="form-group">
                    <label for="password" class="col-md-4 control-label">密码：</label>
                    <div class="col-md-7">
                        <input type="text" class='form-control' id="password" name="password" placeholder="密码">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="pro" class="col-md-2 control-label">地址：</label>
                    <div class="col-md-10 form-inline">
                        <select class="form-control" style="width: 105px" id="pro" name="pro"><option>请选择</option></select>
                    </div>
                </div>
            </div>
</form>
<script>
    var allData;
    $.get("${ctx}" +"/static/json/location.min.json",function(data){
        allData = data;
        var pro = "";
        for(var key in data){
            var temp = data[key];
            pro += ("<option value='"+ temp.code +"'>" + temp.name +"</option>");
        }
        $("#pro").append($(pro));
    });
    $("#pro").change(function(){
        var that = this;
        var val = $(this).val();
        $(this).parent().children("select:not(:eq(0))").remove();
        var temp = allData[val];
        if(temp){
            var cityData = temp["cities"];
            var city = "";
            for(var key in cityData){
                if(key == val){
                    var cdis =cityData[key]["districts"];
                    for(var key2 in cdis) {
                        city += ("<option value='"+ key2 +"'>" + cdis[key2] +"</option>");
                    }
                }else{
                    city += ("<option value='"+ key +"'>" + cityData[key].name +"</option>");
                }
            }
            if(city != ""){
                city = "<select class='form-control' name='"+$(this).attr("name")+"Child'>" + city +"</select>";
                var $city = $(city);
                $(this).after($city);

                $city.change(function(){
                    var districtsData = cityData[$(this).val()]["districts"];
                    var districts = "";
                    for(var key in districtsData){
                        districts += ("<option value='"+ key +"'>" + districtsData[key] +"</option>");
                    }
                    if(districts != ""){
                        districts = "<select class='form-control' name='"+$(this).attr("name")+"Child'>" + districts +"</select>";
                    }
                    $(this).next("select").remove();
                    $(this).after($(districts));
                });
            }
        }
    });

</script>
</body>
</html>
