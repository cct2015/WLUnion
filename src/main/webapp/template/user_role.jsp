<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form2" class="form-horizontal" style="margin-left: 260px">
    <!--获用户登录时取存入session域对象中租户id-->
    <input style="display:none" type="hidden" id="lesseeId" value="${lesseeid}">
    <input style="display:none" type="hidden" id="shopId" value="${shopid}">
    <div class="form-group" style="margin-top: 10px">
        <label class="control-label col-sm-2" for="name">用户名:</label>
        <div class="col-sm-4" id="user">
            <input type="text" class="form-control" id="name" name="name" placeholder="用户名">
        </div>
        <span id="span">

        </span>
    </div>
    <div class="form-group" style="margin-top: 10px">
        <label class="control-label col-sm-2" for="password">密码:</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
        </div>
    </div>
    <div class="form-group" id="forpassword" style="margin-top: 10px">
        <label class="control-label col-sm-2" for="repassword">确认密码:</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="repassword" name="repassword" placeholder="密码">
        </div>
    </div>
    <div class="form-group" id="forrolename" style="margin-top: 10px">
        <label class="control-label col-sm-2" for="roledesc">角色名:</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="roledesc" name="roledesc" placeholder="角色名">
        </div>
    </div>

</form>

<%--<script>

    $(function(){
        $("#name").blur(function(){
            var name = $("#name").val();
            $.ajax({
                url:"${ctx}/checkUserName",
                type:"post",
                data:{"userName":name},
                dataType:"json",
                success:function (data) {
                    if(data){
                        $("#span").remove();
                    }else {
                        $("#span").css("color","red").html("用户名已占用");
                        /* $('#name').after('<label id="la1" class="text-danger">用户名已存在</label>');*/
                        $('#name').parents(".form-group").addClass("has-error");
                        $('#name').parents(".form-group").removeClass("has-success");
                        $('#name').siblings("i").remove();
                        $('#name').after("<i class=\"form-control-feedback glyphicon glyphicon-remove\" data-bv-icon-for=\"name\" style=\"\"></i>");

                    }
                }
            })
        })
    })

</script>--%>
<script>
    $('.form_datetime').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
</script>

</body>
</html>
