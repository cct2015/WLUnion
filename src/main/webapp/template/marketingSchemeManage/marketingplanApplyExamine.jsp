<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <style>
        .input-group[class*=col-] {
            float: none;
            padding-left: 12.5px;
            padding-right: 7.5px;
            width: 197.5px;
        }

        .myOtherDescripe {
            width: 673px;
            height: 80px;
        }
        .api-blacklist-form-add .modal-dialog {
            width: 1000px;
        }
    </style>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label" >ID</label>
        <div class="col-sm-9">
            <input type="text" value="" class="form-control" id="id" name="id" placeholder="id">
        </div>
    </div>
    <div class="container" id="container">

        <div class="row">
\            <div class="form-group col-md-6">
                <label for="title" class="col-sm-4 control-label">方案名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="title" name="title">
                </div>
            </div>
            <div class="form-group col-md-6 col-lg-offset-1">
                <label for="content" class="col-md-4 control-label">方案内容：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="content" name="content">
                </div>
            </div>
            <input type="hidden"  id="merchantId" name="merchantId" value="" />

        </div>
        <div class="row">

            <div class="form-group col-md-6">
                <label for="describe" class="col-sm-4 control-label">活动描述：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="describe" name="describe">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="isDifferent" class="col-sm-4 control-label">推送方式 ：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="isDifferent" name="isDifferent">
                        <option value="0">垂直营销</option>
                        <option value="1">异业营销</option>
                    </select>

                </div>
            </div>
        </div>
        <div class="row">

            <div class="form-group col-md-6">
                <label for="usageRule" class="col-sm-4 control-label">使用规则：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="usageRule" name="usageRule">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="supportStore" class="col-sm-4 control-label">支持门店 ：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="supportStore" name="supportStore">

                </div>
            </div>
        </div>
        <div class="row">

            <div class="form-group col-md-6 <%--col-lg-offset-1--%>">
                <label for="beginTime" class="col-md-4 control-label">开始时间:</label>
                <div class=" input-group col-md-6 date form_datetime  "
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="beginTime"
                           id="beginTime" placeholder="开始时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>
            <div class="form-group col-md-6 <%--col-lg-offset-1--%>">
                <label for="endTime" class="col-md-4 control-label">结束时间:</label>
                <div class=" input-group  date form_datetime col-md-6"
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="endTime"
                           id="endTime"
                           placeholder="结束时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>

        </div>
        <div class="row">


            <div class="form-group col-md-6">
                <label for="name" class="col-sm-4 control-label">活动联系人：</label>
                <div class="col-sm-5">
                    <input type="text" maxlength="50" class="form-control" id="name" name="name">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="tell" class="col-sm-4 control-label">联系电话：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="tell" name="tell">
                </div>
            </div>
        </div>
        <div class="row">

            <div class="form-group col-md-6">
                <label for="couponsNumber" class="col-sm-4 control-label">优惠卷数量：</label>
                <div class="col-sm-5">
                    <input type="number" min="0" maxlength="10" class="form-control" id="couponsNumber" name="couponsNumber">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="remark" class="col-sm-4 control-label">备注：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="remark" name="remark">
                </div>
            </div>
        </div>
        <%--<div class="row">
             <div class="form-group col-md-6">
                 <label for="country" class="col-sm-4 control-label">国家：</label>
                 <div class="col-sm-5">
                     <select class="form-control" id="country" name="country">
                         <option value="中国">中国</option>
                     </select>
                 </div>
             </div>
             <div class="form-group col-md-6">
                 <label for="province" class="col-sm-4 control-label">省(直辖市)：</label>
                 <div class="col-sm-5">
                     <select class="form-control" id="province" name="province">
                     </select>
                 </div>
             </div>

         </div>
         <div class="row">
             <div class="form-group col-md-6">
                 <label for="city" class="col-sm-4 control-label">城市：</label>
                 <div class="col-sm-5">
                     <select class="form-control" id="city" name="city">
                     </select>
                 </div>
             </div>
             <div class="form-group col-md-6">
                 <label for="district" class="col-sm-4 control-label">县（区）：</label>
                 <div class="col-sm-5">
                     <select class="form-control" id="district" name="district">
                     </select>
                 </div>
             </div>

         </div>--%>


        <div class="row">
            <div class="form-group col-md-6">
                <label for="selLabelNames" class="col-sm-4 control-label">目标人群属性：</label>
                <div class="col-sm-3">
                    <textarea id="selLabelNames" class="myOtherDescripe" name="selLabelNames" readonly
                              onclick="showMenu();" cols="40" rows="30"
                              placeholder="目标人群属性"></textarea>
                    <input type="hidden" id="hdnSelLabelKeys" value=""/>

                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-6">
                <label class="col-sm-4 control-label">营销佣金：</label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <br>
                <label class="col-sm-1 control-label"></label>
                <input name="Fruit" class="col-md-1" type="radio" id="radio1" checked value="1"/>按营销交易原单交易金额的<input
                    type="text" id="commissionTypeOne" name="commissionTypeOne"> % 收取
                </br>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-sm-1 control-label"></label>
                <input name="Fruit" class="col-md-1" type="radio" id="radio2" value="2"/>按营销交易固定金额收取,即
                <input type="text" id="commissionTypeTwo" name="commissionTypeTwo">元/笔
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label class="col-sm-4 control-label">券码营销：</label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <br>
                <label class="col-sm-1 control-label"></label>
                <input id="couponType0" class="col-sm-4" name="couponType" hidden type="radio" checked value="折扣券"/>折扣券:
                <input id="aaa0" name="aaa" class="col-md-1" type="radio" hidden myvalue="固定" value="testguding"
                       checked/>
                <input id="aaa1" name="aaa" type="radio" hidden myvalue="随机" value="testsuiji"/>
                &nbsp;折减
                <input type="text" size="5" id="valueOne" name="valueOne">%
                <br/>
            </div>
        </div>

        <div class="row">

            <div class="form-group col-md-6">
                <label for="otherDescripe" class="col-sm-4 control-label">其他说明：</label>
                <div class="col-sm-5">
                    <textarea type="text" class="comments col-md-10 myOtherDescripe" rows="3" cols="30"
                              id="otherDescripe"
                              name="otherDescripe"/>
                </div>
            </div>

        </div>
        <div class="row" style="margin-top: 20px">
            <div class="form-group col-md-6">
                <label for="status" class="col-md-4 control-label">审核状态：</label>
                <div class="col-md-4">
                    <select class="form-control" id="status" name="status" >
                        <option value="1">审核通过</option>
                        <option value="2">审核不通过</option>
                    </select>

                </div>
            </div>
        </div>

</form>
</body>
<script>

    function showMenu() {
        var Flag=$('#Flag').val();
        if(Flag=="NO")
        {
            getLabelTree();
            $('#Flag').val("YES");
        }
        show('popupdiv');
    }
    function getLabelTree() {
        var setting = {
            check: {
                enable: true,
                chkboxType: {"Y":"ps", "N":"ps"}
            },
            view: {
                dblClickExpand: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                //beforeClick: beforeClick,
                onCheck: onCheck
            }
        };
        $.post('${ctx}/baseLabel/getBaseLabelTree', function (zNodes) {
            $.fn.zTree.init($("#tree"), setting, zNodes);
        });
    }

    function onCheck(e,treeId,treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("tree"),
            nodes = zTree.getCheckedNodes(true),
            v = "",keys="";
        for (var i=0, l=nodes.length; i<l; i++) {
            v += nodes[i].name + ",";
            keys+=nodes[i].id + ",";
        }
        if (v.length > 0 )
        {
            v = v.substring(0, v.length-1);
            keys = keys.substring(0, keys.length-1);
        }
        $("#selLabelNames").html(v);
        $("#hdnSelLabelKeys").val(keys);
    }

    function show(popupdiv) {
        var Idiv = document.getElementById(popupdiv);
        Idiv.style.display = "block";
        //以下部分要将弹出层居中显示
        var container= document.getElementById("container");
        var containerwidth=container.clientWidth;
        Idiv.style.left = (document.documentElement.clientWidth - Idiv.clientWidth-containerwidth) / 2 + document.documentElement.scrollLeft + "px";

        Idiv.style.top = (document.documentElement.clientHeight - Idiv.clientHeight) / 2 + document.documentElement.scrollTop - 50 + "px";
        //以下部分使整个页面至灰不可点击
        var procbg = document.createElement("div"); //首先创建一个div
        procbg.setAttribute("id", "mybg"); //定义该div的id
        procbg.style.background = "#000000";
        procbg.style.width = "100%";
        procbg.style.height = "100%";
        procbg.style.position = "fixed";
        procbg.style.top = "0";
        procbg.style.left = "0";
        procbg.style.zIndex = "500";
        procbg.style.opacity = "0.6";
        procbg.style.filter = "Alpha(opacity=70)";
        //以上部分也可以用csstext代替
        // procbg.style.cssText="background:#000000;width:100%;height:100%;position:fixed;top:0;left:0;zIndex:500;opacity:0.6;filter:Alpha(opacity=70);";
        //背景层加入页面
        document.body.appendChild(procbg);
        document.body.style.overflow = "hidden"; //取消滚动条
        //以下部分实现弹出层的拖拽效果
        var posX;
        var posY;
        Idiv.onmousedown = function (e) {
            if (!e) e = window.event; //IE
            posX = e.clientX - parseInt(Idiv.style.left);
            posY = e.clientY - parseInt(Idiv.style.top);
            document.onmousemove = mousemove;
        }
        document.onmouseup = function () {
            document.onmousemove = null;
        }

        function mousemove(ev) {
            if (ev == null) ev = window.event;//IE
            Idiv.style.left = (ev.clientX - posX) + "px";
            Idiv.style.top = (ev.clientY - posY) + "px";
        }
    }

    function closeDiv(popupdiv) {
        var Idiv = document.getElementById(popupdiv);
        Idiv.style.display = "none";
        document.body.style.overflow = "auto"; //恢复页面滚动条
        var body = document.getElementsByTagName("body");
        var mybg = document.getElementById("mybg");
        body[0].removeChild(mybg);
    }

    $('.form_datetime').datetimepicker({
        minView: 'month',
        format: "yyyy-mm-dd",
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        startDate:new Date(),
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    function setInputDisable(inputList) {
        for (var i = 1; i < inputList.length; i++) {
            $(inputList[i]).attr('disabled', 'true').val("");
        }
    }

    function removeInputDisable(inputList) {
        for (var i = 1; i < inputList.length; i++) {
            $(inputList[i]).removeAttr('disabled').val("");
        }
    }

    function checkRadio() {
        var rio = $("input[type='radio'][name='Fruit']:checked").val();
        $("#commissionTypeOne").attr("readOnly", true).val("");
        $("#commissionTypeTwo").attr("readOnly", true).val("");
        $("#commissionTypeThree").attr("readOnly", true).val("");
        if (rio == '1') {
            $("#commissionTypeOne").attr("readOnly", false);
        }
        if (rio == '2') {
            $("#commissionTypeTwo").attr("readOnly", false);
        }
        if (rio == '3') {
            $("#commissionTypeThree").attr("readOnly", false);
        }

    }


    function resetDisable() {
        var idList = ['折扣券', '满减券', '代金券', '兑换券'];
        for (var i = 0; i < idList.length; i++) {
            setInputDisable($("#" + idList[i]).find('input'));
        }
    }

    function removeNowRowDisable(rowRadio) {
        var blockId = $(rowRadio).val();
        removeInputDisable($('#' + blockId).find('input'));
    }

    function other(rowRadio) {
        var blockId = $(rowRadio).val();
        if (blockId != '满减券' && blockId != '折扣券') {
            return;
        }

        var aaaRadioList = $('input[name="aaa"]');
        for (var i = 0; i < aaaRadioList.length; i++) {
            aaaRadioList[i].checked = false;
        }
        var inputList = $('#' + blockId).find("input");
        inputList[1].checked = true;
        if(blockId == '满减券'){

            $('#aaa2').removeAttr('disabled').val("");
            $('#aaa2').attr('checked','true');
        }
    }


    function init() {
        resetDisable();
        removeNowRowDisable($("input[value='折扣券']"));
        var couponTypeList = $('input[name="couponType"]');
        for (var i = 0; i < couponTypeList.length; i++) {
            couponTypeList[i].onclick = function () {
                resetDisable();
                removeNowRowDisable(this);
                other(this);
            }
        }
        checkRadio();
        var fruitTypeList = $('input[name="Fruit"]');
        for (var i = 0; i < fruitTypeList.length; i++) {
            fruitTypeList[i].onclick = function () {
                checkRadio();
                removeNowRowDisable(this);
                other(this);
            }
        }
    }
    window.onload = init();

</script>
</html>
