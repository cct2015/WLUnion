<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>营销方案广泛营销</title>
    <style>
        .modal-backdrop {
            position: relative;
        !important;
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

        .galleryfileImg .img-itemTwo {
            float: left;
            position: relative;
        }

        .mySourceImg.img-itemThree {
            float: left;
            position: relative;
        }

        .img-item {
            float: left;
        }

        .img-itemTwo {
            float: left;
        }

        .img-itemThree {
            float: left;
        }

        .galleryfileCover .img-item .select {
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

        .galleryfileImg .img-itemTwo .selectTwo {
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

        .imgThree {
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
    </style>
    <link href="${ctx}/static/js/summernote/summernote.css" rel="stylesheet"/>
    <link href="${ctx}/static/js/summernote/summernote-bs3.css" rel="stylesheet"/>
    <script src="${ctx}/static/js/summernote/mysummernote.js"></script>
    <script src="${ctx}/static/js/summernote/summernote-zh-CN.js"></script>
    <script>

        $(function () {

                $('#summernote').summernote(
                    {
                        minHeight: 300,
                        dialogsFade: true,//显示和隐藏对话框而不会产生淡入淡出效果
                        dialogsInBody: true,//对话框可以放在body Summernote 中，而不是放在Summernote中。如果您在模态对话框中使用Summernote，请将此选项设置为true
                        disableDragAndDrop: false,//使用该disableDragAndDrop选项禁用拖放
                        shortcuts: true,//禁用自定义快捷方式
                        merchantId: $("#id").val(),
                        appId: $("#appIdImg").val(),
                        ctx: '${ctx}',
                        height: '380px',
                        width: '720px',
                        lang: 'zh-CN',

                    }
                );

            }
        );

        //上传图片素材,返回URL
        function uploadImage() {
            var applyUrl = '${ctx}/wxExecute/uploadImage';
            var url = $("#fileImg").val();
            if ($.trim(url).length == 0) {
                getCode("check", "请选择图片文件！");
                return;
            }
            var appId = $("#appIdImg").val();
            /*if((appId=="")||(appid==null)){
                appId="a3f7c289b0414717b42f25ac862ad1ac";
            }*/
            if ($.trim(appId).length == 0) {
                getCode("check", "请选择公众号！");
                //alert("请选择公众号！");
                return;
            }

            var form = new FormData();
            form.append("filePath", url);
            form.append("appIdImg", appId);
            $.ajax({
                type: 'post',
                url: '${ctx}/wxExecute/uploadImage',
                contentType: false,
                processData: false,
                data: form,
                success: function (response) {
                    if (response != "") {
                        $("#ImageUrl").val(response);
                        getCode("add", "素材上传成功！");
                    } else {
                        getCode("add", "素材上传失败");
                    }
                },
                error: function (response) {
                    getCode("add", "素材上传出现错误");
                },
            });

        }

        //上传封面，返回mediaId
        function uploadCover() {
            var url = $("#fileCover").val();
            if ($.trim(url).length == 0) {
                getCode("check", "请选择封面文件！");
                return;
            }

            var appId = $("#appIdCover").val();
            /*if((appId=="")||(appid==null)){
                appId="a3f7c289b0414717b42f25ac862ad1ac";
            }*/
            if ($.trim(appId).length == 0) {
                getCode("check", "请选择公众号！");
                return;
            }
            var form = new FormData();
            form.append("filePath", url);
            form.append("appIdCover", appId);
            $.ajax({
                type: 'post',
                url: '${ctx}/wxExecute/uploadCover',
                contentType: false,
                processData: false,
                data: form,
                success: function (response) {
                    if (response != "") {
                        $("#thumbMediaId").val(response);
                        getCode("add", "封面上传成功！");
                    } else {
                        getCode("add", "封面上传失败");
                    }
                },
                error: function (response) {
                    getCode("add", "封面上传出现错误");
                },
            });

        }

        //上传图文，返回mediaId
        function uploadMediaAndText() {
            var appId = $("input[name='wx']:checked").val();
            if ($.trim(appId).length == 0) {
                getCode("check","请选择公众号！");
                return;
            }
            var thumbMediaId = $("#thumbMediaId").val();
            var content = $("#summernote").summernote('code');
            if ($.trim(thumbMediaId).length == 0) {
                getCode("check","请先设置封面！");
                return;
            }
            if ($.trim(content).length < 10 || content == '<p><br></p>') {
                getCode("check","请先设置微信内容！");
                return;
            }
            $.ajax({
                url: "${ctx}/wxExecute/uploadMediaAndText",
                dataType: "text",
                type: 'post',
                data: {thumbMediaId: thumbMediaId, content: content, appId: appId},
                cache: false,
                success: function (result) {
                    $("#mediaId").val(result);
                    getCode("check","微信内容设置成功！");
                },
                error: function (error) {
                    getCode("check","系统错误！"+ error);
                }
            });
        }

        function getAppId() {
            var appId = $("input[name='wx']:checked").val();
            $("#appIdCover").val(appId);
            $("#appIdImg").val(appId);
            getwxTagList(appId);
        }

        function getwxTagList(appId) {
            $.ajax({
                url: "${ctx}/wxExecute/getwxTagList",
                dataType: "Json",
                type: 'post',
                data: {appId: appId},
                cache: false,
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                success: function (result) {
                    $("#tag").empty();
                    $("#tag").append("<option value=\"-1\">全部</option>");
                    $("#tag").val("-1");
                    if (result.errcode != null) {
                        return;
                    }
                    else if (result.tags != null) {
                        var Arr = result.tags;

                        $.each(Arr, function (index, item) {
                            $("#tag").append("<option value=\"" + item.id + "\">" + item.name + "</option>");
                        });
                    }

                },
                error: function (status, error) {
                    var Str = JSON.stringify(error);
                    alert("系统错误:" + Str);
                }
            });
        }

        var clipboard = new ClipboardJS('.copyUrl');

        clipboard.on('success', function (e) {
            getCode("add", "复制成功！");
        });

        clipboard.on('error', function (e) {
            getCode("check", "复制失败！");
        });


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
</head>
<body>
<form class="form-horizontal" role="form" id="myform" enctype="multipart/form-data">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label">ID</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="id" name="id" placeholder="id">
            <input type="hidden" id="merchantId" name="merchantId" value=""/>
            <input type="hidden" id="wxCount" name="wxCount" value="0"/>
        </div>
    </div>
    <div class="container" id="container">
        <div class="row">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label">营销方案标题:</label>
                <div class="col-sm-10">
                    <input type="text" id="title" name="title" class="form-control" disabled="disabled" value=""/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label">优惠券链接地址:</label>
                <div class="col-sm-8">
                    <input type="text" id="couponUrl" readonly="true" class="form-control " name="couponUrl" value=""/>
                </div>
                <div class="col-sm-2">
                    <button <%--class="copyUrl"--%> class="form-control " data-clipboard-target="#couponUrl">复制</button>
                </div>
            </div>

        </div>
        <div class="row" id="wxDiv">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label">请选择公众号:</label>
                <div class="col-sm-9" id="wxInfoDiv">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label">选择素材图片:</label>
                <div class="col-sm-6">
                    <input type="text" id="ImageUrl" name="ImageUrl" readonly="true"
                           value="" class="form-control"/>
                    <input type="text" id="fileImg" name="fileImg" class="col-sm-10" hidden/>
                    <input type="hidden" id="appIdImg" name="appIdImg" value=""/>
                </div>
                <div class="col-sm-2">
                    <input <%--class="copyUrl"--%> type="button" class="form-control" data-clipboard-target="#ImageUrl"
                                                   value="复制"/>
                </div>
                <div class="col-sm-2">
                    <input type="button" value="上传图片素材" class="form-control" onclick="uploadImage();"/>
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
        <div class="row">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label">选择封面图片:</label>
                <div class="col-sm-6">

                    <input type="text" class="form-control" id="thumbMediaId" name="thumbMediaId" disabled="disabled"
                           value=""/>
                    <input type="text" id="fileCover" name="fileCover" class="col-sm-10" hidden/>
                    <input type="hidden" id="appIdCover" name="appIdCover" value=""/>
                </div>
                <div class="col-sm-2">
                    <input <%--class="copyUrl"--%> type="button" class="form-control"
                                                   data-clipboard-target="#thumbMediaId"
                                                   value="复制"/>
                </div>
                <div class="col-sm-2">
                    <input type="button" class="form-control" value="设置封面" onclick="uploadCover();"/>

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
        <div class="row" id="contentDiv">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label">微信营销内容:</label>
                <div class="col-sm-10" <%--style="font-size: 14px;width: 650px;margin-bottom: 0px"--%>>
                    <input id="noticeContent" name="noticeContent" type="hidden">
                    <div id="summernote" style="margin-bottom: 0px"></div>

                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label"></label>
                <div class="col-sm-8">
                    <input type="text" id="mediaId" class="form-control" name="mediaId" disabled="disabled"
                           value=""/>
                </div>
                <div class="col-sm-2">
                    <input type="button" value="保存图文素材" class="form-control" onclick="uploadMediaAndText()"/>
                </div>
            </div>
        </div>
        <div class="row" id="isTag">
            <div class="form-group col-md-11">
                <label for="tag" class="col-sm-2 control-label">群发对象:</label>
                <div class="col-sm-5" id="divtag">
                    <select id="tag" name="tag" class="form-control col-sm-5">
                    </select>

                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
