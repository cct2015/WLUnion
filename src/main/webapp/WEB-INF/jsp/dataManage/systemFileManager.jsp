<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>系统名称资料</title>
    <style>
        .modal .modal-dialog {
            width: 1000px;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel" style="height:630px">
            <div class="x_title">
                <h2>系统名称资料</h2>
                <div class="clearfix"></div>
            </div>


            <form style="margin-top: 10px" class="form-horizontal" role="form" id="myform">
                <div class="form-group required" hidden="hidden">
                    <label for="id" class="col-sm-2 control-label" style="margin: 0 0;padding: 0 0">ID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="id" name="id" placeholder="id">
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="form-group col-md-5">
                            <label for="systemName" class="col-sm-7 control-label">系统名称：</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="systemName" name="systemName"
                                       placeholder="系统名称">
                            </div>
                        </div>
                        <%--<div class="form-group col-md-5 col-lg-offset-1">
                            <label for="companyShort" class="col-md-7 control-label">渠道商简称：</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="companyShort" name="companyShort"
                                       placeholder="渠道商简称">
                            </div>
                        </div>--%>
                    </div>

                    <div class="row">

                    </div>
                    <%-- <div class="row"  id="userInformation">
                         <div class="form-group col-md-5">
                             <label for="name" class="col-sm-7 control-label">用户名：</label>
                             <div class="col-sm-5">
                                 <input type="text" class="form-control" id="name" name="name" placeholder="用户名"/>
                             </div>
                         </div>
                         <div class="form-group col-md-5">
                             <label for="password" class="col-sm-7 control-label">密码：</label>
                             <div class="col-sm-5">
                                 <input type="text" class="form-control" id="password" name="password" placeholder="密码"/>
                             </div>
                         </div>
                     </div>--%>

                </div>
                <div style="margin-top: 10px;">
                    <div class="form-group col-md-12" style="text-align: center;">
                        <input type="button" id="success11" class="btn btn-primary btn-sm" style="width: 200px;height: 40px;" value="确认修改"/>
                    </div>
                </div>
            </form>



        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url:"${ctx}/marketingMerchant/selectById",
            type:"post",
            data:{"id":""},
            dataType:"json",
            success:function (data) {
                /*console.log(data);
                console.log(data.rows[0]);*/
                var values=data.rows[0];
                $('#id').val(values.id),
                $('#systemName').val(values.systemName)
            }
        })



    });

    //提交
    $("#success11").click(function () {
        //find("option:selected").text().trim()


        var json = {
            'id': $.trim($("#myform").find("#id").val()),
            'systemName': $.trim($("#myform").find("#systemName").val()),
        }

        $("#myform").bootstrapValidator({
            live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
            submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
            message: '通用的验证失败消息',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                systemName: {
                    validators: {
                        notEmpty: {
                            message: '名称不能为空！'
                        },
                    }
                }
            }
        });
        var bootstrapValidator = $("#myform").data('bootstrapValidator');
        bootstrapValidator.validate();
        if (bootstrapValidator.isValid()) {
            $.ajax({
                url: "${ctx}/marketingMerchant/updateById",
                data: json,
                dataType: "json",
                cache: false,
                success: function (response) {
                    if (response != null) {
                        console.log("1111");
                        getCode('update', "修改成功!");
                        //window.location.reload();
                    } else {
                        getCode('update', "修改失败!");
                    }
                },
                error: function (textStatus, e) {
                    getCode('update', "系统ajax交互错误!");

                }
            });
        }
    })
</script>
</body>
</html>
