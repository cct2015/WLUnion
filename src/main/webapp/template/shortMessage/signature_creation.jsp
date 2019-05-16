<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<style>


    .gallery {
        height: 160px;
        width: 140px;
        background-color: gainsboro;
        float: left
    }

    .upload {
        float: left;
    }

    .galleryauth {
        height: 160px;
        width: 140px;
        background-color: gainsboro;
        float: left
    }

    .galleryauthLicense {
        height: 160px;
        width: 140px;
        background-color: gainsboro;
        float: left
    }

    .galleryproves {
        height: 160px;
        width: 140px;
        background-color: gainsboro;
        float: left
    }

    .img {
        width: 140px;
        height: 160px;
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

    .month {
        padding-left: 5px;
    }

    .year {
        padding-left: 5px;
    }
</style>
<body>
<form class="form-horizontal" enctype="multipart/form-data" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label">ID</label>
        <div class="col-sm-9">
            <input type="text" value="" class="form-control" id="id" name="id" placeholder="id">
        </div>
    </div>
    <div class="container" id="container">
        <div class="row">
            <div class="form-group col-md-10">
                <label for="signature" class="col-md-3 control-label">*设置签名：</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" id="signature" name="signature" placeholder="">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label for="type" class="col-md-3 control-label">*签名类型：</label>
                <div class="col-md-7">
                    <select class="form-control" id="type" name="type">
                        <option value="3">短信营销</option>
                        <option value="2">短信通知</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label for="use" class="col-md-3 control-label">*签名用途：</label>
                <div class="col-md-7">
                    <select class="form-control" id="use" name="use" onchange="showDiv()">
                        <option value="0" name="firstValue" id="firstValue">企业使用，签名用于自有产品</option>
                        <option value="1" name="secondValue">企业使用，签名用于非自有产品</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="license" class="col-md-3 control-label">*营业执照：</label>
                <div class="col-md-7">
                    <div id="upload" class="btn btn-primary upload">选择图片</div>
                    <input id="license" type="file" name="license" style="display:none">
                    <div class="gallery" id="gallery"></div>
                    <div style="float: left">JPG或PNG格式，文件大小不超过5M</div>
                    <input type="text" id="licensefileName" name="licensefileName" hidden>
                    <input type="text" id="licenseUrl" name="licenseUrl" hidden>
                    <input type="text" id="licenseSize" name="licenseSize" hidden>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-6 col-lg-offset-1">
                <label for="licenseStart" class=" col-sm-5 control-label">*营业执照有效期：</label>
                <div class=" input-group col-sm-6 date datetime hasDatepicker  "
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="licenseStart"
                           id="licenseStart" placeholder="开始时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>

            </div>
            <div class="form-group col-md-6 ">
                <label for="licenseEnd" class="col-md-1 control-label">到：</label>
                <div class=" input-group col-sm-6 date datetime hasDatepicker  "
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="licenseEnd"
                           id="licenseEnd" placeholder="截至时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>
        </div>
        <div class="row" name="authShow" id="authShow" style="display: none">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="auth" class="col-md-3 control-label">*授权委托书：</label>
                <div class="col-md-7">

                    <div id="uploadauth" class="btn btn-primary upload">选择图片</div>
                    <input id="auth" type="file" name="auth" style="display:none">
                    <div class="galleryauth" id="galleryauth"></div>
                    <div style="float: left">JPG或PNG格式，文件大小不超过5M</div>
                    <input type="text" id="authfileName" name="authfileName" hidden>
                    <input type="text" id="authUrl" name="authUrl" hidden>
                    <input type="text" id="authSize" name="authSize" hidden>
                    <div><a href="${ctx}/static/excelfile/sqs.docx" style="background-color: whitesmoke">下载授权委托书模板</a>
                    </div>
                    <%--<input type="file" id="auth" name="auth">--%>
                </div>
            </div>
        </div>
        <div class="row" id="authLicenseShow" style="display: none">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="authLicense" class="col-md-3 control-label">*授权单位营业执照：</label>
                <div class="col-md-7">
                    <div id="uploadauthLicense" class="btn btn-primary upload">选择图片</div>
                    <input id="authLicense" type="file" name="authLicense" style="display:none">
                    <div class="galleryauthLicense" id="galleryauthLicense"></div>
                    <div style="float: left">JPG或PNG格式，文件大小不超过5M</div>
                    <%--<input type="file" id="authLicense" name="authLicense">--%>
                    <input type="text" id="authLicensefileName" name="authLicensefileName" hidden>
                    <input type="text" id="authLicenseUrl" name="authLicenseUrl" hidden>
                    <input type="text" id="authLicenseSize" name="authLicenseSize" hidden>
                </div>
            </div>
        </div>
        <div class="row" id="authLicenseDateShow" style="display: none">
            <div class="form-group col-md-6 col-lg-offset-1">
                <label for="authLicenseStart" class=" col-sm-5 control-label">授权单位营业执照有效期：</label>
                <div class=" input-group col-sm-6 date datetime hasDatepicker  "
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value=""
                           name="authLicenseStart"
                           id="authLicenseStart" placeholder="开始时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>

            </div>
            <div class="form-group col-md-6 ">
                <label for="authLicenseEnd" class="col-md-1 control-label">到：</label>
                <div class=" input-group col-sm-6 date datetime hasDatepicker  "
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="authLicenseEnd"
                           id="authLicenseEnd" placeholder="截至时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="proves" class="col-md-3 control-label">其他证明信息：</label>
                <div class="col-md-7">
                    <div id="uploadproves" class="btn btn-primary upload">选择图片</div>
                    <input id="proves" type="file" name="proves" style="display:none">
                    <div class="galleryproves" id="galleryproves"></div>
                    <div style="float: left">JPG或PNG格式，文件大小不超过5M</div>
                    <div><a href="${ctx}/static/excelfile/spt.docx" style="background-color: whitesmoke">下载短信证明模板</a>
                    </div>
                    <%--<input type="file" id="proves" name="proves">--%>
                    <input type="text" id="provesfileName" name="provesfileName" hidden>
                    <input type="text" id="provesUrl" name="provesUrl" hidden>
                    <input type="text" id="provesSize" name="provesSize" hidden>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="remark" class="col-md-3 control-label">备注：</label>
                <div class="col-md-7">
                    <textarea class="form-control" id="remark" name="remark"
                              placeholder="请简单描述下你申请的短信签名的使用场景，以便我们能更快的审核"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label for="staffId" class="col-md-3 control-label">*企业员工Id：</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" id="staffId" name="staffId" placeholder="">
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    $('.datetime').datetimepicker({
        minView: "month", //选择日期后，不会再跳转去选择时分秒
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        todayBtn: 0,
        autoclose: 1,
    });
    $("#upload").click(function () {
        $("#license").trigger("click");
    })
    $("#license").change(function () {
        document.getElementById("gallery").innerHTML = "";
        var img = document.getElementById("license").files;
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
            imgBox.appendChild(box);
            var body = document.getElementsByClassName("gallery")[0];
            body.appendChild(imgBox);
        }

        var file2 = document.getElementById("license").files[0];
        var file = new FormData();
        file.append("file", file2);
        $.ajax({
            type: 'post',
            url: '${ctx}/shortMessage/fileUpload',
            data: file,
            contentType: false,
            processData: false,
            success: function (data) {
                getCode("add", "导入成功")
                if (data != null) {
                    document.getElementById("licensefileName").value = data.name;
                    document.getElementById("licenseUrl").value = data.url;
                    document.getElementById("licenseSize").value = data.size;
                }
            }, error: function () {
                getCode("add", "导入失败")
            }
        });


    })


    $("#uploadauth").click(function () {
        $("#auth").trigger("click");
    })
    $("#auth").change(function () {
        document.getElementById("galleryauth").innerHTML = "";
        var img = document.getElementById("auth").files;
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
            imgBox.appendChild(box);
            var body = document.getElementsByClassName("galleryauth")[0];
            body.appendChild(imgBox);
        }
        var file2 = document.getElementById("auth").files[0];
        var file = new FormData();
        file.append("file", file2);
        $.ajax({
            type: 'post',
            url: '${ctx}/shortMessage/fileUpload',
            data: file,
            contentType: false,
            processData: false,
            success: function (data) {

                getCode("add", "导入成功")
                if (data != null) {
                    document.getElementById("authfileName").value = data.name;
                    document.getElementById("authUrl").value = data.url;
                    document.getElementById("authSize").value = data.size;
                }
            }, error: function () {
                getCode("add", "导入失败")
            }
        });
    })


    $("#uploadauthLicense").click(function () {
        $("#authLicense").trigger("click");
    })
    $("#authLicense").change(function () {
        document.getElementById("galleryauthLicense").innerHTML = "";
        var img = document.getElementById("authLicense").files;
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
            imgBox.appendChild(box);
            var body = document.getElementsByClassName("galleryauthLicense")[0];
            body.appendChild(imgBox);
        }
        var file2 = document.getElementById("authLicense").files[0];
        var file = new FormData();
        file.append("file", file2);
        $.ajax({
            type: 'post',
            url: '${ctx}/shortMessage/fileUpload',
            data: file,
            contentType: false,
            processData: false,
            success: function (data) {

                getCode("add", "导入成功")
                if (data != null) {
                    document.getElementById("authLicensefileName").value = data.name;
                    document.getElementById("authLicenseUrl").value = data.url;
                    document.getElementById("authLicenseSize").value = data.size;
                }
            }, error: function () {
                getCode("add", "导入失败")
            }
        });
    })


    $("#uploadproves").click(function () {
        $("#proves").trigger("click");
    })
    $("#proves").change(function () {
        document.getElementById("galleryproves").innerHTML = "";
        var img = document.getElementById("proves").files;
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
            imgBox.appendChild(box);
            var body = document.getElementsByClassName("galleryproves")[0];
            body.appendChild(imgBox);
        }
        var file2 = document.getElementById("proves").files[0];
        var file = new FormData();
        file.append("file", file2);
        $.ajax({
            type: 'post',
            url: '${ctx}/shortMessage/fileUpload',
            data: file,
            contentType: false,
            processData: false,
            success: function (data) {

                getCode("add", "导入成功")
                if (data != null) {
                    document.getElementById("provesfileName").value = data.name;
                    document.getElementById("provesUrl").value = data.url;
                    document.getElementById("provesSize").value = data.size;
                }
            }, error: function () {
                getCode("add", "导入失败")
            }
        });
    })

    function showDiv() {
        var mySelect = document.getElementById("use");   //定位id（获取select）
        var index = mySelect.selectedIndex;   //选中索引（选取select中option选中的第几个）
        var text = mySelect.options[index].text; //获取选中文本，即option标签对之间的文字
        var value = mySelect.options[index].value;   //获取选中值
        if (mySelect.options[0].selected) {  //注意index是从0开始的
            $("#authShow").css("display", "none");
            $("#authLicenseShow").css("display", "none");
            $("#authLicenseDateShow").css("display", "none");
            $("#provesShow").css("display", "none");
        } else {
            $("#authShow").css("display", "block");
            $("#authLicenseShow").css("display", "block");
            $("#authLicenseDateShow").css("display", "block");
            $("#provesShow").css("display", "block");
        }

        /*if($("#firstValue").is(":checked")){
            $("#authShow").css("display","block");
        }else {
            $("#authShow").css("display","none");
        }*/
    }
</script>
</body>
</html>
