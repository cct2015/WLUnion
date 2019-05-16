<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>行业资料</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script src="${ctx}/static/jqGrid/js/jquery.min.js"></script>
    <link href="${ctx}/static/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css"/>
    <%--<link href="${ctx}/static/css/awesomeStyle/awesome.css" rel="stylesheet" type="text/css"/>
        --%>

    <%--<link href="${ctx}/static/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>--%>

    <style>
        div#rMenu {
            position: absolute;
            visibility: hidden;
            top: 0;
            background-color: rgba(255, 255, 255, 0);
            text-align: left;
            padding: 2px;
        }

        div#rMenu ul li {
            margin: 1px 0;
            padding: 0 5px;
            cursor: pointer;
            list-style: none outside none;
            background-color: #DFDFDF;
        }

        .ztree * {
            padding: 0;
            margin: 0;
            font-size: 16px;
            font-family: Verdana, Arial, Helvetica, AppleGothic, sans-serif;
        }

        .ztree li {
            padding: 0;
            background-color: whitesmoke;
            margin: 0;
            list-style: none;
            line-height: 20px;
            text-align: left;
            white-space: nowrap;
            outline: 0;
        }

        .ztree li a {
            padding-right: 3px;
            margin: 0;
            cursor: pointer;
            height: 24px;
            color: #333;
            background-color: transparent;
            text-decoration: none;
            vertical-align: top;
            display: inline-block;
        }
    </style>
</head>
<body class="nav-md">
<script src="${ctx}/static/zTree/js/jquery.ztree.all.js"></script>
<script src="${ctx}/static/zTree/js/jquery.ztree.exedit.js"></script>
<div class="container body">
    <div class="right_col" role="main" style="margin-left: 200px;padding-top: 0px">
        <div id="rMenu">
            <ul>
                <li id="addDom" class="list-group-item" onclick="addHoverDom()">添加顶级行业</li>
                <li id="addSubordinateDom" class="list-group-item" onclick="addSubordinateHoverDom()">添加下级行业</li>
                <li id="updateDom" class="list-group-item" onclick="updateHoverDom()">修改行业</li>
                <li id="deleteDom" class="list-group-item" onclick="removeHoverDom()">删除节点</li>
            </ul>
        </div>
        <div style="margin-left: 3%;height: 20%">
            <div class="x_title">
                <h2>行业分类</h2>
                <div class="clearfix"></div>
            </div>
        </div>
        <div id="myTreeDiv" style="width:100%;heigth:100%;text-align: center;">
            <div style="margin-left: 30%;margin-top: 0px">
                <div>
                    <ul id="classifytree" class="ztree"
                        style="margin-right:10px;width:40%;height: 100%; color:red;overflow:auto;background-color: whitesmoke"></ul>
                </div>
            </div>

        </div>

    </div>
</div>
<script>
    var zNodes;
    var selectId;
    var setting = {

        view: {
            selectedMulti: false,
            showIcon: true,
            fontCss: setFontCss
        },
        check: {
            enable: false
        },
        async: {
            enable: true,
            contentType: "application/json",
            /*url: "http://host/getNode.php",*/
            autoParam: ["id", "pid"]
        },
        data: {
            key: {
                name: "industryName"
            },
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPid: null
            }
        },
        callback: {//回调函数
            onClick: zTreeOnClick,// 节点被点击时调用*!/
            /*onDblClick: zTreeOnDblClick,// 节点被双击时调用*!/*/
            /*onRightClick: zTreeOnRightClick,//节点被右击时调用*!/*/


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
        url: '${ctx}/baseIndustry/selectAll2',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            zNodes = eval(data);
            $.fn.zTree.init($("#classifytree"), setting, zNodes);
            var treeObj = $.fn.zTree.getZTreeObj("tree");//获得ztree对象//让ztree节点处于展开状态

        },
        error: function (msg) {
            alert('树加载异常!');
        }
    });
    var isclick = true;

    function zTreeOnClick(event, treeId, treeNode) {


        if (!treeNode) {
            return;
        } else if (event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
            showRMenu("root", event.clientX, event.clientY);
        } else if (treeNode && !treeNode.noR) {
            showRMenu("node", event.clientX, event.clientY);
        }


    }

    function zTreeOnRightClick(event, treeId, treeNode) {


        if (!treeNode) {
            return;
        } else if (event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
            showRMenu("root", event.clientX, event.clientY);
        } else if (treeNode && !treeNode.noR) {
            showRMenu("node", event.clientX, event.clientY);
        }
    };


    //添加顶级行业
    function addHoverDom(treeId, treeNode) {
        $("#rMenu").css("visibility", "hidden");
        var zTreeObj = $.fn.zTree.getZTreeObj("classifytree");
        var selectedNodes = zTreeObj.getSelectedNodes();
        if (selectedNodes.length == 0) {
            getCode("check", "请先选择行业节点");
            return;
        }
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPEer_DEFAULT,
            title: "<span style=\"color: #ab8ce4\">新增一条数据</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/dataManage/baseIndustry.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            onshown: function () {
            },
            buttons: [{
                id: 'btn-form-submit',
                label: '提交',
                icon: 'fa fa-check-circle',
                cssClass: 'btn-primary',
                action: function (dialogItself) {  //点击事件
                    var json = {
                        'id': $.trim($("#myform").find("#id").val()),
                        'industryName': $.trim($("#myform").find("#industryName").val()),
                        'parentId': "",

                    };
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
                            industryName: {
                                validators: {
                                    notEmpty: {
                                        message: '行业名不能为空！'
                                    },
                                }
                            }
                        }
                    });
                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                    bootstrapValidator.validate();
                    if (bootstrapValidator.isValid()) {
                        $.ajax({
                                url: "${ctx}/baseIndustry/insert",
                                data: json,
                                dataType: "json",
                                cache: false,
                                success: function (response) {
                                    if (response != null) {


                                        dialogItself.close();
                                        getCode('add', '添加成功');
                                        setTimeout("window.location.reload();", 500);

                                    } else {
                                        getCode('add', '添加失败');

                                    }
                                },

                                error: function (textStatus, e) {
                                    getCode('add', '系统ajax交互错误');

                                }
                            }
                        );
                    }
                }
            }, {
                label: '关闭',
                icon: 'fa fa-close',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }]
        });

    };

    //添加下级行业
    function addSubordinateHoverDom(treeId, treeNode) {
        $("#rMenu").css("visibility", "hidden");
        var zTreeObj = $.fn.zTree.getZTreeObj("classifytree");
        var selectedNodes = zTreeObj.getSelectedNodes();
        if (selectedNodes.length == 0) {
            getCode("check", "请先选择上级行业节点");
            return;
        }
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPEer_DEFAULT,
            title: "<span style=\"color: #ab8ce4\">新增一条数据</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/dataManage/baseIndustry.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            onshown: function () {

            },
            buttons: [{
                id: 'btn-form-submit',
                label: '提交',
                icon: 'fa fa-check-circle',
                cssClass: 'btn-primary',
                action: function (dialogItself) {  //点击事件
                    var json = {
                        'id': $.trim($("#myform").find("#id").val()),
                        'industryName': $.trim($("#myform").find("#industryName").val()),
                        'parentId': selectedNodes[0].id,

                    };
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
                            industryName: {
                                validators: {
                                    notEmpty: {
                                        message: '行业名不能为空！'
                                    },
                                }
                            }
                        }
                    });
                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                    bootstrapValidator.validate();
                    if (bootstrapValidator.isValid()) {
                        $.ajax({
                                url: "${ctx}/baseIndustry/insert",
                                data: json,
                                dataType: "json",
                                cache: false,
                                success: function (response) {
                                    if (response != null) {


                                        dialogItself.close();
                                        getCode('add', '添加成功');
                                        setTimeout("window.location.reload();", 500);

                                    } else {
                                        getCode('add', '添加失败');

                                    }
                                },

                                error: function (textStatus, e) {
                                    getCode('add', '系统ajax交互错误');

                                }
                            }
                        );
                    }
                }
            }, {
                label: '关闭',
                icon: 'fa fa-close',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }]
        });

    }

    //修改行业
    function updateHoverDom(treeId, treeNode) {
        $("#rMenu").css("visibility", "hidden");
        var zTreeObj = $.fn.zTree.getZTreeObj("classifytree");
        var selectedNodes = zTreeObj.getSelectedNodes();
        if (selectedNodes.length == 0) {
            getCode("check", "请先选择行业节点");
            return;
        }
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPEer_DEFAULT,
            title: "<span style=\"color: #ab8ce4\">修改行业数据</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/dataManage/baseIndustry.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            onshown: function () {

                $('#id').val(selectedNodes[0].id),
                    $('#industryName').val(selectedNodes[0].industryName)
            },
            buttons: [{
                id: 'btn-form-submit',
                label: '提交',
                icon: 'fa fa-check-circle',
                cssClass: 'btn-primary',
                action: function (dialogItself) {  //点击事件
                    var json = {
                        'id': $.trim($("#myform").find("#id").val()),
                        'industryName': $.trim($("#myform").find("#industryName").val()),
                        'parentId': selectedNodes[0].parentId,

                    };
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
                            industryName: {
                                validators: {
                                    notEmpty: {
                                        message: '行业名不能为空！'
                                    },
                                }
                            }
                        }
                    });
                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                    bootstrapValidator.validate();
                    if (bootstrapValidator.isValid()) {
                        $.ajax({
                            url: "${ctx}/baseIndustry/updateById",
                            data: json,
                            dataType: "json",
                            cache: false,
                            success: function (response) {
                                if (response != null) {


                                    dialogItself.close();
                                    getCode('update', "修改成功!");
                                    setTimeout("window.location.reload();", 500);
                                } else {
                                    getCode('update', "修改失败!");

                                }
                            },

                            error: function (textStatus, e) {
                                getCode('update', "系统ajax交互错误!");

                            }
                        });
                    }
                }
            }, {
                label: '关闭',
                icon: 'fa fa-close',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }]
        });

    }

    function removeHoverDom(treeId, treeNode) {
        $("#rMenu").css("visibility", "hidden");

        var zTreeObj = $.fn.zTree.getZTreeObj("classifytree");
        var selectedNodes = zTreeObj.getSelectedNodes();


        if (selectedNodes.length == 0) {
            getCode("check", "请先选择行业节点");
            return;
        }
        var id = selectedNodes[0].id;

        var nodes=zTreeObj.getNodeByParam('parentId',id);

        if(nodes!=null){
            getCode("check", "本行业还有下级行业，不能删除");
            return;
        }
        myConfirm1('${ctx}/baseIndustry/deleteById', id);


    }
    

    var url = '';
    var id = '';

    function myConfirm1(url1, id1) {

        url = url1;
        id = id1;
        notif_confirm({
            'message': '确认删除?',
            'textaccept': '确认!',
            'textcancel': '取消',
            'fullscreen': true,
            'callback': myCallback2
        });


    }

    var myCallback2 = function (choice) {
        console.log('choice', choice);
        console.log('url', url);
        console.log('id', id);
        if (choice) {

            var json = {
                'id': id
            }
            $.post(url, json).done(function (data) {
                notif({
                    'type': 'success',
                    'msg': '删除成功!',
                    'timeout': 1000,
                    'position': 'center'
                })
                window.location.reload();


            }).fail(function (data) {
                notif({
                    'type': 'success',
                    'msg': '删除失败!',
                    'timeout': 1000,
                    'position': 'center'
                })

            });

        } else {
            notif({
                'type': 'error',
                'msg': '取消成功！',
                'timeout': 1000,
                'position': 'center'
            })

        }
    }

    //显示右键菜单
    function showRMenu(type, x, y) {

        $("#rMenu").show();
        $("#rMenu").css("top", y + "px");
        $("#rMenu").css("left", x + "px");
        $("#rMenu").css("visibility", "visible");
        $("body").bind("mousedown", onBodyMouseDown);
    }

    //隐藏右键菜单
    function hideRMenu() {
        $("#rMenu").css("visibility", "hidden"); //设置右键菜单不可见
        $("body").unbind("mousedown", onBodyMouseDown);
    }

    //鼠标点击事件不在节点上时隐藏右键菜单
    $(function () {
        $("body").bind(
            "mousedown",
            function (event) {

                if (!(event.target.id == "rMenu2" || $(event.target)
                        .parents("#rMenu").length > 0)) {
                    $("#rMenu").hide();
                }
            });
    });

    //鼠标按下事件
    function onBodyMouseDown(event) {
        if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
            $("#rMenu").css("visibility", "hidden");
        }
    }

    //设置字体颜色
    function setFontCss(treeId, treeNode) {
        return treeNode.pid == null ? {color: "block"} : {};
    };


</script>
</body>

</html>
