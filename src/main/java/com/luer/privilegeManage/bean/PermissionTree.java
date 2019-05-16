package com.luer.privilegeManage.bean;

import lombok.Data;

/**
 * Created by 87961 on 2019/1/3.
 */
@Data
public class PermissionTree {

    //id
    private String id;
    //parentId
    private String pId;
    //节点名称
    private String name;

    private String RoleId;

    private String permissionId;

    private Integer permissionLevel;

    private Integer permissionOrder;
}
