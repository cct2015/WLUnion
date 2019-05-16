<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>短信发送营销</title>
    <script>
        $(function () {
                getSMSTemplateList();
                $('#content').attr("disabled", "disabled");
            }
        );

        var templateList = null;

        //列表所有短信模板
        function getSMSTemplateList() {
            $('#templateDiv').html('');
            $.ajax({
                url: "/SMSExecute/getSMSTemplateList",
                dataType: 'json',
                cache: false,
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
                success: function (result) {
                    templateList = result;
                    var Str = JSON.stringify(result);
                    if (Str == "" || Str == "[]") return;
                    var hdnId = "";
                    var html = "";
                    var selvalue = "";
                    $.each(result, function (index, item) {
                        hdnId = "hdn" + item.id;
                        html += "<input type='hidden' id='" + hdnId + "'  value='" + item.content + "'/>";

                        if (index == 0) {
                            selvalue = item.id
                        }
                        $("#templateId").append("<option value='" + item.id + "'>" + item.name + "</option>");
                    });
                    if (html != "") {
                        $("#templateId").val(selvalue);
                        $('#templateDiv').html(html);
                    }
                    getContent();
                },
                error: function (status, e) {
                    alert("系统错误: " + e);
                }
            });
        }

        function getContent() {


            var templateId = $('#templateId').val();
            var hdnId = "hdn" + templateId;
            for (var i = 0; i < templateList.length; i++) {
                if (templateList[i].id == templateId) {
                    document.getElementById("content").value = templateList[i].content;
                }
            }
            var content = $('#' + hdnId).val();
            $("#content").html(content);
        }

        var clipboard = new ClipboardJS('.copyUrl');

        clipboard.on('success', function (e) {
            getCode("add", "复制成功！");
        });

        clipboard.on('error', function (e) {
            getCode("check", "复制失败！");
        });

        function showShortMessage() {
            var messageShow = "";
            /*获取短信签名*/
            $.ajax({
                url: "${ctx}/shortMessage/signatureQuery",
                dataType: 'json',
                cache: false,
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
                success: function (result) {
                    if (result.length > 0) {

                        var signature = result[0].get("signature");
                        messageShow = "【" + signature + "】";
                    }

                },
                error: function (status, e) {
                    alert("系统错误: " + e);
                }
            });
           /* messageShow = "【" + "陆尔信息" + "】";*/
            var content = $("#content").val();
            /*content="%s欢迎光临，4月9日至4月20日，芗园黑糖红枣桂圆茶限时折扣%s 商品链接%s 退订回T";*/
            var paras = $("#paras").val();
            var parasArray = paras.split("|");
            /*参数数组*/
            var contentArray = content.split("%s");
            /*模板数组*/
            var parasLength = parasArray.length;
            if ((contentArray.length - 1) == parasLength) {
                for (var i = 0; i < contentArray.length; i++) {
                    if (i == parasLength) {
                        messageShow = messageShow + contentArray[i];
                    } else {
                        messageShow = messageShow + contentArray[i] + parasArray[i];
                    }

                }
            } else {
                getCode("check", "参数个数不对");
            }
            var messageLength = messageShow.length;

            var  lengthShow="（注：短信计费包括短信签名,70字计一条短信费,超过70字则以67字每条计费,当短信中出现中文字符,则单个汉字、英文、标点符号和空格都算一个字）";

            var number=0;
            if(messageLength==0){
                number=0;
            }else  if(messageLength<=70){
                number=1
            }else{
                number=Math.ceil(messageLength/67);
            }
            var messageLengthShow="短信总字数"+messageLength+"个字,以"+number+"封短信费用计费"+lengthShow;
            document.getElementById("messageLength").value = messageLengthShow;
            document.getElementById("messageShow").value = messageShow;
        }

    </script>
</head>
<body>
<div class="container body">

    <input type="hidden" id="planId" name="planId" value=""/>
    <div class="container" id="container">
        <div class="row">
            <div class="form-group col-md-10">
                <label for="title" class="col-sm-2 control-label">营销方案标题:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control col-sm-8" id="title" name="title" disabled="disabled"
                           value=""/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label for="couponUrl" class="col-sm-2 control-label">优惠券链接地址:</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control col-sm-6" id="couponUrl" readonly="true" name="couponUrl"
                           value=""/>
                </div>
                <div class="col-sm-2">
                    <button class="form-control copyUrl btn" style="background-color: #eee"
                            data-clipboard-target="#couponUrl">复制
                    </button>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-10">
                <label for="templateId" class="col-sm-2 control-label">请选择短信模板:</label>
                <div class="col-sm-10">
                    <select id="templateId" class="form-control col-sm-8 " name="templateId" onchange="getContent();">
                    </select>

                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label class="col-sm-2 control-label">所选择模板内容:</label>
                <div class="col-sm-10">
                    <textarea rows="4" id="content" name="content" disabled="disabled" class="form-control"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label class="col-sm-2 control-label">消息任务名称:</label>
                <div class="col-sm-10">
                    <input type="text" id="name" class="form-control" name="name" value=""/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-10">
                <label class="col-sm-2 control-label">请填写短信参数<br/>(不同的参数间以"|"隔开):</label>
                <div class="col-sm-10">
                    <textarea rows="4" id="paras" name="paras" class="form-control"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="input-group form-group col-md-10">
                <div class="col-sm-2">
                    <input type="button" value="短信预览:" class="form-control btn btn-primary"
                           onclick="showShortMessage()"></input>
                </div>
                <%--<label class="col-sm-2 control-label" >短信预览</label>--%>
                <div class="col-sm-10">
                    <textarea id="messageShow" class="form-control" rows="4" name="messageShow"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="input-group form-group col-md-10">
                <label class="col-sm-2 control-label">短信计费备注:</label>
                <div class="col-sm-10">
                    <textarea rows="4" id="messageLength" name="messageLength" class="form-control">
（注：短信计费包括短信签名,70字计一条短信费,超过70字则以67字每条计费,当短信中出现中文字符,则单个汉字、英文、标点符号和空格都算一个字）

                    </textarea>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div style="display: none" id="templateDiv"></div>

</body>
</html>
