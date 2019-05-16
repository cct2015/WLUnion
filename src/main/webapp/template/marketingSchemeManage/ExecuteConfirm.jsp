<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>精准营销方案执行</title>
    <link href="${ctx}/static/js/summernote/summernote.css" rel="stylesheet"/>
    <link href="${ctx}/static/js/summernote/summernote-bs3.css" rel="stylesheet"/>
    <script src="${ctx}/static/js/summernote/mysummernote.js"></script>
    <script src="${ctx}/static/js/summernote/summernote-zh-CN.js"></script>
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

        .img-item {
            float: left;
        }

        .img-itemTwo {
            float: left;
        }

        {
            float: left
        ;
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
    <script>
        $(function () {
                $('#summernote').summernote(
                    {
                        minHeight: 300,
                        dialogsFade: true,
                        dialogsInBody: true,
                        disableDragAndDrop: false,
                        merchantId: $("#id").val(),
                        appId: $("#appIdImg").val(),
                        height: '380px',
                        width: '760px',
                        lang: 'zh-CN'
                    }
                );
            $("#wxMode").attr('checked', true);

            }
        );

        //列表所有短信模板
        function getSMSTemplateList()
        {
            $.ajax({
                url: "/SMSExecute/getSMSTemplateList",
                dataType: 'json',
                cache: false,
                type: 'POST',
                contentType: 'application/x-www-form-urlencoded;charset=UTF-8',//送到后台的中文数据就不会出现乱码
                success: function (result) {
                         var Str=JSON.stringify(result);
                         if(Str=="" ||Str=="[]") return;
                         $.each(result,function (index,item){
                             if(index==0)
                             {
                                 $("#templateId").append("<option value='"+item.id+"' selected='selected'>"+item.name+"</option>");
                             }
                             else
                             {
                                 $("#templateId").append("<option value='"+item.id+"'>"+item.name+"</option>");
                             }

                         });
                },
                error: function (status, e) {
                    alert("系统错误: " + e);
               }
           });
        }

        function showDiv()
        {
         if($("#wxMode").is(':checked'))
         {
             $("#wxDiv").css("display","block");
             $("#contentDiv").css("display","block");
             $("#contentTwo").css("display","block");
             $("#msgtypediv").css("display","block");
         }
         else
         {
             $("#wxDiv").css("display","none");
             $("#contentDiv").css("display","none");
             $("#contentTwo").css("display","none");
             $("#msgtypediv").css("display","none");
         }

         if($("#phoneMode").is(':checked'))
         {
             $("#templateDiv").css("display","block");
             $("#paraDiv").css("display","block");
             if($("#templateId option").length==0)
             {
                 getSMSTemplateList();
             }
         }
         else
         {
             $("#templateDiv").css("display","none");
             $("#paraDiv").css("display","none");
         }
     }
        //上传图片素材,返回URL
        function uploadImage() {
            var url = $("#fileImg").val();
            if ($.trim(url).length == 0) {
                alert("请选择图片文件！");
                return;
            }
            var appId = $("#appIdImg").val();
            /*if((appId=="")||(appid==null)){
                appId="a3f7c289b0414717b42f25ac862ad1ac";
            }*/
            if ($.trim(appId).length == 0) {
                alert("请选择公众号！");
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
                    if (response!="") {
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
                alert("请选择封面文件！");
                return;
            }

            var appId = $("#appIdCover").val();
            /*if((appId=="")||(appid==null)){
                appId="a3f7c289b0414717b42f25ac862ad1ac";
            }*/
            if ($.trim(appId).length == 0) {
                alert("请选择公众号！");
                return;
            }
            var form = new FormData();
            form.append("filePath", url);
            form.append("appIdCover", appId);
            console.log(form);
            $.ajax({
                type: 'post',
                url: '${ctx}/wxExecute/uploadCover',
                contentType: false,
                processData: false,
                data: form,
                success: function (response) {
                    if (response!="") {
                        $("#ImageUrl").val(response);
                        getCode("add", "素材上传成功！");
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
        function uploadMediaAndText()
        {
            var appId= $("input[name='wx']:checked").val();
            if($.trim(appId).length==0)
            {
                alert("请选择公众号！");
                return;
            }
            var thumbMediaId=$("#thumbMediaId").val();
            var content=$("#summernote").summernote('code');
            if($.trim(thumbMediaId).length==0)
            {
                alert("请先设置封面！");
                return;
            }
            if($.trim(content).length<10 || content=='<p><br></p>')
            {
                alert("请先设置微信内容！");
                return;
            }
            $.ajax({
                url: "${ctx}/wxExecute/uploadMediaAndText",
                dataType: "text",
                type: 'post',
                data: {thumbMediaId:thumbMediaId,content:content,appId:appId},
                cache: false,
                success: function (result) {
                    $("#mediaId").val(result);
                },
                error: function (error) {
                    alert("系统错误:" + error);
                }
            });
        }
        function getAppId()
        {
            var appId=$("input[name='wx']:checked").val();
            $("#appIdCover").val(appId);
            $("#appIdImg").val(appId);
        }
        var clipboard = new ClipboardJS('.copyUrl');

        clipboard.on('success', function(e) {
            console.log("复制成功");
            getCode("add","复制成功！");
        });

        clipboard.on('error', function(e) {
            getCode("check","复制失败！");
            console.log("复制失败");
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
                <div class="col-sm-8">

                    <input type="text" class="form-control" id="thumbMediaId" name="thumbMediaId" disabled="disabled"
                           value=""/>
                    <input type="text" id="fileCover" name="fileCover" class="col-sm-10" hidden/>
                    <input type="hidden" id="appIdCover" name="appIdCover" value=""/>
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
        <div class="row" >
            <div class="form-group col-md-7" >
                <label class="col-sm-3 control-label" >请选择触达方式:</label>
                <label class="col-sm-2 control-label" >微信:</label>
                <div class="  col-sm-5" >
                    <input type="checkbox" id="wxMode" class="form-control"    name="wxMode" onclick="showDiv();" value="0" />
                </div>
            </div>
            <div class="form-group col-md-5" >
                <label class="col-sm-4 control-label" >手机短信:</label>
                <div class="  col-sm-5">
                    <input type="checkbox" id="phoneMode" class="form-control"     name="phoneMode"  onclick="showDiv();" value="1"/>
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
        <div class="row"  id="templateDiv">
            <div class="form-group col-md-11" >
                <label class="col-sm-2 control-label" >请选择短信模板:</label>
                <div class="col-sm-10" >
                    <select id="templateId" class="form-control" name="templateId" >
                    </select>

                </div>
            </div>
        </div>
        <div class="row"  id="paraDiv">
            <div class="form-group col-md-11" >
                <label class="col-sm-2 control-label" >请填写短信参数<br />(不同的参数间以","隔开):</label>
                <div class="col-sm-10" >
                    <input type="text" id="paras" name="paras" class="form-control" value="" />

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
        <div class="row" id="contentTwo">
            <div class="form-group col-md-11">
                <label class="col-sm-2 control-label"></label>
                <div class="col-sm-8">
                    <input type="text" id="mediaId" class="form-control" name="mediaId" disabled="disabled"
                           value="" />
                </div>
                <div class="col-sm-2">
                    <input type="button" value="保存图文素材" class="form-control" onclick="uploadMediaAndText()"/>
                </div>
            </div>
        </div>

        <div class="row"  id="msgtypediv">
            <div class="form-group col-md-11" >
                <label class="col-sm-2 control-label" >消息类别:</label>
                <div class="col-sm-10" id="divtag" >
                    <select id="msgtype" name="msgtype" class="form-control" >
                        <option value="mpnews" selected="selected">图文</option>
                        <option value="text">文字</option>
                        <option value="voice">音频</option>
                        <option value="music">音乐</option>
                        <option value="image">图片</option>
                        <option value="video">视频</option>
                        <option value="wxcard">卡</option>
                        <option value="mpvideo">图视频</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
