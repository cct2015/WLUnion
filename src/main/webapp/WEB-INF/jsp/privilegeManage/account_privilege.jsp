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
    <title>权限管理</title>

</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">

        <input hidden="hidden" id="ctx" value="${ctx}">

        <div class="x_panel">
            <div class="x_title">
                <h2>权限管理</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">

                <div>
                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>
                </div>
                <script type="text/javascript">
                    $(document).ready(function () {

                        $("#jqGrid").jqGrid({
                            url: '${ctx}/getSysUser',
                            styleUI : 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames : [ '用户名','创建时间','角色','操作'],
                            colModel : [ {name : 'name',index : 'name',width:'80px'},
                                {name : 'addTime', index : 'addTime', width:'50px' },
                                {name : 'roleName', index : 'roleName',width:'80px'},
                                { name: 'Edit', index: 'Edit', sortable: false, align: "center", width: "100px" },
                            ],

                            gridComplete: function () {
                                var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                                for (var i = 0; i < ids.length; i++) {
                                    var id = ids[i];
                                    /*var editBtn = "<a href='#' style='color:#f60' onclick='OpenAllocationDialog()' >Edit</a>";*/
                                    var editBtn = "<a href='#' style='color:#f60' onclick=\"givepermisson('"+id+"')\"><div style='display:block;\n" +
                                        "width:80px;\n" +
                                        "height:30px;\n" +
                                        "background-color:#333333;\n" +
                                        "color:#FFFFFF;\n" +
                                        "text-align:center;\n" +
                                        "font-size:14px;\n" +
                                        "line-height:30px;\n" +
                                        "border-radius: 25px;\n" +
                                        "border:none;\n" +
                                        "box-shadow:none;\n" +
                                        "text-decoration: none;\n" +
                                        "transition: box-shadow 0.5s;\n" +
                                        "-webkit-transition: box-shadow 0.5s;'>授予权限</div></a>";
                                    jQuery("#jqGrid").jqGrid('setRowData', ids[i], { Edit: editBtn});
                                }

                            },
                            rowNum: 15,
                            rowList : [ 20, 15,30 ],
                            height : $(window).height,
                            autowidth : true,
                            pager : "#jqGridPager",
                            altRows:true,
                            hidegrid : false,
                            viewrecords : true,
                            recordpos : 'left',
                            loadonce : false,
                            multiselect:false,
                            loadComplete : function() {},
                            jsonReader : {
                                root : "rows",
                                page : "page",
                                total : "total",
                                records : "records",
                                repeatitems : false,
                                cell : "cell",
                                id : "id"
                            }


                        });

                        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                            refresh: false,
                            edit: false,
                            add: false,
                            del: false,
                            search: false,
                            position: "right"
                        }).navButtonAdd('#jqGridPager', {

                            caption: "添加",

                            buttonicon: "glyphicon-plus",

                            onClickButton: openDialog4Adding,

                            position: "last"

                        }).navButtonAdd('#jqGridPager', {

                            caption: "修改",

                            buttonicon: "glyphicon-edit",

                            onClickButton: openDialog4Updating,

                            position: "last"

                        }).navButtonAdd('#jqGridPager', {

                            caption: "删除",

                            buttonicon: "glyphicon-trash",

                            onClickButton: openDialog4Deleting,

                            position: "last"

                        });

                    });

                    //调用添加权限模态框
                    function OpenAllocationDialog(id){
                        var consoleDlg = $("#consoleDlg");
                        consoleDlg.find("input").removeAttr("disabled");
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增一条数据</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/account_management.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            /* onshown:function () {

                             },*/
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'password': $.trim($("#myform").find("#password").val()),
                                        'roleName': $.trim($("#myform").find("#roleName").val())
                                    };
                                    console.log(json);
                                    $.ajax({
                                        url: "${ctx}/addSysUser",
                                        data: json,
                                        dataType: "json",
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {
                                                var dataRow = {
                                                    id: response.id,    //从server端获得系统分配的id
                                                    password: response.password,
                                                    name: response.name

                                                };

                                                var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                                        "selrow");

                                                $("#jqGrid").jqGrid("addRowData", response.id, dataRow, "last");    //将新行插入到末尾

                                                dialogItself.close();
                                                getCode('add',"添加成功!");
                                                $('#jqGrid').trigger('reloadGrid');
                                                /*$('#refresh_jqGrid').trigger('click');*/
                                            } else {
                                                getCode('add',"添加失败!");
                                            }
                                        },

                                        error: function (textStatus, e) {
                                            getCode('add',"系统ajax交互错误!");
                                        }
                                    });
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


                    var openDialog4Adding = function () {

                        var consoleDlg = $("#consoleDlg");
                        consoleDlg.find("input").removeAttr("disabled");
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增一条数据</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/account_privilege.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            /* onshown:function () {

                             },*/
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'password': $.trim($("#myform").find("#password").val()),
                                        'roleName': $.trim($("#myform").find("#roleName").val())
                                    };
                                    console.log(json);
                                    $.ajax({
                                        url: "${ctx}/addSysUser",
                                        data: json,
                                        dataType: "json",
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {
                                                var dataRow = {
                                                    id: $.trim($("#myform").find("#id").val()),
                                                    nmae: $.trim($("#myform").find("#nmae").val()),
                                                    content: $.trim($("#myform").find("#roleName").val()),


                                                };

                                                var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                                        "selrow");

                                                $("#jqGrid").jqGrid("addRowData",
                                                        response.id, dataRow, "last");    //将新行插入到末尾

                                                dialogItself.close();
                                                getCode('add',"添加成功!");
                                                $('#jqGrid').trigger('reloadGrid');
                                                /*$('#refresh_jqGrid').trigger('click');*/
                                            } else {
                                                getCode('add',"添加失败!");
                                            }
                                        },

                                        error: function (textStatus, e) {
                                            getCode('add',"系统ajax交互错误!");
                                        }
                                    });
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

                    var openDialog4Updating = function () {
                        var selectedRowId = $("#jqGrid").jqGrid("getGridParam", "selrow");
                        if (selectedRowId == null | selectedRowId == "") {
                            getCode('check', '请选择行');
                            return;
                        }
                        //获得当前行各项属性
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">修改条数据</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/baseIndustry.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseIndustry/selectAll",
                                    success: function (data) {
                                        for (var i = 0; i < data.length; i++) {
                                            if(data[i].id==values.parentId){

                                                $("#parentId").append("<option selected=\"selected\"  value='" + data[i].id + "'>" + data[i].industryName + "</option>");
                                                break;
                                            }

                                            $("#parentId").append("<option  value='" + data[i].id + "'>" + data[i].industryName + "</option>");
                                        }
                                    }
                                });

                                $('#id').val(values.id),
                                        $('#industryName').val(values.industryName),
                                        $('#parentId').val(values.parentId),
                                        $('#sort').val(values.sort),
                                        $('#status').val(values.status),
                                        $('#remark').val(values.remark)


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
                                        'parentId': $.trim($("#myform").find("#parentId").val()),
                                        'sort': $.trim($("#myform").find("#sort").val()),
                                        'status': $.trim($("#myform").find("#status").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
                                    }
                                    $.ajax({
                                        url: "${ctx}/baseIndustry/updateById",
                                        data: json,
                                        dataType: "json",
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {
                                                var dataRow = {
                                                    id: $.trim($("#myform").find("#id").val()),    //从server端获得系统分配的id
                                                    industryName: $.trim($("#myform").find("#industryName").val()),
                                                    parentId: $.trim($("#myform").find("#parentId").val()),
                                                    sort: $.trim($("#myform").find("#sort").val()),
                                                    status: $.trim($("#myform").find("#status").val()),
                                                    remark: $.trim($("#myform").find("#remark").val()),

                                                };

                                                var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                                        "selrow");

                                                $("#jqGrid").jqGrid("setRowData", $.trim($("#myform").find("#id").val()), dataRow);    //将新行插入到末尾

                                                dialogItself.close();
                                                getCode('update',"修改成功!");
                                                $('#jqGrid').trigger('reloadGrid');
                                                /*$('#refresh_jqGrid').trigger('click');*/
                                            } else {
                                                getCode('update',"修改失败!");
                                            }
                                        },

                                        error: function (textStatus, e) {
                                            getCode('update',"系统ajax交互错误!");
                                        }
                                    });
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

                    var openDialog4Deleting = function (dialogItself) {
                        var id=  $("#jqGrid").jqGrid("getGridParam", "selrow");
                        if (id == null | id == "") {
                            getCode('check', '请选择行');
                            return;
                        }
                        var rowData = $("#jqGrid").jqGrid("getRowData", id);

                        console.log(rowData);
                        var params = {
                            "id": id
                        };
                        myConfirm('${ctx}/deleteUser',id);

                    };
                    function givepermisson(id) {
                        var ctx = $('#ctx').val();
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\"><i></i>权限管理</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load(ctx + '/template/systemmanager/authmanager.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                // $.get(ctx + "/getUsersByStoreID", function (data) {
                                //     $(data).each(function (index) {
                                //         //alert(this.username)
                                //         $('#userselect').append('<option value="' + this.username + '">' + this.username + '</option>');
                                //         //$('#username3').append('<option value="' + this.username + '">' + this.username + '</option>');
                                //     })
                                // })
                                var defaultData = [
                                    {
                                        text: '资料管理',
                                        tags: ['4'],
                                        nodes: [
                                            {
                                                text: '行业资料',
                                                tags: ['2'],
                                            },
                                            {
                                                text: '企业商户资料',
                                                tags: ['2'],
                                            }
                                        ]
                                    },
                                    {
                                        text: '营销方案',
                                        tags: ['4'],
                                        nodes: [
                                            {
                                                text: '营销方案查看',
                                                tags: ['0'],
                                            },
                                            {
                                                text: '历史营销方案',
                                                tags: ['0'],
                                            },
                                            {
                                                text: '营销方案申请',
                                                tags: ['0'],

                                            },
                                            {
                                                text: '营销房啊接受',
                                                tags: ['0']
                                            },
                                            {
                                                text: '营销方案执行',
                                                tags: ['0'],
                                            },
                                            {
                                                text: '下级企业营销方案',
                                                tags: ['0'],
                                            }
                                        ]
                                    },
                                    {
                                        text: '权限管理',
                                        href: '#parent1',
                                        tags: ['4'],
                                        nodes: [
                                            {
                                                text: '账号管理',
                                                href: '#child1',
                                                tags: ['2']
                                            },
                                            {
                                                text: '账号权限',
                                                href: '#child1',
                                                tags: ['2']
                                            },
                                            {
                                                text: '下级超级管理员账号管理',
                                                href: '#child1',
                                                tags: ['2']
                                            }
                                        ]
                                    },
                                    {
                                        text: '会员管理',
                                        href: '#parent1',
                                        tags: ['4'],
                                        nodes: [
                                            {
                                                text: '会员导入',
                                                href: '#child1',
                                                tags: ['2'],
                                            },
                                            {
                                                text: '会员更新',
                                                href: '#child1',
                                                tags: ['2']
                                            },
                                            {
                                                text: '会员资料',
                                                href: '#child1',
                                                tags: ['2']
                                            }
                                        ]
                                    },
                                    {
                                        text: '公众号管理',
                                        href: '#parent1',
                                        tags: ['4'],
                                        nodes: [
                                            {
                                                text: '授权',
                                                href: '#child1'
                                            },
                                            {
                                                text: '获得会员',
                                                href: '#child1',
                                                tags: ['2'],
                                            }, {
                                                text: '发消息',
                                                href: '#child1',
                                                tags: ['2']
                                            }
                                        ]
                                    },
                                    {
                                        text: '报表中心',
                                        href: '#parent1',
                                        nodes: [
                                            {
                                                text: '报表1',
                                                href: '#grandchild1',
                                                tags: ['0']
                                            },
                                            {
                                                text: '报表2',
                                                href: '#grandchild1',
                                            }
                                        ]
                                    },
                                ];

                                var $checkableTree = $('#treeview-checkable').treeview({
                                    levels: 1,
                                    data: defaultData,
                                    showIcon: false,
                                    showCheckbox: true,
                                    onNodeChecked: function (event, node) {

                                        if (node.parentId == undefined) {//没有父节点
                                            if (node.nodes == undefined) {//没有子节点

                                            } else {//有子节点
                                                $(node.nodes).each(function () {
                                                    if (this.state.checked == false) {//父节点没有选中
                                                        $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}])
                                                        if (this.nodes != undefined) {
                                                            $(this.nodes).each(function () {
                                                                if (this.state.checked == false) {
                                                                    $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}])
                                                                }
                                                            })
                                                        }
                                                    } else {
                                                    }
                                                })
                                            }
                                        } else {//有父节点
                                            var parent = $('#treeview-checkable').treeview('getParent', node.nodeId);

                                            var grandparent = $('#treeview-checkable').treeview('getParent', parent.nodeId);
                                            if (grandparent.nodeId != undefined) {
                                                grandparent.state.checked = true;
                                            }
                                            if (parent.state.checked == false) {//选中时选中也父节点
                                                $('#treeview-checkable').treeview('toggleNodeChecked', [parent.nodeId, {silent: true}])
                                            }
                                            if (node.nodes == undefined) {//没有子节点

                                            } else {//有子节点
                                                $(node.nodes).each(function () {
                                                    $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}])
                                                })
                                            }
                                        }
                                        //去除禁用的选中
                                        var list = $('#treeview-checkable').treeview('getDisabled');
                                        $(list).each(function () {
                                            //alert(this);
                                            if (this.state.checked == true) {
                                                $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}]);
                                            }
                                        })
                                    },
                                    onNodeUnchecked: function (event, node) {
                                        var brothers = $('#treeview-checkable').treeview('getSiblings', node.nodeId);//获取兄弟节点数组
                                        var flag = false;
                                        $(brothers).each(function () {
                                            if ($(this)[0].state.checked == true) {//其他兄弟有一个选中的，则父节点选中
                                                flag = true;
                                            }
                                        });
                                        if (node.nodes != undefined) {
                                            $(node.nodes).each(function () {
                                                if (this.state.checked == true) {
                                                    $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}]);
                                                    if (this.nodes != undefined) {
                                                        $(this.nodes).each(function () {
                                                            if (this.state.checked == true) {
                                                                $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}]);
                                                            }
                                                        })
                                                    }
                                                }
                                            })
                                        }
                                        var parent = $('#treeview-checkable').treeview('getParent', node.nodeId);//undefined
                                        if (parent != 'undefined') {
                                            if (flag == false) {
                                                if (parent.state != undefined) {
                                                    if (parent.state.checked == true) {
                                                        $('#treeview-checkable').treeview('toggleNodeChecked', [parent.nodeId, {silent: true}])
                                                    }
                                                }
                                            }
                                        }
                                        //去除禁用的选中
                                        var list = $('#treeview-checkable').treeview('getDisabled');
                                        $(list).each(function () {
                                            if (this.state.checked == true) {
                                                $('#treeview-checkable').treeview('toggleNodeChecked', [this.nodeId, {silent: true}]);
                                            }
                                        })
                                    }
                                });

                                $('#treeview-checkable').treeview('disableAll');

                                $.post(ctx + '/getAuth', function (date) {
                                    $(date.data).each(function () {
                                        /// alert(this);
                                        $('#treeview-checkable').treeview('enableNode', [0, {silent: true}]);
                                        $('#treeview-checkable').treeview('enableNode', [parseInt(this), {silent: true}]);
                                    })
                                })
                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function () {
                                    var arr = $('#treeview-checkable').treeview('getChecked');
                                    var nodeIds = '';
                                    $(arr).each(function (index) {
                                        if (index == 0) {
                                            nodeIds += this.nodeId;
                                        } else {
                                            nodeIds += ',' + this.nodeId;
                                        }
                                    })
                                    $.post(ctx + '/addAuths', {'auths': nodeIds, 'userId': id}, function (data) {
                                        getCode('add',"成功");
                                    });
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

                </script>
            </div>
        </div>

        <script src="${ctx}/static/js/bootstrap-treeview.js"></script>
    </div>
</div>

</body>

</html>
