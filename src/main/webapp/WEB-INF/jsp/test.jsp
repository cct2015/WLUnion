<%--
  Created by IntelliJ IDEA.
  User: 87961
  Date: 2018/12/18
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>JQGrid测试</title>
</head>
<body>

<div>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</div>


<script type="text/javascript">


    $(function(){
        $("#nav_user").addClass('active');
        var option = {
            url : '${ctx}/getUser',
            datatype : 'json',
            mtype : 'POST',
            colNames : [ 'ID','账号','密码'],
            colModel : [ {name : 'id',index : 'id',hidden : true},
                {name : 'name', index : 'name', width:'50px',align:'left' },
                {name : 'password', index : 'password',width:'80px'},
                ],
            rowNum : 15,
            rowList : [ 15, 30, 50 ],
            height : "100%",
            autowidth : true,
            pager : '#pager',
            sortname : 'id',
            altRows:true,
            hidegrid : false,
            viewrecords : true,
            recordpos : 'left',
            sortname : 'name',
            sortorder : "asc",
            loadonce : false,
            multiselect:true,
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
        };




        $("#grid").jqGrid(option);
        $("#grid").jqGrid('navGrid', '#pager', {
            edit : false,
            add : false,
            del : false,
            search : false,
            position : 'right'
        })
        <%--  		<shiro:hasPermission name="user_add"> --%>
            .navButtonAdd('#pager', {
                caption : MSG.CMN.add,
                buttonicon : "ui-icon-plus",
                onClickButton : function() {
                    toAdd()
                },
                position : "last"
            })
            <%--  		</shiro:hasPermission> --%>
            <%--  		<shiro:hasPermission name="user_edit"> --%>
            .navButtonAdd('#pager', {
                caption : MSG.CMN.modify,
                buttonicon : "ui-icon-pencil",
                onClickButton : function() {
                    toModify()
                },
                position : "last"
            })
            <%--  		</shiro:hasPermission> --%>
            <%-- 		<shiro:hasPermission name="user_delete"> --%>
            .navButtonAdd('#pager', {
                caption : MSG.CMN.del,
                buttonicon : "ui-icon-trash",
                onClickButton : function() {
                    toDelete()
                },
                position : "last"
            })
            <%--  		</shiro:hasPermission> --%>
            <%-- 		<shiro:hasPermission name="user_reset_pwd"> --%>
            .navButtonAdd('#pager', {
                caption : MSG.USER.resetPassword,
                buttonicon : "ui-icon-disk",
                onClickButton : function() {
                    toReSetPwd()
                },
                position : "last"
            })
            <%--  		</shiro:hasPermission> --%>
            <%-- 		<shiro:hasPermission name="user_reset_pwd"> --%>
            .navButtonAdd('#pager', {
                caption : MSG.USER.unlock,
                buttonicon : "ui-icon-calculator",
                onClickButton : function() {
                    unLock()
                },
                position : "last"
            });
        <%--  		</shiro:hasPermission> --%>

        $("#cancel3").click(function() {
            $("#dialog-resetpwd").modal('hide');
        });



        $("#btn_resetpwd").click(function() {
            $('#repwd_form').submit();
        });

        $("#btnQuery").click(function(){
            PLG.gridSearch('searchForm','grid');
        });
    });

    <%-- 新增数据对话框 --%>
    function toAdd(){
        BS.modalDialog("${ctx}/sys/rbac/user/openmodaluserinput?time="+new Date().getTime(), '950px', '' ,'用户信息' ,
            function(e, text){
                return saveData(this,'${ctx}/sys/rbac/user/save');
            },null, true);
    }


    <%-- 保存数据 --%>
    function saveData($model,postUrl){
        var myform = $model.find("form");
        if(!myform.valid()){ return false; }

        var data = PLG.formToJson(myform);
        data.rIds = data.roleId;
        $.post(postUrl,data,function(result){
            if(result){
                BS.infoMsg(MSG.CMN.save+' '+MSG.TIP.success,function(){
                    $("#grid").trigger("reloadGrid", [{page:1}]);
                });
            }else{
                BS.errorMsg(MSG.CMN.save+' '+MSG.TIP.fail,function(){
                    $("#grid").trigger("reloadGrid", [{page:1}]);
                });

            }
        },'json');
    }

    <%-- 修改数据对话框 --%>
    function toModify() {
        var ids = $("#grid").jqGrid('getGridParam','selarrrow');
        if($.isEmptyObject(ids) || ids.length >1) {
            BS.errorMsg(MSG.TIP.chooseOnlyOne);
            return;
        }
        var oneData = $("#grid").jqGrid('getRowData',ids[0]);
        BS.modalDialog("${ctx}/sys/rbac/user/openmodaluserinput?id="+oneData.id+"&timestamp="+new Date().getTime(), '950px', '' ,'用户信息' ,
            function(e, text){
                return saveData(this,'${ctx}/sys/rbac/user/update');
            },null, true);
    }

    <%-- 弹出删除对话框 --%>
    function toDelete() {
        var ids = $("#grid").jqGrid('getGridParam','selarrrow');
        if($.isEmptyObject(ids)) {
            BS.errorMsg(MSG.TIP.chooseToDel);
            return;
        }

        for (var i = 0; i < ids.length; i++) {
            var row = $("#grid").jqGrid('getRowData', ids[i]);
            if (row.isAdmin == 2 || row.isAdmin == 1) {
                BS.errorMsg('不能删除管理员');
                return;
            }
        }

        BS.confirm(function(){
            $.post("${ctx}/sys/rbac/user/delete",
                {ids :ids.toString() },
                function(data){
                    if(data){
                        BS.infoMsg(MSG.CMN.del+' '+MSG.TIP.success,function(){
                            $("#grid").trigger("reloadGrid");
                        });
                    }else{
                        BS.infoMsg(MSG.CMN.del+' '+MSG.TIP.fail,function(){
                            $("#grid").trigger("reloadGrid");
                        });
                    }
                }, "json");
        });
    }

    <%--  弹出重置密码对话框 --%>
    function toReSetPwd() {
        var ids = $("#grid").jqGrid('getGridParam','selarrrow');
        if($.isEmptyObject(ids) || ids.length >1) {
            BS.errorMsg(MSG.TIP.chooseOnlyOne);
            return;
        }

        var oneData = $("#grid").jqGrid('getRowData', ids[0]);

        $("#dialog-resetpwd").modal({
            keyboard : false
        });
        $("#btn_resetpwd").attr("disabled", false);
        $("#r_id").val(oneData.id);
        $("#r_name").val(oneData.name);
        $("#r_loginName").val(oneData.loginName);
        $("#r_password").val('');
        $("#r_password_again").val('');

    }

    <%-- 解锁 --%>
    function unLock() {
        var ids = $("#grid").jqGrid('getGridParam','selarrrow');
        if($.isEmptyObject(ids)) {
            BS.errorMsg(MSG.TIP.chooseOne);
            return;
        }

        $.post("${ctx}/sys/rbac/user/resetLock",
            {"ids" : ids.toString()}, function(data) {
                if (data.success) {
                    BS.infoMsg(MSG.USER.unlock+' '+MSG.TIP.success,function(){
                        $("#grid").trigger("reloadGrid");
                    });
                } else {
                    BS.infoMsg(MSG.USER.unlock+' '+MSG.TIP.fail,function(){
                        $("#grid").trigger("reloadGrid");
                    });
                }
            }, "json");

    }


    <%-- 重置密码 --%>
    function resetpwd() {
        $("#btn_resetpwd").attr("disabled", true);

        $.post('${ctx}/sys/rbac/user/resetPassword',
            {'id' : $("#r_id").val(),
                'newPassword' : $("#r_password").val()},
            function(result){
                $('#btn_resetpwd').attr("disabled", false);
                $('#dialog-resetpwd').modal('hide');
                if(result.success){
                    BS.infoMsg(MSG.CMN.save+' '+MSG.TIP.success,function(){
                        $("#grid").trigger("reloadGrid", [{page:1}]);
                    });
                }else{
                    BS.errorMsg(MSG.CMN.save+' '+MSG.TIP.fail,function(){
                        $("#grid").trigger("reloadGrid", [{page:1}]);
                    });
                }
            },'json');
    }
</script>
</body>
</html>