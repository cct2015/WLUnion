<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>权限管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <%--<link href="${ctx}/static/zTree/css/css/zTreeStyle.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/static/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css"/>--%>
    <style>
        .ztree li {
            padding: 0;
            background-color: whitesmoke;
            margin: 0;
            list-style: none;
            line-height: 20px;
            text-align: left;

            outline: 0;
        }
        .ztree ul {
            background-color: whitesmoke;
        }
    </style>
</head>
<body>
<%--<script src="${ctx}/static/zTree/js/jquery.ztree.all.js"></script>
<script src="${ctx}/static/zTree/js/jquery.ztree.exedit.js"></script>--%>
<form class="form-horizontal" role="form" id="myform">
    <div class="container">
        <div style="margin-left: 20px;margin-top: 10px">
            <div class="row">
                <div class="row col-sm-offset-2" >
                    <h3 style="">权限修改</h3>
                </div>
                <div class="row row col-sm-offset-3">
                    <ul id="tree" class="ztree" style="width:230px; overflow:auto;background-color: whitesmoke"></ul>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    var zNodes;
    var setting = {
        view: {
            selectedMulti: false,
            showIcon:true,
            showLine:false
        },
        check: {
            enable: true,
            chkStyle:"checkbox",
            chkboxType: { "Y": "ps", "N": "ps" }
        },
        async: {
            enable: true,
            contentType: "application/json",
            /*url: "http://host/getNode.php",*/
            autoParam: ["id", "pid"]
        },
        data: {
            simpleData: {
                isParent:true,
                enable: true,
                idKey: "id",
                pIdKey: "pid",
                rootPid: null
            }
        },
        callback: {//回调函数
        },
        edit: {

            drag: {
                isCopy: false,
                isMove: false
            },
            enable: true,
            showRemoveBtn: false,
            showRenameBtn: false
        }
    };


    $.ajax({
        url: '${ctx}/getPermission',
        type: 'post',
        dataType: 'text',
        success: function (data) {
            zNodes = eval(data);
            $.fn.zTree.init($("#tree"), setting, zNodes);
            var treeObj = $.fn.zTree.getZTreeObj("tree");//获得ztree对象
            // 让ztree节点处于展开状态
            treeObj.expandAll(true);


            $.ajax({
                url: '${ctx}/getHavePermission',
                type: 'post',
                data:{roleId:$('#roleId').val()},
                dataType: 'text',
                success: function (data) {
                    //console.log(data);
                    if(data!=null){

                        var obj = eval(data);
                        $(obj).each(function (index) {
                            var val = obj[index];
                            var tid=val.id;
                            var nodes = treeObj.getNodeByParam("id", tid, null);
                            treeObj.checkNode(nodes, true, false);
                        });
                        /*for(var i=0;i<=data.length;i++){
                         console.log(data[i].id);
                         var node = zTree.getNodeByParam("id",data[i].id);
                         zTree.checkNode(node, true, true);
                         }*/
                        //treeObj.updateNode(node);
                    }

                },
                error: function (msg) {
                    getCode("check","权限获取异常");
                }
            });



        },
        error: function (msg) {
            getCode("check","权限获取异常");
        }
    });









    var isclick = true;


    //鼠标左键单击


    function setFontCss(treeId, treeNode) {
        return treeNode.pid == null ? {color: "black"} : {};
    };


</script>
</body>
</html>
