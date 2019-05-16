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
    <title>总部</title>
    <style>
        .myStyle {
            width: 720px;
            height: 200px;
            resize: none;
        }

    </style>
</head>
<body class="nav-md">
<div class="container body" <%--style="background-color: #F7F7F7"--%>>
    <div class="right_col" role="main">
        <form class="form-horizontal" role="form" id="myform">
            <div class="container">
                <div class="row" hidden="hidden">
                    <div class="form-group col-md-5">
                        <label for="id" class="col-sm-7 control-label">id：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="id" name="id" placeholder="id"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="companyName" class="col-sm-7 control-label">总部名称：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="companyName" name="companyName"
                                   placeholder="总部名称"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5 col-lg-offset-1">
                        <label for="companyShort" class="col-md-7 control-label">总部简称：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="companyShort" name="companyShort"
                                   placeholder="总部简称"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="contacter" class="col-sm-7 control-label">联系人：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="contacter" name="contacter" placeholder="联系人"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="tel" class="col-sm-7 control-label">联系电话：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="tel" name="tel" placeholder="联系电话"/>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="bankUser" class="col-sm-7 control-label">开户名：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="bankUser" name="bankUser" placeholder="开户名">
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="bankNo" class="col-sm-7 control-label">银行对公账号：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="bankNo" name="bankNo" placeholder="银行对公账号"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="bankAddress" class="col-sm-7 control-label">开户行：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="bankAddress" name="bankAddress"
                                   placeholder="开户行"/>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="remark" class="col-sm-7 control-label">备注：</label>
                        <div class="col-sm-5">
                            <textarea class="form-control myStyle col-sm-7" id="remark" name="remark" placeholder="备注"
                            ></textarea>
                        </div>
                    </div>
                </div>
                <div class="row" hidden="hidden" id="userInformation">
                    <div class="form-group col-md-5">
                        <label for="name" class="col-sm-7 control-label">用户名：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="name" name="name" placeholder="用户名"/>
                            <span id="doubleName" hidden="hidden" style="color: red">*用户名重复</span>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="password" class="col-sm-7 control-label">密码：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="password" name="password" placeholder="密码"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-5">
                    <label for="remark" class="col-sm-7 control-label"></label>
                    <div class="col-sm-5">
                        <input type="button" id="success11" class=" btn btn-primary btn-sm"
                               value="确认修改"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function () {

        var flag = 0;
        $(document).ready(function () {
            $.ajax({
                url: "${ctx}/marketingMerchant/selectByTypeAndStep",
                type: "post",
                data: {"type": 3, "step": 0},
                dataType: "json",
                success: function (data) {
                    console.log(data.rows[0]);
                    var values = data.rows[0];
                    $('#id').val(values.id),
                        $('#companyName').val(values.companyName),
                        $('#companyShort').val(values.companyShort),
                        $('#contacter').val(values.contacter),
                        $('#tel').val(values.tel),
                        $('#bankUser').val(values.bankUser),
                        $('#bankAddress').val(values.bankAddress),
                        $('#remark').val(values.remark),
                        $('#bankNo').val(values.bankNo)


                    document.getElementById("userInformation").style.display = "none";
                }
            })


        });

        //提交
        $("#success11").click(function () {
            //find("option:selected").text().trim()


            var json = {
                id: $("#id").val(),
                companyName: $("#companyName").val(),
                companyShort: $("#companyShort").val(),
                contacter: $("#contacter").val(),
                tel: $("#tel").val(),
                bankNo: $("#bankNo").val(),
                bankAddress: $("#bankAddress").val(),
                bankUser: $("#bankUser").val(),
                remark: $("#remark").val()
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

                    companyName: {
                        validators: {
                            notEmpty: {
                                message: '总部名不能为空！'
                            },
                        }
                    },
                    companyShort: {
                        validators: {
                            notEmpty: {
                                message: '总部简称不能为空！'
                            },
                        }
                    },
                    contacter: {
                        validators: {
                            notEmpty: {
                                message: '联系人不能为空！'
                            },
                        }
                    },
                    tel: {
                        validators: {
                            notEmpty: {
                                message: '联系电话不能为空！'
                            },
                            regexp: {
                                regexp: /^1(3|4|5|7|8)\d{9}$/,
                                message: '手机号格式不正确！'
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


                            getCode('update', "修改成功!");
                            window.location.reload();
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


    })
</script>
</body>
</html>
