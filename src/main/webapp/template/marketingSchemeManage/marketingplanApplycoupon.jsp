<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link href="${ctx}/static/js/summernote/summernote.css" rel="stylesheet"/>
<link href="${ctx}/static/js/summernote/summernote-bs3.css" rel="stylesheet"/>
<script src="${ctx}/static/js/summernote/summernote.min.js"></script>
<script src="${ctx}/static/js/summernote/summernote-zh-CN.js"></script>
<html>
<head>
    <meta name="referrer" content="no-referrer">
    <style>
        .input-group[class*=col-] {
            float: none;
            padding-left: 12.5px;
            padding-right: 7.5px;
            width: 176.66px;
        }

        .myOtherDescripe {
            width: 672px;
            height: 80px;
        }

        .myCouponUrl {
            width: 638px;
            height: 34px;
        }

        .login-dialog .modal-dialog {
            width: 1000px;
        }

        .mustItem {
            font-size: 14px;
            color: red
        }

        .myFile {
            height: 34px;
        }

        .galleryfileCover .img-item {
            float: left;
            position: relative;
        }

        .galleryfileImg  .img-itemTwo {
            float: left;
            position: relative;
        }

        .img-item {
            float: left;
        }
         .img-itemTwo {
            float: left;
        } {
            float: left;
        }
        .galleryfileCover .img-item .delete {
            position: absolute;
            display: block;
            width: 20px;
            height: 20px;
            float: left;
            color: #fff;
            background: rgba(0, 0, 0, 0.7);
            line-height: 20px;
            text-align: center;
            border-radius: 50%;
            top: 5px;
            right: 5px;
            cursor: pointer;
        }

        .galleryfileImg .img-itemTwo .deleteTwo {
            position: absolute;
            display: block;
            width: 20px;
            height: 20px;
            float: left;
            color: #fff;
            background: rgba(0, 0, 0, 0.7);
            line-height: 20px;
            text-align: center;
            border-radius: 50%;
            top: 5px;
            right: 5px;
            cursor: pointer;
        }

        .img {
            width: 100px;
            margin-left: 10px;
            height: 80px;
            border-radius: 0px;
        }
        .imgTwo {
            width: 100px;
            margin-left: 10px;
            height: 80px;
            border-radius: 0px;
        }

        /*外层div*/
        .input-file-box {
            border: 1px solid gray;
            width: 150px;
            height: 150px;
            position: relative;
            text-align: center;
            border-radius: 8px;
        }

        /*文字描述*/
        .input-file-box > span {
            display: block;
            width: 100px;
            height: 30px;
            position: absolute;
            top: 0px;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
            color: gray;
        }

        /*input框*/
        .input-file-box #uploadfile {
            opacity: 0;
            width: 100%;
            height: 100%;
            cursor: pointer;
        }
        .imgThree {
            width: 100px;
            margin-left: 10px;
            height: 80px;
            border-radius: 0px;
        }
        .mySourceImg .img-itemThree .selectThree {
            position: absolute;
            display: block;
            width: 20px;
            height: 20px;
            float: left;
            color: #fff;
            background: rgba(0, 0, 0, 0.7);
            line-height: 20px;
            text-align: center;
            border-radius: 50%;
            top: 5px;
            right: 5px;
            cursor: pointer;
        }

        .img-itemThree {
            float: left;
        }
        .mySourceImg.img-itemThree {
            float: left;
            position: relative;
        }
    </style>

</head>
<body>
<form class="form-horizontal" role="form" id="myform" enctype="multipart/form-data">
    <div class="form-group required"  hidden="hidden" >
        <label for="id" class="col-sm-2 control-label">ID</label>
        <div class="col-sm-9">
            <input type="text" value="" class="form-control" id="id" name="id" placeholder="id">
        </div>
    </div>
    <div class="form-group required" hidden="hidden">
        <label for="merchantId" class="col-sm-2 control-label">merchantId</label>
        <div class="col-sm-9">
            <input type="text" value="" class="form-control" id="merchantId" name="merchantId" placeholder="merchantId">
        </div>
    </div>
    <div class="container" id="container">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="title" class="col-sm-4 control-label">方案名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="title" name="title">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="isDifferent" class="col-sm-4 control-label">推送方式：</label>
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
                <label for="couponsNumber" class="col-sm-4 control-label">优惠卷数量：</label>
                <div class="col-sm-5">
                    <input type="number" min="0" class="form-control" id="couponsNumber"
                           name="couponsNumber">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="couponsSource" class="col-sm-4 control-label">优惠券来源：</label>
                <div class="col-sm-5">
                    <select id="couponsSource" class="form-control" name="couponsSource">
                        <option value="0">京东</option>
                        <option value="1">银商</option>
                        <option value="2">杉德</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6 <%--col-lg-offset-1--%>">
                <label for="beginTime" class="col-sm-4 control-label">开始时间:</label>
                <div class="col-sm-5">
                    <input class="form-control" readonly="readonly" type="text" value="" name="beginTime"
                           id="beginTime"
                           placeholder="开始时间">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="endTime" class="col-sm-4 control-label">结束时间:</label>
                <div class="col-sm-5">
                    <input class="form-control" readonly="readonly" type="text" value="" name="endTime" id="endTime"
                           placeholder="结束时间">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="couponUrl" class="col-sm-4 control-label">垂直营销优惠券链接：</label>
                <div class="col-sm-5">
                    <textarea id="couponUrl" class="myCouponUrl" name="couponUrl"></textarea>
                </div>
            </div>
        </div>


        <div class="row" id="tableDiv">
            <div class="form-group col-sm-12">
                <label class="col-md-2 control-label"></label>
                <div class="col-md-8">
                    <table id="urlTable" class="table" border="1">
                        <tr>

                            <td scope="col" class="col-sm-3">
                                <label>推送商户</label>
                            </td>
                            <td scope="col" class="col-sm-7">
                                <label>异业营销优惠券链接</label>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <select class="form-control" id="merchantId0" name="merchantList"></select>
                            </th>
                            <th>
                                <input class="form-control" id="couponUrlId0" name="couponUrlList"/>
                            </th>
                        </tr>
                    </table>
                </div>
                <div class="col-sm-2">
                    <input type="button" class="" onclick="addRow()" value="添加一行">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-6">
                <label for="fileCover" class="col-sm-4 control-label">封面图片:</label>
                <div class="col-sm-5">
                    <input type="file" id="fileCover" class="myFile" multiple name="fileCover"/>
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="uploadFileCover" class="col-sm-4 control-label"></label>
                <div class="col-sm-5">
                    <input type="button" id="uploadFileCover" class="form-control" value="上传封面图片"
                           onclick="uploadCover();"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-11">
                <label for="fileCover" class="col-sm-2 control-label"></label>
                <div class="col-sm-9">
                    <div class="galleryfileCover" class="form-group col-md-2" id="galleryfileCover"></div>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="fileImg" class="col-sm-4 control-label">图片素材:</label>
                <div class="col-sm-5">
                    <input type="file" id="fileImg" class="myFile" multiple name="fileImg"/>

                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="uploadFileImg" class="col-sm-4 control-label"></label>
                <div class="col-sm-5">
                    <input type="button" id="uploadFileImg" class="form-control" value="上传图片素材"
                           onclick="uploadSourceMaterial();"/>
                </div>

            </div>

        </div>
        <div class="row">
            <div class="form-group col-md-11">
                <label for="fileCover" class="col-sm-2 control-label"></label>
                <div class="col-sm-10">
                    <div class="galleryfileImg" id="galleryfileImg"></div>
                </div>
            </div>
        </div>
        <div class="row" <%--style="width: 100%;display:block "--%> id="contentDiv">
            <div class="form-group col-md-11">
                <label for="noticeContent" class="col-sm-2 control-label">微信营销图文:</label>
                <div class="col-sm-5" style="font-size: 14px;width: 650px;margin-bottom: 0px">
                    <input id="noticeContent" name="noticeContent" class="form-control" type="hidden">
                    <div id="summernote" style="margin-bottom: 0px"></div>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    $(function () {
            $('#summernote').summernote(
                {
                    minHeight: 300,
                    dialogsFade: true,
                    dialogsInBody: true,
                    disableDragAndDrop: false,
                    /*merchantId: $("#id").val(),
                    appId: $("#appIdImg").val(),*/
                    height: '380px',
                    width: '720px',
                    lang: 'zh-CN'
                }
            );

        $('#summernote').summernote('insertImage', url, function ($image) {
            
            $image.css('width', $image.width() / 3);
            $image.attr('data-filename', 'retriever');
        });
        }
    );

    var files = [];
    var sourceMaterial = [];
    var that = this;

    $("#fileCover").change(function () {
        //document.getElementById("galleryfileCover").innerHTML = "";
        var img = document.getElementById("fileCover").files;
        if (img.length > 4) {
            getCode('check', "封面图片不超过4张!");
            document.getElementById("fileCover").value = "";
            return;
        }
        var div = document.createElement("div");
        for (var i = 0; i < img.length; i++) {
            var file = img[i];
            var url = URL.createObjectURL(file);
            var box = document.createElement("img");
            box.setAttribute("src", url);
            box.className = 'img';

            var imgBox = document.createElement("div");
            imgBox.style.display = 'inline-block';
            imgBox.className = 'img-item';

            var deleteIcon = document.createElement("span");
            deleteIcon.className = 'delete';
            deleteIcon.innerText = 'x';
            deleteIcon.dataset.filename = img[i].name;
            imgBox.appendChild(deleteIcon);

            imgBox.appendChild(box);
            var body = document.getElementsByClassName("galleryfileCover")[0];
            body.appendChild(imgBox);

            that.files = img;
            $(deleteIcon).click(function () {
                var filename = $(this).data("filename");
                $(this).parent().remove();
                var fileList = Array.from(that.files);

                for (var j = 0; j < fileList.length; j++) {
                    if (fileList[j].name == filename) {
                        fileList.splice(j, 1);
                        break;
                    }
                }
                that.files = fileList

            })
        }
    });

    $("#fileImg").change(function () {
        /*document.getElementById("galleryfileImg").innerHTML = "";*/
        var img = document.getElementById("fileImg").files;
        var div = document.createElement("div");
        for (var i = 0; i < img.length; i++) {
            var file = img[i];
            var url = URL.createObjectURL(file);
            var box = document.createElement("img");
            box.setAttribute("src", url);
            box.className = 'imgTwo';

            var imgBox = document.createElement("div");
            imgBox.style.display = 'inline-block';
            imgBox.className = 'img-itemTwo';

            var deleteIcon = document.createElement("span");
            deleteIcon.className = 'deleteTwo';
            deleteIcon.innerText = 'x';
            deleteIcon.dataset.filename = img[i].name;
            imgBox.appendChild(deleteIcon);

            imgBox.appendChild(box);
            var body = document.getElementsByClassName("galleryfileImg")[0];
            body.appendChild(imgBox);

            that.sourceMaterial = img;
            $(deleteIcon).click(function () {
                var filename = $(this).data("filename");
                $(this).parent().remove();
                var fileList = Array.from(that.sourceMaterial);

                for (var j = 0; j < fileList.length; j++) {
                    if (fileList[j].name == filename) {
                        fileList.splice(j, 1);
                        break;
                    }
                }
                that.sourceMaterial = fileList

            })
        }
    });

    //上传封面到网陆服务器
    function uploadCover() {

        var imgs = document.getElementById("fileCover").files;
        if (imgs.length == 0) {
            alert("请选择封面图片！");
            return;
        }
        if (imgs.length > 4) {
            alert("封面图片不超过4张！");
            return;
        }

        var type = "cover";
        var id = $.trim($("#myform").find("#id").val());
        var form = new FormData();
        for (var i = 0; i < imgs.length; i++) {
            form.append("files", imgs[i]);
        }
        form.append("type", type);
        form.append("id", id);
        $.ajax({
            type: 'post',
            url: '${ctx}/common/uploadFiles',
            contentType: false,
            processData: false,
            data: form,
            success: function (response) {
                if (response.code = 200) {
                    var data = response.data;
                    getCode("add", "封面上传成功！");
                } else {
                    getCode("add", "封面上传失败！");
                }
            },
            error: function (response) {
                getCode("add", "封面上传出现错误！");
            },
        });

    };

    //上传素材到网陆服务器
    function uploadSourceMaterial() {
        var imgs = document.getElementById("fileImg").files;
        if (imgs.length == 0) {
            alert("请选择素材图片！");
            return;
        }
        var type = "sourceMaterial";
        var id = $.trim($("#myform").find("#id").val());
        var form = new FormData();
        for (var i = 0; i < imgs.length; i++) {
            form.append("files", imgs[i]);
        }
        form.append("type", type);
        form.append("id", id);
        $.ajax({
            type: 'post',
            url: '${ctx}/common/uploadFiles',
            contentType: false,
            processData: false,
            data: form,
            success: function (response) {
                if (response.code = 200) {
                    var data = response.data;
                    getCode("add", "素材上传成功！");
                } else {
                    getCode("add", "素材上传失败");
                }
            },
            error: function (response) {
                getCode("add", "素材上传出现错误");
            },
        });

    };

    function addRow() {
        var currentRows = document.getElementById("urlTable").rows.length - 1;
        var index = currentRows;
        if (checkRow(index - 1)) {
            return;
        }
        ;
        var rowId = "merchantId" + index;
        var couponUrlId = "couponUrlId" + index;
        var insertTr = document.getElementById("urlTable").insertRow(currentRows + 1);
        var insertTd = insertTr.insertCell(0);
        insertTd.style.textAlign = "center";
        insertTd.innerHTML = "<select class=\"form-control\" id=" + rowId + " name=\"merchantList\"></select>";
        insertTd = insertTr.insertCell(1);
        insertTd.style.textAlign = "center";
        insertTd.innerHTML = "<input class=\"form-control\" id=" + couponUrlId + " name=\"couponUrlList\"/>";
        showIdAndName(rowId);
        /* $("#urlTable").append("<tr>\n" +
              "                            <th>\n" +
              "                                <select class=\"form-control\" id=\"+rowId+\" name=\"merchantList\"></select>\n" +
              "                            </th>\n" +
              "                            <th>\n" +
              "                                <input class=\"form-control\" id=\"+couponUrlId+\" name=\"couponUrlList\"/>\"\n" +
              "                            </th>\n" +
              "                        </tr>");*/


    };


    showIdAndName("merchantId0");

    /*查询商户*/
    function showIdAndName(merchantId) {
        $.ajax({
            type: "POST",
            url: "${ctx}/marketingMerchant/selectMerchantListByType",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    if ($.trim($("#myform").find("#merchantId").val()) != data[i].id) {
                        $("#" + merchantId).append("<option  value='" + data[i].id + "'>" + data[i].companyName + "</option>");
                    }

                }

            }
        });
    }

    /*验证*/
    function checkRow(row) {
        var couponUrlId = "couponUrlId" + row;
        var couponUrlvalue = $.trim($("#myform").find("#" + couponUrlId).val());
        if ((couponUrlvalue == null) || (couponUrlvalue == '')) {
            getCode("check", "请完整填写优惠卷连接");
            return true;
        }
        return false;
    }

    var id=$.trim($("#myform").find("#id").val());

    function selectImages(id, type) {
        var sourceMaterialData = {
            id: id,
            type: type
        };
        $.ajax({
            type: "POST",
            url: "${ctx}/common/getAllPathFile",
            data: sourceMaterialData,
            success: function (img) {
                debugger;
                document.getElementById("mySourceImg").innerHTML = "";
                var div = document.createElement("div");
                for (var i = 0; i < img.length; i++) {
                    var url = img[i];
                    // 创建 一个FileReader对象
                    var reader = new FileReader();
                    var box = document.createElement("img");
                    box.setAttribute("src", url);
                    box.className = 'imgThree';

                    //box.dataset.filename = img[i];
                    var imgBox = document.createElement("div");
                    imgBox.style.display = 'inline-block';
                    imgBox.className = 'img-itemThree';
                    imgBox.dataset.filename = img[i];
                    imgBox.style = " float: left;\n" +
                        "            position: relative;";
                    imgBox.appendChild(box);
                    var body = document.getElementsByClassName("mySourceImg")[0];
                    body.appendChild(imgBox);
                    $(imgBox).click(function () {
                        var appId = $("input[name='wx']:checked").val();
                        document.getElementById("myImageButton").disabled="";
                        //$('#myImageButton').removeAttr("disabled");
                        var filename = $(this).data("filename");
                        var spanList = document.getElementsByClassName("selectThree");
                        for (var i = 0; i < spanList.length; i++) {
                            spanList[i].style.display = "none";
                        }
                        var selectIcon = document.createElement("span");
                        selectIcon.className = 'selectThree';
                        selectIcon.innerText = '√';

                        $(this).append(selectIcon);
                        // $(this).style("color:red");


                        var form = new FormData();
                        form.append("filePath", filename);
                        form.append("appIdImg", appId);

                        // $("#dialogImageUrl").val("http://mmbiz.qpic.cn/mmbiz_jpg/8Bgbu8zo1bJ7rOUk7icMvfl9JibseuHpyFcLpAKjiaZicNJ2VDajz9bNW3XUhSxHiaJ7sibrEicE737NoMxzcwcdSsEOw/0");

                        $.ajax({
                            type: 'post',
                            url: '${ctx}/wxExecute/uploadImage',
                            contentType: false,
                            processData: false,
                            data: form,
                            success: function (response) {
                                if (response != "") {
                                    $("#dialogImageUrl").val(response);
                                    getCode("add", "素材上传成功！");
                                } else {
                                    getCode("add", "素材上传失败");
                                }
                            },
                            error: function (response) {
                                getCode("add", "素材上传出现错误");
                            },
                        });


                    })
                }
            },
            error: function (textStatus, e) {
                getCode('add', "系统ajax交互错误!");
            }
        });
    }
</script>
</body>
</html>
